package request.row;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ����������
 */
public class RowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ����ʽ
		String method = request.getMethod();
		System.out.println("��ʽ:" + method);
		// ��ȡ������Դ
		String uri = request.getRequestURI();
		System.out.println("uri:" + uri);
		StringBuffer url = request.getRequestURL();
		System.out.println("url:" + url);
		String urlTo = request.getRequestURL().toString();
		System.out.println("url:" + urlTo);
		// ��ȡ��������ַ���
		String queryString = request.getQueryString();
		System.out.println("get�������:" + queryString);
		// ��ȡЭ��汾
		String protocol = request.getProtocol();
		System.out.println("Э�飺" + protocol);
		System.out.println("----------��Ҫ��---------");
		// ��ȡ�����ip
		String ip = request.getRemoteAddr();
		System.out.println("ip:" + ip);
		// ��ȡ��Ŀ��
		String path = request.getContextPath();
		System.out.println("path:" + path);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
