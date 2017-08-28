package web.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowPath
 */
public class ShowPath extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext context = getServletContext();
		String path = context.getRealPath("/1.html");
		System.out.println(path);

		InputStream stream = context.getResourceAsStream("/1.html");
		System.out.println(stream);

		String type = context.getMimeType("1.html");
		System.out.println(type);

		String path2 = ShowPath.class.getClassLoader().getResource("1.txt").getPath();
		System.out.println(path2);
//		InputStream resourceAsStream = ShowPath.class.getClassLoader().getResourceAsStream("ÎÄ¼þÂ·¾¶");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
