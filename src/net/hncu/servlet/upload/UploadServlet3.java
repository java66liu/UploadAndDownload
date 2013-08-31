package net.hncu.servlet.upload;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet3 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uploadPath = getServletContext().getRealPath("/upload3"); //文件保存路径
		String tempPath = getServletContext().getRealPath("/temp"); //文件保存路径
		File createUploadDirectory = new File(uploadPath);
		File createTempDirectory = new File(tempPath);
		if (! createUploadDirectory.exists()) {
			createUploadDirectory.mkdirs(); //创建目录
		}
		if (! createTempDirectory.exists()) {
			createTempDirectory.mkdirs(); //创建目录
		}
				
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(4096);
		factory.setRepository(new File(getServletContext().getRealPath("/temp")));//设置临时目录
		ServletFileUpload sfu = new ServletFileUpload(factory);
		try {
			List<FileItem> items = sfu.parseRequest(request);
			
			System.out.println("捕捉到的文件数目："+items.size());//用于测试
			
			Iterator it = items.iterator();
			while(it.hasNext()){
				FileItem item = (FileItem)it.next();
				if(item.isFormField()){ //普通表单域---名(name)值(value)对
					String name = item.getFieldName();
					String value = item.getString();
				}else{ //上传文件域
					System.out.println("文件上传到：" + uploadPath);  //用于测试
					
                    //以当前精确到秒的日期为上传的文件的文件名  
					SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddkkmmss");  
					String fileName=item.getName();
			        int index = fileName.lastIndexOf(".");
			        String extName = fileName.substring(index+1);	
			        if(fileName != null && !"".equals(fileName)){
						File savedFile = new File(uploadPath,new Random().nextInt()+sdf.format(new Date())+"."+extName);  
						item.write(savedFile);  				        	
			        }				
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print("文件上传成功!");
		out.flush();
		out.close();
	}
}
