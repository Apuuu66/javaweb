package web.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		ServletContext context=getServletContext();
		context.setAttribute("count", 0);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username + password);
		User user = new UserService().login(username, password);
		if (user == null) {
			response.getWriter().print("用户名和密码不匹配");
			response.setHeader("refresh","3;url=/webDemo/login.htm");
		} else {
			response.getWriter().println(user.getUsername() + "欢迎回来");
			ServletContext context = getServletContext();
			Integer cishu = (Integer) context.getAttribute("count");
			cishu++;
			context.setAttribute("count", cishu);
			
		}
	}

}
