package net.hncu.fileUpload.rubbish;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
public class MultiFileUploadAction4 extends ActionSupport{
	// username属性用来封装用户名
	private String username;
	
	// myFile属性用来封装所有上传的文件
	private List<File> uploadFile;
	
	// myFileContentType属性用来封装所有上传文件的类型
	private List<String> uploadFileContentType;
	
	// myFileFileName属性用来封装所有上传文件的文件名
	private List<String> uploadFileFileName;

	private String savePath;

	public String execute() throws Exception {
		//取得用来上传的文件数组
		List<File> files = getUploadFile();

		//循环每个上传的文件
		for (int i = 0; i < files.size(); i++) {
			
			//基于file[i]创建一个文件输入流
			InputStream is = new FileInputStream(files.get(i));
			
			// 设置上传文件目录
			String uploadPath = ServletActionContext.getServletContext().getRealPath(getSavePath());
			
			// 设置目标文件
			File toFile = new File(uploadPath, getUploadFileFileName().get(i));
			
			// 输出流
			OutputStream os = new FileOutputStream(toFile);

			//设置缓存
			byte[] buffer = new byte[1024];

			int length = 0;

			//读取file[i]文件输出到toFile文件中
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
			
			//关闭输入流
			is.close();
			
			//关闭输出流
			os.close();
		}
		return SUCCESS;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<File> getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(List<File> uploadFile) {
		this.uploadFile = uploadFile;
	}

	public List<String> getUploadFileContentType() {
		return uploadFileContentType;
	}

	public void setUploadFileContentType(List<String> uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}

	public List<String> getUploadFileFileName() {
		return uploadFileFileName;
	}

	public void setUploadFileFileName(List<String> uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}	
}
