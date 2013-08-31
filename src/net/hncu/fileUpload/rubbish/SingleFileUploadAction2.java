package net.hncu.fileUpload.rubbish;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class SingleFileUploadAction2 extends ActionSupport {
	// username属性用来封装用户名
	private String username;
	
	// myFile属性用来封装上传的文件
	private File uploadFile;
	
	// myFileContentType属性用来封装上传文件的类型
	private String uploadFileContentType;

	// myFileFileName属性用来封装上传文件的文件名
	private String uploadFileFileName;

	public String execute() throws Exception {
		
		//基于myFile创建一个文件输入流
		InputStream is = new FileInputStream(uploadFile);
		
		// 设置上传文件目录
		String uploadPath = ServletActionContext.getServletContext().getRealPath("/upload");
		
		// 设置目标文件
		File toFile = new File(uploadPath, this.getUploadFileFileName());
		
		// 创建一个输出流
		OutputStream os = new FileOutputStream(toFile);

		//设置缓存
		byte[] buffer = new byte[1024];

		int length = 0;

		//读取myFile文件输出到toFile文件中
		while ((length = is.read(buffer)) > 0) {
			os.write(buffer, 0, length);
		}
		
		//关闭输入流
		is.close();
		
		//关闭输出流
		os.close();
		
		return SUCCESS;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public File getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getUploadFileContentType() {
		return uploadFileContentType;
	}

	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}

	public String getUploadFileFileName() {
		return uploadFileFileName;
	}

	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}
}
