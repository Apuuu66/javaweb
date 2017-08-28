package web.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SConnfigServlet
 */
public class SConnfigServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletConfig servletConfig = this.getServletConfig();
		String servletName = servletConfig.getServletName();
		System.out.println(servletName);
		String initParameter = servletConfig.getInitParameter("user");
		System.out.println(initParameter);
		Enumeration<String> names = servletConfig.getInitParameterNames();
		while (names.hasMoreElements()) {
			String string = (String) names.nextElement();
			System.out.println(string);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
