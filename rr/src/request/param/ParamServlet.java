package request.param;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParamServlet
 */
public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取username
		String username = req.getParameter("username");
		System.out.println("username:" + username);
		// 获取爱好 多个值
		String[] values = req.getParameterValues("hobby");
		System.out.println(Arrays.toString(values));
		// 获取所有
		System.out.println("----------------------");
		Map<String, String[]> map = req.getParameterMap();
		for (String key : map.keySet()) {
			System.out.println(key + "：：" + Arrays.toString(map.get(key)));
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
