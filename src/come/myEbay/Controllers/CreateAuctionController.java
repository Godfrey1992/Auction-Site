/**
 * Class written by: Godfrey Oguike id: 10051389
 * servlet listens until a request is sent
 * it will create an instance of Auction.java and will
 * parse it as a parameter createAuction()
 * once successful the AllAuctions servlet will be invoked
 */

package come.myEbay.Controllers;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import come.myEbay.MyEbayException;
import come.myEbay.MyEbayModel;
import come.myEbay.Entities.Auction;
import come.myEbay.bean.UserBeanRemote;

@WebServlet("/CreateAuction")
public class CreateAuctionController extends HttpServlet {
	
	@EJB private UserBeanRemote UserBean;
	@EJB private MyEbayModel model;
	private static final long serialVersionUID = 1L;

	public CreateAuctionController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String ID = "" + ((int) (Math.random() * 9999)); // Generate an ID

		// get parameter from url
		String itemID = request.getParameter("itemID").trim();
		String sellerID = UserBean.getId();
		String startingBID = request.getParameter("startingBID").trim();
		String currentPrice = (Integer.parseInt(startingBID)) + "";
		int version = 1;

		String path = request.getServletPath();
		// check if url contains /CreateAuction
		if (path.equals("/CreateAuction")) {
			try {

				Auction auction = new Auction(ID, itemID, sellerID, startingBID, currentPrice, version);
				model.createAuction(auction);
				
				// redirect to AllAuctions servlet
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("AllAuctions");
				dispatcher.forward(request, response);

			} catch (MyEbayException ex) {
				request.setAttribute("message", ex.getMessage());
			}

			// redirect to Error.jsp
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("Error.jsp");
			dispatcher.forward(request, response);
		}else{
			
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
