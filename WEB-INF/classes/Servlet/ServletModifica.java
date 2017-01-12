package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.DBProdotti;
import utils.Prodotto;

@WebServlet("/ServletModifica")
public class ServletModifica extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DBProdotti db = new DBProdotti();

	public ServletModifica() {
		super();
	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Prodotto> prods = null;
		HttpSession s = request.getSession();
		if(((List<Prodotto>) s.getAttribute("p"))!=null){
			prods = (List<Prodotto>) s.getAttribute("p");
			s.setAttribute("p", null);
		}else{
			prods = db.showAll();
		}

		PrintWriter out = response.getWriter();

		out.print("<meta charset=utf-8>");
		out.print("<script>function showInfo() {"+
				"alert('Prodotto eliminato!');}</script>");
		out.print("<script>"+
				"function search() {"+
				"window.open('./cercamod.jsp', '_self');"+
				"}"+
				"</script>");

		out.print("<button onclick='search()' class='btn btn-sm btn-default button_search'>"+
				"<img src='images/Minimal-Magnifying-Glass.png' width='25' height='21'"+
				"alt='' /><strong>CERCA... </strong></button><br><br>");
		out.print("<TABLE STYLE='width:100%'>");
		for(Prodotto p: prods) {
			//System.out.println(p.getId());
			out.print("<TR STYLE='PADDING-BOTTOM:10px'>"+
					" <TD STYLE='PADDING-BOTTOM:10px'><IMG SRC="+p.getImglnk()+" STYLE='HEIGHT: 100px'></IMG></TD>"+
					" <TD STYLE='PADDING-BOTTOM:10px; word-wrap:break-word; width:500px'><H3>"+p.getNome()+"</H3></TD>"+
					" <TD STYLE='PADDING-BOTTOM:10px; PADDING-RIGHT:10px'><H5>"+ p.getPrezzo() +" &euro</H5></TD>"+
					" <TD STYLE='PADDING-BOTTOM:10px; PADDING-RIGHT:10px'><H5>Disp.: "+ p.getNum() +"</H5></TD>"+
					" <TD STYLE='PADDING-BOTTOM:10px'><form action='ServletTramite' method='get'><input type='hidden' name='id' value='"+p.getId()+"'><BUTTON type='submit' style='background-color: white; border: none'><IMG SRC='images/c6376f_4.png' STYLE='HEIGHT: 64px'></BUTTON></form></TD>"+
					" <TD STYLE='PADDING-BOTTOM:10px'><form action='ServletTramite' method='post'><input type='hidden' name='img' value='"+p.getImglnk()+"'><input type='hidden' name='id' value='"+p.getId()+"'><BUTTON style='background-color: white; border: none' onclick='showInfo()'><IMG SRC='images/noun_delete_45885.png' STYLE='HEIGHT: 64px'></BUTTON></form></TD>"+
					"</TR>");
		}
		out.print("</TABLE>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
