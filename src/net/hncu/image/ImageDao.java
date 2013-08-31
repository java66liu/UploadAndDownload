package net.hncu.image;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import net.hncu.fileUpload.UploadUtils;
import net.hncu.util.JdbcHelper;

public class ImageDao extends JdbcHelper{
    /**
     * 将图片保存到数据库
     * @param image
     */
    public void saveImage(Image image) {
        String sql = "insert into tb_image(image_,image_ContentType,image_FileName) values(?,?,?)";
		openConnection();
		try {
			pstmt = con.prepareStatement(sql);
            pstmt.setBytes(1, image.getImageByte());
            pstmt.setString(2, image.getImage_ContentType());
            pstmt.setString(3, UploadUtils.reBuildFileName(image.getImage_FileName()));
            pstmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeResource();
		}	
    }
    /**
     * 查询所有数据库中的图片信息
     * @return
     */
    public List<Image> queryAllImage() {
        List<Image> images = new ArrayList<Image>();
        pstmt = null;
        String sql = "select * from tb_image";
        openConnection();
        try {
            pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Image image = new Image();
                image.setImage_id(rs.getInt(1));
                image.setImage_ContentType(rs.getString(2));
                image.setImageByte(rs.getBytes(3));
                image.setImage_FileName(rs.getString(4));
                images.add(image);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	closeResource();
        }
        return images;
    }
}
