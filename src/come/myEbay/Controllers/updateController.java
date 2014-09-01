/**
 * Class written by: Godfrey Oguike id: 10051389
 * servlet listens until a request is sent
 * gets and saves the parameters parsed from the jsp page
 * invokes the bidAuction() and parses 2 parameters
 * actionId, and new bid price
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

@WebServlet("/updateController")
public class updateController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@EJB
	private MyEbayModel model;

	public updateController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// get parameters from the url
		String auctionId = ((String) request.getParameter("auctionId")).trim();
		String auctionPrice = ((String) request.getParameter("newPrice"))
				.trim();
		String itemId = ((String) request.getParameter("itemId")).trim();

		try {

			// Parse Auction ID and the New price.
			model.bidAuction(auctionId, auctionPrice);

			// Redirect to the showAuction servlet. as it requires a parameter
			// we also parse itemId
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("ShowAuction?itemId=" + itemId);
			dispatcher.forward(request, response);

		} catch (MyEbayException e) {

		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
