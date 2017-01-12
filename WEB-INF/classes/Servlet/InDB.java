package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.DBProdotti;
import utils.Prodotto;

@WebServlet("/InDB")
public class InDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DBProdotti db = new DBProdotti();

	public InDB() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Prodotto> prods = null;
		String q = request.getQueryString();
		//System.out.println(q);
		if(q.equals("TV")){
			prods = db.tv();
		} else if(q.equals("PC")){
			prods = db.PC();
		} else if(q.equals("TS")){
			prods = db.cell();
		} else if(q.equals("EL")){
			prods = db.elettro();
		} else if(q.equals("FO")){
			prods = db.foto();
		} else if(q.equals("CO")){
			prods = db.console();
		} else if(q.equals("all")){
			prods = db.showAll();
		}

		PrintWriter out = response.getWriter();

		out.print("<TABLE STYLE='width:100%'>");
		for(Prodotto p: prods) {
			out.print("<TR PADDING-BOTTOM='10px'>"+
					" <TD><IMG SRC="+p.getImglnk()+" STYLE='HEIGHT: 100px'></IMG></TD>"+
					" <TD><H3><A HREF=page.jsp"+p.getLnk()+">"+p.getNome()+"</A></H3></TD>"+
					" <TD STYLE='PADDING-BOTTOM:10px; word-wrap:break-word;'><H4>"+p.getDb()+"</H4></TD>"+
					"</TR>");
		}
		out.print("</TABLE>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void init(){

		db.createDatabase();

	}

}
