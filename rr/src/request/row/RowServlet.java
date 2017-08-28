package request.row;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 操作请求行
 */
public class RowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取请求方式
		String method = request.getMethod();
		System.out.println("方式:" + method);
		// 获取请求资源
		String uri = request.getRequestURI();
		System.out.println("uri:" + uri);
		StringBuffer url = request.getRequestURL();
		System.out.println("url:" + url);
		String urlTo = request.getRequestURL().toString();
		System.out.println("url:" + urlTo);
		// 获取请求参数字符串
		String queryString = request.getQueryString();
		System.out.println("get请求参数:" + queryString);
		// 获取协议版本
		String protocol = request.getProtocol();
		System.out.println("协议：" + protocol);
		System.out.println("----------重要的---------");
		// 获取请求的ip
		String ip = request.getRemoteAddr();
		System.out.println("ip:" + ip);
		// 获取项目名
		String path = request.getContextPath();
		System.out.println("path:" + path);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
