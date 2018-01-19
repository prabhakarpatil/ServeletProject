package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CounterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private int hitCount;

	public void init() {

		hitCount = 0;
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		hitCount++;
		PrintWriter out = response.getWriter();
		String title = "Total Number of Hits:  ";
		out.println("<html>\n" + title + hitCount + "</h2>\n" + "</body>");
	}

}
