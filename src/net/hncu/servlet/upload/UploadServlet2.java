package net.hncu.servlet.upload;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.ParamPart;
import com.oreilly.servlet.multipart.Part;


public class UploadServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// MultipartParser用来解析HTTP请求，并设置上传文件大小最大值
		MultipartParser mp = new MultipartParser(request,1024 * 1024 * 20);
		
		// 所有的表单字段都是一个Part实例
		Part part;
		
	   // 遍历循环每个表单字段，使用MultipartParser类中的readNextPart方法来获得part实例
		while((part = mp.readNextPart()) != null) {
			// 如果是普通表单字段
			if(part.isParam()) {
				// 获得该字段名称
				String name = part.getName();
				
				// 强制转换
				ParamPart pmp = (ParamPart)part;
				
				// 获得该字段值
				String value = pmp.getStringValue("utf-8");
				
				// 将值设置到request属性范围中
				request.setAttribute(name, value);
			}
			
			// 如果为文件域
			else if(part.isFile()) {
				// 取得文件域字段名
				String name = part.getName();
				
				// 强制转换
				FilePart flp = (FilePart)part;
				
				// 获得文件名（不是全路径文件名称）
				String value = new String (flp.getFileName().getBytes("ISO-8859-1"),"utf-8");
				
				// 将值设置到request属性范围中
				request.setAttribute(name, value);
				
				// 设置上传文件目录
				String uploadPath = getServletContext().getRealPath("/upload");
				
				// 写入文件
				try {
					flp.writeTo(new File(uploadPath,value));
				} catch (Exception e) {
					e.printStackTrace();
				}			
			}		
		}
		// 上传完成后执行跳转
		request.getRequestDispatcher("/servletUpload/result2.jsp").forward(request, response);
	}
}
