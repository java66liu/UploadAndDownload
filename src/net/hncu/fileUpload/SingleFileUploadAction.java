package net.hncu.fileUpload;

import java.io.File;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SingleFileUploadAction extends ActionSupport {	
	private static final long serialVersionUID = 1L;

    // 文件标题
    private String title;
    // 上传文件域对象
    private File uploadFile;
    // 上传文件名
    private String uploadFileFileName;
    // 上传文件类型
    private String uploadFileContentType;
    // 保存文件的目录路径(通过依赖注入)
    private String savePath;
    //getter和setter......

	@Override
    public String execute() throws Exception {
        //根据服务器的文件保存地址和原文件名创建目录文件全路径
		String directoryPath = ServletActionContext.getServletContext().getRealPath(this.getSavePath());
		UploadUtils.createTargetDirectory(directoryPath);
        String dstPath = directoryPath + "\\" + UploadUtils.reBuildFileName(this.uploadFileFileName); 
        File dstFile = new File(dstPath);
        UploadUtils.copy(this.uploadFile, dstFile);
        return SUCCESS;
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public File getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getUploadFileFileName() {
		return uploadFileFileName;
	}

	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}

	public String getUploadFileContentType() {
		return uploadFileContentType;
	}

	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
}