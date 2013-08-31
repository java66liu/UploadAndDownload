package net.hncu.servlet.upload;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class UploadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		/* 
         * 注意，当jsp中表单的enctype设置的为：multipart/form-data的时候 我们无法直接使用 
         * request.getParameter("") 获取表单的数据信息 
         */  		
		
		//新建上传工厂
		// 使用DiskFileItemFacotry类进行表单的处理，以及文件的上传 
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		//设置文件大小限制。
		//如果小于该文件限制，则文件直接保存在内存中如何保存到目标文件夹中。
		//如果大于该文件限制，则文件将保存到设置的临时目录中。
		factory.setSizeThreshold(1024 * 1024);
		
		//设置临时目录
		factory.setRepository(new File(getServletContext().getRealPath("/temp")));
		
		//实例化一个ServletFileUpload对象用来上传
		ServletFileUpload sfu = new ServletFileUpload(factory);
		
		//得到所有的表单项- List<FileItem>中保存着有关表单元素的所有信息 需要对它进行遍历  
		List<FileItem>  all = null;
		try {
			 all = sfu.parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
		System.out.println("捕捉到的文件数目："+all.size());//用于测试
		
		for(FileItem item : all) {
			//如果是普通表单字段
			if(item.isFormField()) {
                /* 
                 * 获取该字段的名称 如:<input type="text" name="password" value=""/> 
                 * 该方法便是获取name属性的值 ：password 
                 */ 
				String name = item.getFieldName();
				
				// 获取该字段的value属性的值，如获取<input type="text" name="password" value=""/> 中的value属性的值
				String value = item.getString("utf-8");
				
				//将值设置到request属性范围中
				request.setAttribute(name, value);
			} 
			
			
			//如果为文件域---else则证明它是一个file文件流
			else {
				//取得文件域字段名
				String name = item.getFieldName();
				
				/* 
				 * 对于某些浏览器会取得全路径文件名(文件表单元素域里的值：如D:\pictures\siyuli.jpg)，某些浏览器则会只取得“文件名+后缀”
                 * 对于表单中的file元素，我们不能通过getString获取它的内容，因为它是一个流 
                 * 只能够通过getName方法获取当前文件的名称 
                 */  
				String value = item.getName();
				
				//截取文件名
                // 对value进行处理，由于某些浏览器 可能只显示 文件名+后缀  
                // 有的则将文件的全部路径都显示出来 ，所以我们要在这里对它进行一次通用处理 
				int begin = value.lastIndexOf("\\");
				value = value.substring(begin + 1);
				
				//将值设置到request属性范围中
				request.setAttribute(name, value);
				
				//设置上传文件目录
				String uploadPath = getServletContext().getRealPath("/upload");
				
				//写入文件
				try {
					item.write(new File(uploadPath,value));
					/*
					 * item.write(new File(uploadPath,value));这行代码等价于下面的代码段，与下面的代码段可以实现同样的功能
					OutputStream os=new FileOutputStream(new File(path,fileName));              
					InputStream is=item.getInputStream();              
					byte[] buffer=new byte[400];          
					int length=0;            
					while((length=is.read(buffer))>0){
						os.write(buffer,0,length);
					}
					os.close();
					is.close();
					*/
				} catch (Exception e) {
					e.printStackTrace();
				}			
			}
			
		}
		
		//上传完成后执行跳转
		request.getRequestDispatcher("/servletUpload/result.jsp").forward(request, response);
	}

}
