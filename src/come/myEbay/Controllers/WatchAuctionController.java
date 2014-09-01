/**
 * Class written by: Godfrey Oguike id: 10051389
 * servlet listens until a request is sent
 * it will create an instance of Item.java and will
 * parse it as a parameter InsertItem() the entities will be inserted as a row in the DB
 * once successful the AllItems servlet will be invoked
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
import come.myEbay.Entities.Watch;
import come.myEbay.bean.UserBeanRemote;

@WebServlet("/watchAuctionController")
public class WatchAuctionController extends HttpServlet {
	
	@EJB private MyEbayModel model;
	@EJB public UserBeanRemote UserBean;
	private static final long serialVersionUID = 1L;

	public WatchAuctionController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String auctionId = ((String) request.getParameter("auctionId")).trim();
		String itemId = ((String) request.getParameter("itemId")).trim();
		String userId = UserBean.getId();
		String listId = "" + (int) (Math.random() * 9999);

		// Create an instance of Watch
		Watch watch = new Watch(listId, auctionId, itemId, userId);
		
		try {
			// invoke method and parse the new Item object as a parameter
			model.createWatchListItem(watch);

		} catch (MyEbayException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// call the AllWatchList servlet
		RequestDispatcher dispatcher = request.getRequestDispatcher("AllWatchList");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
