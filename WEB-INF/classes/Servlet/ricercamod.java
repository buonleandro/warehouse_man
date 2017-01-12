package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.DBProdotti;
import utils.Prodotto;

@WebServlet("/ricercamod")
public class ricercamod extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DBProdotti db = new DBProdotti(); 
       
    public ricercamod() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession s = request.getSession();
		String sn = request.getParameter("sncerca");
		List<Prodotto> p = db.ricercaSn(sn);
		s.setAttribute("p", p);
		response.sendRedirect("./mod.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
