package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import beans.Customer;
import dao.DataAccessObject;

/**
 * Servlet implementation class RegisterationServlet1
 */
@WebServlet("/RegisterationServlet1")
@MultipartConfig(location ="D:\\files")
public class RegisterationServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterationServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String uid = request.getParameter("uid");
		
		Customer c = new Customer();
		c.setCid(request.getParameter("uid"));
		c.setPwd(request.getParameter("pwd"));
		c.setName(request.getParameter("name"));
		
		if(DataAccessObject.register(c)) {
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
			Part p = request.getPart("img");
			//p.write(p.getSubmittedFileName());
			p.write(c.getCid()+ ".jpeg");

		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
			rd.forward(request, response);
		}
	}

}
