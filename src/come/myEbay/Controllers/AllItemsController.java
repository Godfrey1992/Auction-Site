/**
* Class written by: Godfrey Oguike id: 10051389
* servlet listens until a request is sent
* it will invoke a getAllItems()
* rows will be returned in the form of entities
* which will be sent to the AllItems.jsp
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
import come.myEbay.MyEbayException;
import come.myEbay.MyEbayModel;
import come.myEbay.Entities.Item;
import come.myEbay.bean.UserBeanRemote;

@WebServlet(name = "AllItems", urlPatterns = { "/AllItems" })
public class AllItemsController extends HttpServlet {
	
	// allow access to the bean methods
	@EJB private UserBeanRemote UserBean;
	
	@EJB private MyEbayModel model;
	private static final long serialVersionUID = 1L;

	public AllItemsController() {
		super();
	}

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			
			// Checks if the user is logged in or not
			if (!UserBean.getId().isEmpty()) {

				// does url contain /AllItems
				String path = request.getServletPath();
				if (path.equals("/AllItems")) {
					
					try {
						// return all rows in the form Item entities to be displayed
						Item[] items = model.getAllItems();
						request.setAttribute("items", items);
						
					} catch (MyEbayException ex) {
						request.setAttribute("message", ex.getMessage());
					}
					
					// redirect to the AllItems.jsp
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("AllItems.jsp");
					dispatcher.forward(request, response);
				}
			}
			
		} catch (Exception e) {

			// redirect to the Login.jsp if not logged in
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("Login.jsp");
			dispatcher.forward(request, response);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response); // <--- invoke
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response); // <--- invoke
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}
}
