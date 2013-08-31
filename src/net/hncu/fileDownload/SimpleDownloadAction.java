package net.hncu.fileDownload;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SimpleDownloadAction extends ActionSupport {

	private String fileName; // 该字段是为了获取页面传过来的文件名称的信息-用于储存文件名称（包括文件名称+扩展名称）

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getDownloadFileName() throws Exception {
		// 返回文件的名称给struts.xml文件中的<param name="contentDisposition">filename="${downloadFileName}"</param>
		return this.fileName;
	}

	public InputStream getDownload() throws Exception {
		// 这里是一个重点 获取一个输入流
		//用于测试是否中文乱码		System.out.println(new String(this.getPathName().getBytes("iso-8859-1"),"utf-8"));
		return ServletActionContext.getServletContext().getResourceAsStream(
				"/upload/"/* 获取WebRoot/upload/的某一个文件 */
						+ new String(this.getFileName().getBytes("iso-8859-1"),"utf-8"));
		// new String(this.getPathName().getBytes("iso-8859-1"),"utf-8") 将文件名进行转码 转换成中文
		// 当没有找到该文件对象的时候 会抛出以下异常
		/*
		 * Can not find a java.io.InputStream with the name [download] in the
		 * invocation stack. Check the <param name="inputName"> tag specified
		 * for this action.
		 */
	}

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
}

