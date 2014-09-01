/**
 * Class written by: Godfrey Oguike id: 10051389
 * servlet listens until a request is sent
 * it will create an instance of Item.java and will
 * parse it as a parameter InsertItem() the entities will be inserted as a row in the DB
 * once successful the AllItems servlet will be invoked
 */

package come.myEbay.Controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ejb.EJB;
import come.myEbay.MyEbayException;
import come.myEbay.MyEbayModel;
import come.myEbay.Entities.Item;
import come.myEbay.bean.UserBeanRemote;

@WebServlet(name = "InsertItemController", urlPatterns = { "/InsertItem" })
public class InsertItemController extends HttpServlet {

	@EJB
	private UserBeanRemote UserBean;
	@EJB
	private MyEbayModel model;
	private static final long serialVersionUID = 1L;

	public InsertItemController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			
			if (!UserBean.getId().isEmpty()) {

				String path = request.getServletPath();
				
				if (path.equals("/InsertItem")) {

					String itemName = ((String) request.getParameter("title")).trim();
					String itemDesc = ((String) request.getParameter("desc")).trim();

					try {

						if (itemName != "" && itemDesc != "") {

							String itemId = "" + (int) (Math.random() * 9999);
							String sellerId = "" + UserBean.getId();
							int version = 1;
							Item x = new Item(itemId, sellerId, itemName,
									itemDesc, version);
							model.InsertItem(x);
						}

					} catch (MyEbayException ex) {
						request.setAttribute("message", ex.getMessage());
					}
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("AllItems");
					dispatcher.forward(request, response);
				}
			}
		} catch (Exception e) {

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("Login.jsp");
			dispatcher.forward(request, response);
		}
	}
}
