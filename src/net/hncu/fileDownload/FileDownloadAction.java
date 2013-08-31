package net.hncu.fileDownload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FileDownloadAction extends ActionSupport {
    private File download = null;// 文件数组
    private String downloadContentType = null; // 用户存储文件类型
    private String downloadFileName = null; // 用于储存文件名称（包括文件名称+扩展名称）
    private String userName = null;
    private String password = null;
    /**
     * 用户登陆
     * @return
     */
    public String login() {
        ServletActionContext.getRequest().getSession().setAttribute("userName",userName);
        return "inDownloadPage";
    }
    /**
     * 下载文件
     * @return
     * @throws Exception
     */
    public String check() throws Exception {
        String userName = (String) ServletActionContext.getRequest().getSession().getAttribute("userName");
        if ("维维".equals(userName)) {
            return "download";
        } else {
            return ERROR;
        }
    }
    /**
     * 为struts2文件下载提供输入流的方法
     * @return
     * @throws Exception  
     */
    public InputStream getInputStream() throws Exception {
        InputStream in = null;
        this.setDownloadContentType("text/plain");
//      System.out.println(new String(this.downloadFileName.getBytes("ISO-8859-1"),"utf-8"));
        String path = ServletActionContext.getServletContext().getRealPath("/") 
        		+ "upload/" 
        		+ new String(this.downloadFileName.getBytes("ISO-8859-1"),"utf-8");
        try {
            in = new FileInputStream(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return in;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
	public File getDownload() {
		return download;
	}
	public void setDownload(File download) {
		this.download = download;
	}
	public String getDownloadContentType() {
		return downloadContentType;
	}
	public void setDownloadContentType(String downloadContentType) {
		this.downloadContentType = downloadContentType;
	}
	public String getDownloadFileName() {
		return downloadFileName;
	}
	public void setDownloadFileName(String downloadFileName) {
		this.downloadFileName = downloadFileName;
	}    
}
