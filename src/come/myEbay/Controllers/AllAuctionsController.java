/**
* Class written by: Godfrey Oguike id: 10051389
* servlet listens until a request is sent
* it will invoke a getAllAuction()
* rows will be returned in the form of entities
* which will be sent to the AllAuctions.jsp
*/

package come.myEbay.Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.ejb.EJB;
import come.myEbay.MyEbayModel;
import come.myEbay.Entities.AuctionItem;
import come.myEbay.bean.UserBeanRemote;

@WebServlet(name = "AllAuctions", urlPatterns = { "/AllAuctions" })
public class AllAuctionsController extends HttpServlet {
	
	@EJB private UserBeanRemote UserBean;
	@EJB private MyEbayModel model;
	private static final long serialVersionUID = 1L;

	public AllAuctionsController() {
		super();
	}

	// no matter if a get or a post request is sent
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {

			// get the url path
			String path = request.getServletPath();
			if (path.equals("/AllAuctions")) {
				
				// get all auctions and save them in an array 
				AuctionItem[] auction = model.getAllAuction();
				request.setAttribute("auction", auction); // allow access from the jsp

				// redirect to a jsp page
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("AllAuctions.jsp");
				dispatcher.forward(request, response);
			}
	
		} catch (Exception e) {
			
			// redirect to the error jsp
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("Error.jsp");
			dispatcher.forward(request, response);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response); // <----invoke
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response); // <----invoke
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}
}
