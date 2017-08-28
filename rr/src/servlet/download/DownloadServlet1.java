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

public class DownloadServlet1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String filename = req.getParameter("name");
		ServletContext context = this.getServletContext();
		String mimeType = context.getMimeType("filename");
		resp.setContentType(mimeType);
		resp.setHeader("content-disposition", "attchment;filename="+filename);
		InputStream is = context.getResourceAsStream("/"+filename);
		ServletOutputStream os = resp.getOutputStream();
//		int len=-1;
//		byte[] b=new byte[1024];
//		while((len=is.read(b))!=-1){
//			os.write(b,0,len);
//		}
		IOUtils.copy(is, os);
		os.close();
		is.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}