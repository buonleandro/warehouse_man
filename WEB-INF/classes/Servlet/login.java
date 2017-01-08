package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.DBProdotti;

@WebServlet("/login")
public class login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	DBProdotti db = new DBProdotti();
	
    public login() {
    	
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Boolean result = db.cfrLogin(request.getParameter("user"), request.getParameter("pass"));
		if(result == true) {
			
			String log = "1";
			session.setAttribute("log", log);
			response.sendRedirect("./functions.jsp");
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
	}

}
