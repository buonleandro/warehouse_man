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

@WebServlet("/InDBpage")
public class InDBpage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DBProdotti db = new DBProdotti();

	public InDBpage() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession s = request.getSession();
		String q = request.getQueryString();
		//System.out.println(q);
		List<Prodotto> prods = db.ricercaSn(q);

		for(Prodotto p : prods){
			s.setAttribute("nomepg", p.getNome());
			s.setAttribute("marcapg", p.getMarca());
			s.setAttribute("dbpg", p.getDb());
			s.setAttribute("dlpg", p.getDl());
			s.setAttribute("prezpg", p.getPrezzo());
			s.setAttribute("copiepg", p.getNum());
			s.setAttribute("imgpg", p.getImglnk());
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void init(){

		db.createDatabase();

	}

}
