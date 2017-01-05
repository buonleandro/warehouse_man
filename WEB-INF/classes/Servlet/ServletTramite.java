package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.DBProdotti;
import utils.Prodotto;

@WebServlet("/ServletTramite")
public class ServletTramite extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DBProdotti db = new DBProdotti();
	
    public ServletTramite() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		System.out.println(request.getParameter("id"));
		int id = Integer.parseInt(request.getParameter("id"));
		Prodotto p = db.showSingle(id);
		session.setAttribute("nome", p.getNome());
		session.setAttribute("sn", p.getSN());
		session.setAttribute("tipo", p.getTipo());
		session.setAttribute("marca", p.getMarca());
		session.setAttribute("desb", p.getDb());
		session.setAttribute("desl", p.getDl());
		System.out.println(p.getTipo());
		session.setAttribute("num", p.getNum());
		session.setAttribute("prez", p.getPrezzo());
		session.setAttribute("img", p.getImglnk());
		response.sendRedirect("modcampi.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
