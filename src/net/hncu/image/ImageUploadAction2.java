package net.hncu.image;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class ImageUploadAction2 extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private String msg = null;// 用户储存返回客户端的信息
    private Image imageObj = null;
    private List<Image> images = null;
    
    /**
     * 執行文件上傳
     */
    public String execute() throws Exception {
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
    
    public Image getImageObj() {
        return imageObj;
    }
    
    public void setImageObj(Image imageObj) {
        this.imageObj = imageObj;
    }
    
    public List<Image> getImages() {
        return images;
    }
    
    public void setImages(List<Image> images) {
        this.images = images;
    }
    
}