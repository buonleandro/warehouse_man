package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.DBProdotti;

@WebServlet("/AggiungiProdotto")
public class AggiungiProdotto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DBProdotti db = new DBProdotti();

    public AggiungiProdotto() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String sn = request.getParameter("SN");
		String nome = request.getParameter("nomeprod");
		String tipo = request.getParameter("categoria");
		String marca = request.getParameter("marca");
		double prezzo = Double.parseDouble(request.getParameter("prezzo"));
		String desb = request.getParameter("desb");
		String desl = request.getParameter("desl");
		String img = (String) session.getAttribute("file");
		int pezzi = Integer.parseInt(request.getParameter("pezzi"));
		db.aggiungiProdotto(sn, nome, tipo, marca, prezzo, desb, desl, pezzi, img);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
