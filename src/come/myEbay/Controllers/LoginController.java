/**
 * Class written by: Godfrey Oguike id: 10051389
 * servlet listens until a request is sent
 * it will get the user depeding on the user name specified
 * if the password and user name is the same as what the user has entered
 * then login is sucessfull
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
import come.myEbay.Entities.User;
import come.myEbay.bean.UserBeanRemote;

@WebServlet(name = "LoginController", urlPatterns = { "/Login" })
public class LoginController extends HttpServlet {

	@EJB public MyEbayModel model;
	@EJB public UserBeanRemote UserBean;
	private static final long serialVersionUID = 1L;

	public LoginController() {
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

		String path = request.getServletPath();
		if (path.equals("/Login")) {

			// get parameters from the url and save them
			String username = ((String) request.getParameter("username")).trim();
			String password = ((String) request.getParameter("password")).trim();

			try {
				
				// check if password and user name fields aren't null
				if (username != "" && password != "") {
					
					// get the user from the database
					User user = model.getUser(username, password);

					// checks if password and username are the same as the returned user
					if (user.getUsername().contains(username) && user.getPassword().contains(password)) {

						// set bean fields
						UserBean.setId(user.getId());
						UserBean.setUserName(user.getUsername());

						// redirect to AllItems servlet
						RequestDispatcher dispatcher = request
								.getRequestDispatcher("AllItems");
						dispatcher.forward(request, response);
						
					} else {
						// redirect to Login.jsp
						RequestDispatcher dispatcher = request
								.getRequestDispatcher("Login.jsp");
						dispatcher.forward(request, response);
					}
				}
				
			} catch (MyEbayException ex) {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("AllItems");
				dispatcher.forward(request, response);
			}
		}
	}
}