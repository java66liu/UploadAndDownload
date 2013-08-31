package net.hncu.image;

import java.io.File;
import java.io.IOException;
import java.util.List;

import net.hncu.fileUpload.UploadUtils;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class ImageUploadAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private String msg = null;// 用户储存返回客户端的信息
    private File uploadFile;
    private String uploadFileFileName;
    private String uploadFileContentType;    
    private List<Image> images = null;
    
    /**
     * 執行文件上傳
     */
    public String execute() throws Exception {
    	Image imageObj = new Image();
    	imageObj.setImage_(uploadFile);
    	imageObj.setImage_ContentType(uploadFileContentType);
    	imageObj.setImage_FileName(uploadFileFileName);
        ImageDao imageDao = new ImageDao();
        imageDao.saveImage(imageObj);
        images = imageDao.queryAllImage();
        writeImages(images);
        setMsg("文件上传成功");
        return SUCCESS;
    }
    
    private void writeImages(List<Image> images) throws IOException {
        String path = ServletActionContext.getServletContext().getRealPath("/");
        path = path + "/temp/";
        for (Image image : images) {
            File file = new File(path + image.getImage_FileName());
            FileUtils.writeByteArrayToFile(file, image.getImageByte());
        }
    }
    
    public String getMsg() {
        return msg;
    }
    
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public List<Image> getImages() {
        return images;
    }
    
    public void setImages(List<Image> images) {
        this.images = images;
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
}
