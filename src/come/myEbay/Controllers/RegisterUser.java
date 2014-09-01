/**
 * Class written by: Godfrey Oguike id: 10051389
 * servlet listens until a request is sent
 * it will create an instance of User.java and will
 * parse it as a parameter registerUser()
 * once successful, the Login.jsp will be invoked
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
import come.myEbay.Entities.User;

@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private MyEbayModel model;

	public RegisterUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String id = "" + (int) (Math.random() * 9999);
		String userName = ((String) request.getParameter("userName")).trim();
		String password = ((String) request.getParameter("password")).trim();
		String name = ((String) request.getParameter("name")).trim();
		String email = ((String) request.getParameter("email")).trim();
		String address = ((String) request.getParameter("address")).trim();

		User user = new User(userName, address, email, id, name, password, "", 1);
		try {
			model.registerUser(user);
		} catch (MyEbayException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("Login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
