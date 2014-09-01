/**
 * Class written by: Godfrey Oguike id: 10051389
 * servlet listens until a request is sent
 * it will invoke a getWatchList()
 * rows will be returned in the form of entities
 * which will be sent to the AllWatchList.jsp
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
import come.myEbay.Entities.ItemWatch;
import come.myEbay.bean.UserBeanRemote;

@WebServlet("/AllWatchList")
public class AllWatchListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	public UserBeanRemote UserBean;
	@EJB
	private MyEbayModel model;

	public AllWatchListController() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			// return the watch list from the DB depending on the user which want to see it
			ItemWatch[] itemWatch = model.getWatchList(UserBean.getId());
			request.setAttribute("itemWatch", itemWatch); // Send to the jsp

		} catch (MyEbayException e) {

			e.printStackTrace();
		}

		// Redirect to the AllWatchList.jsp
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("AllWatchList.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
