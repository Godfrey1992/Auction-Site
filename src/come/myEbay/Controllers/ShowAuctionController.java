/**
 * Class written by: Godfrey Oguike id: 10051389
 * servlet listens until a request is sent
 * it will invoke the getItem(id) which will search the database for the id 
 * and return the row as AuctionItem entity
 * once successful, the ShowAuction.jsp will be invoked
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

import come.myEbay.MyEbayModel;
import come.myEbay.Entities.AuctionItem;
import come.myEbay.bean.UserBeanRemote;

@WebServlet("/ShowAuction")
public class ShowAuctionController extends HttpServlet {
	@EJB
	private UserBeanRemote UserBean;
	@EJB
	private MyEbayModel model;
	private static final long serialVersionUID = 1L;
	public static String id;

	public ShowAuctionController() {
		super();
	}

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {

			String path = request.getServletPath();
			id = request.getParameter("itemId");
			if (path.equals("/ShowAuction")) {

				AuctionItem[] auctionItem = model.getItem(id);
				request.setAttribute("auctionItem", auctionItem);

				RequestDispatcher dispatcher = request
						.getRequestDispatcher("ShowAuction.jsp");
				dispatcher.forward(request, response);
			}
			
		} catch (Exception e) {

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("Error.jsp");
			dispatcher.forward(request, response);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}
}
