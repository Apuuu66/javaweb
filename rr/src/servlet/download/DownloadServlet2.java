package servlet.download;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

/**
 * Servlet implementation class DownloadServlet2
 */
public class DownloadServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ�����ļ�������
		String filename = request.getParameter("name");

		// ע����������:
		filename = new String(filename.getBytes("iso8859-1"), "utf-8");

		ServletContext context = this.getServletContext();
		// �ļ�����
		// 1.�����ļ���mimeType
		String mimeType = context.getMimeType(filename);
		response.setContentType(mimeType);

		// 2.�������ص�ͷ��Ϣ
		// �����
		// response.setHeader("content-disposition",
		// "attchment;filename="+filename);

		// ��������������ļ�����ʹ��utf-8 ���Ƽ� �����ݻ��
		// response.setHeader("content-disposition",
		// "attchment;filename="+URLEncoder.encode(filename, "utf-8"));

		// ��ʽ1:ͨ���ķ�ʽ ͨ�����������
//		String newfilename = DownLoadUtils.getName(request.getHeader("user-agent"), filename);
//		response.setHeader("content-disposition", "attachment;filename=" + newfilename);

		// ��ʽ2:�����ϵķ�ʽ (8�ɺ�ʹ)
		response.setHeader("content-disposition",
				"attachment;filename=" + new String(filename.getBytes("gbk"), "iso8859-1"));
		// 3.�Կ���
		// ��ȡ������
		InputStream is = context.getResourceAsStream("/download/" + filename);

		// ��ȡ�����
		ServletOutputStream os = response.getOutputStream();

		/*
		 * int len=-1; byte[] b=new byte[1024];
		 * 
		 * while((len=is.read(b))!=-1){ os.write(b, 0, len); }
		 */

		IOUtils.copy(is, os);

		os.close();
		is.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
