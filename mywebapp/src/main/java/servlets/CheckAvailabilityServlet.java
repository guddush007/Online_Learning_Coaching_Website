package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;  
import org.json.simple.JSONValue;

import dao.DataAccessObject;
/**
 * Servlet implementation class CheckAvailabilityServlet
 */
@WebServlet("/CheckAvailabilityServlet")
public class CheckAvailabilityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckAvailabilityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("success");
		//System.out.println(request.getParameter("uid"));
		
		InputStream in = request.getInputStream();
		StringBuilder sb = new StringBuilder();
		int ch;
		while((ch = in.read()) != -1) {
			sb.append((char)ch);
		}
		//System.out.println(sb);
		
		Object obj=JSONValue.parse(sb.toString());  
		JSONObject jsonObject = (JSONObject) obj;  
		  
		String uid = (String) jsonObject.get("uid");  
		System.out.println(uid);
		
		PrintWriter out = response.getWriter();
		if(DataAccessObject.CheckAvailability(uid))
			out.append("Available");
		else
			out.append("Not Available");
	}

}
