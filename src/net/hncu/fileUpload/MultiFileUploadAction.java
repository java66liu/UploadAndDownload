package net.hncu.fileUpload;

import java.io.File;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MultiFileUploadAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private String msg = null;// 用户储存返回客户端的信息
    // 文件标题
    private String title;
    // 用File数组来封装多个上传文件域对象
    private File[] uploadFile;
    // 用String数组来封装多个上传文件名
    private String[] uploadFileFileName;
    // 用String数组来封装多个上传文件类型，每一个数组元素是一个文件完整名称（包括文件前缀+扩展名称）
    private String[] uploadFileContentType;
    // 保存文件的目录路径(通过依赖注入)
    private String savePath;

    /**
     * 執行文件上傳
     * 若srcFiles==null，那么srcFiles.length就会抛出异常，所以这里最好判断一下srcFiles是否为空或者抛出异常
     */
	@Override
    public String execute() throws Exception {
		//String directoryPath = ServletActionContext.getServletContext().getRealPath("/upload2");
		String directoryPath = ServletActionContext.getServletContext().getRealPath(this.getSavePath());
		UploadUtils.createTargetDirectory(directoryPath);
		File[] srcFiles = this.uploadFile;  
        for (int i = 0; i < srcFiles.length; i++) {
        	if(srcFiles[i]!=null){
	            String dstPath = directoryPath + "/" + UploadUtils.reBuildFileName(this.uploadFileFileName[i]);
	            File dstFile = new File(dstPath);
	            UploadUtils.copy(srcFiles[i], dstFile);
	            // UploadUtils.writeFileTo(srcFiles[i], dstFile);
        	}
        }
        setMsg("文件上传成功");
        System.out.println("捕捉到"+uploadFile.length+"个文件!!!!!!!!!!!!!!!!!!!!!!!!!");
        return SUCCESS;
    }
    //以下为所有属性的getter和setter
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public File[] getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File[] uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String[] getUploadFileFileName() {
		return uploadFileFileName;
	}

	public void setUploadFileFileName(String[] uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}

	public String[] getUploadFileContentType() {
		return uploadFileContentType;
	}

	public void setUploadFileContentType(String[] uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
} 