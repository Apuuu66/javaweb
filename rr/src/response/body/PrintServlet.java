package response.body;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *������Ӧ�� 
 */
public class PrintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//������Ӧ����������
				//response.setContentType("text/html;charset=utf-8");
				response.setHeader("content-type", "text/html;charset=utf-8");
				//ServletOutputStream os = response.getOutputStream();
				//��ӡ���
				//��ȡ�ַ���
				PrintWriter w = response.getWriter();
				
				w.print("<table border='1'><tr>");
				w.print("<td>�û���:</td>");
				w.print("<td>tom</td></tr>");
				w.print("<tr><td>����:</td>");
				w.print("<td>123</td>");
				w.print("</tr></table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
