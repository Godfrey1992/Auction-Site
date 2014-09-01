/**
 * Class written by: Godfrey Oguike id: 10051389
 * servlet listens until a request is sent
 * depending on user selection
 * either the AUCTION table will be searched or the ITEM table
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
import come.myEbay.Entities.AuctionItem;
import come.myEbay.Entities.Item;
import come.myEbay.bean.UserBeanRemote;

@WebServlet(name = "All Search Items", urlPatterns = { "/SearchItems" })
public class SearchController extends HttpServlet {
	
	@EJB private MyEbayModel model;
	@EJB private UserBeanRemote UserBean;
	private static final long serialVersionUID = 1L;

	public SearchController() {
		super();
	}

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// get the parameters from the url and save them
		String word = request.getParameter("s").trim().toUpperCase();
		String option1 = request.getParameter("option1");
		String option2 = request.getParameter("option2");

		String path = request.getServletPath();
		if (path.equals("/SearchItems")) {
			
			// user selected option 2 = they want to search items
			if (option2 != null && option1 == null) {
				
				try {
					// search for an item using the user input
					Item[] items = model.getSearchItems(word); // return the result as an Item object
					request.setAttribute("items", items); 
				} catch (MyEbayException ex) {
					request.setAttribute("message", ex.getMessage());
				}

				// display the results in the SearchItemResults.jsp
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("SearchItemResults.jsp");
				dispatcher.forward(request, response);
				
				// user selected option 1 = they want to search auction's
			} else if (option1 != null && option2 == null) {
				
				try {
					AuctionItem[] auctionItem = model.getSearchAuctions(word); // return the result as an auctionItem object
					request.setAttribute("auctionItem", auctionItem);
				} catch (MyEbayException ex) {
					request.setAttribute("message", ex.getMessage());
				}

				// display the results in the SearchAuctionResults.jsp
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("SearchAuctionResults.jsp");
				dispatcher.forward(request, response);
			}
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
