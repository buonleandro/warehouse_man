package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.DBProdotti;

@WebServlet("/ModificaProdotto")
public class ModificaProdotto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DBProdotti db = new DBProdotti();

    public ModificaProdotto() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	try {
		HttpSession session = request.getSession();
		String sn = request.getParameter("SN");
		String nome = request.getParameter("nomeprod");
		String tipo = request.getParameter("categoria");
		String marca = request.getParameter("marca");
		double prezzo = Double.parseDouble(request.getParameter("prezzo"));
		String desb = request.getParameter("desb");
		String desl = request.getParameter("desl");
		int pezzi = Integer.parseInt(request.getParameter("pezzi"));
		int id = (int) session.getAttribute("id");
			db.aggiornaProdotto(id, nome, sn, tipo, marca, desb, desl, pezzi, prezzo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
