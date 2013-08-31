package net.hncu.fileUpload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class UploadUtils {
	private static final int BUFFER_SIZE = 16 * 1024;  //16*1024B = 16KB
	
    //自己封装的一个把源文件对象复制成目标文件对象
    public static void copy(File src, File dst) {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new BufferedInputStream(new FileInputStream(src),BUFFER_SIZE);
            out = new BufferedOutputStream(new FileOutputStream(dst),BUFFER_SIZE);
            byte[] buffer = new byte[BUFFER_SIZE];
            int len = 0;
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
	
    /**
     * 将文件写到制定的路径--处理单个文件
     * 
     * @param file
     * @param path
     */
    public static void writeFileTo(File srcFile, File dstFile) {
        try {
            FileInputStream in = new FileInputStream(srcFile);
            FileOutputStream out = new FileOutputStream(dstFile);
            byte[] b = new byte[in.available()];
            in.read(b);
            in.close();
            out.write(b);
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 重新构建文件名称，文件名称为：日期+随机数+扩展名
     * @param fileName
     * @return
     */
    public static String reBuildFileName(String fileName) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        int index = fileName.lastIndexOf(".");
//      String name = fileName.substring(0, index); //文件名
        String exName = fileName.substring(index);
        String date = sdf.format(new Date());
        return  date + new Random().nextInt() + exName;
    }
    
    /**
     * 若目标目录不存在，则创建目标目录
     * @param directoryPath
     *
     */
    public static void createTargetDirectory(String directoryPath){
		File createTargetDirectory = new File(directoryPath);
		if (! createTargetDirectory.exists()) {
			createTargetDirectory.mkdirs(); //创建目录
		}    	
    }
}
