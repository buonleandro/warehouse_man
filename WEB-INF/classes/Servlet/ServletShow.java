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

import utils.Prodotto;

@WebServlet("/ServletShow")
public class ServletShow extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletShow() {
		super();
	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession s = request.getSession();
		List<Prodotto> prods = (List<Prodotto>) s.getAttribute("p");

		PrintWriter out = response.getWriter();

		out.print("<meta charset=utf-8>");

		out.print("<TABLE STYLE='width:100%'>");
		for(Prodotto p: prods) {
			//System.out.println(p.getId());
			out.print("<TR STYLE='PADDING-BOTTOM:10px'>"+
					" <TD STYLE='PADDING-BOTTOM:10px'><IMG SRC="+p.getImglnk()+" STYLE='HEIGHT: 100px'></IMG></TD>"+
					" <TD STYLE='PADDING-BOTTOM:10px; word-wrap:break-word;'><H3>"+p.getNome()+"</H3></TD>"+
					" <TD STYLE='PADDING-BOTTOM:10px; word-wrap:break-word;'><H3>"+p.getMarca()+"</H3></TD>"+
					" <TD STYLE='PADDING-BOTTOM:10px; word-wrap:break-word;'><H3>"+p.getTipo()+"</H3></TD>"+
					" <TD STYLE='PADDING-BOTTOM:10px; PADDING-RIGHT:10px'><H5>"+ p.getPrezzo() +" &#8364</H5></TD>"+
					" <TD STYLE='PADDING-BOTTOM:10px; PADDING-RIGHT:10px'><H5>Disp.: "+ p.getNum() +"</H5></TD>"+
					"</TR>");
		}
		out.print("</TABLE>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
