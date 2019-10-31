package com.ivision.app;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

/**
 * @author wanglei
 * 
 *         识别图片复选框内容
 *
 */
public class ImageRecognize {

	//public static final String filePath = "C:\\Users\\wanglei\\Desktop\\demo\\image\\SKM_C454e19103013150_0001.jpg";

	public static void main(String[] args) throws IOException {

//		BufferedImage image = new BufferedImage(0, 0, 0, null);
//
//		WritableRaster raster = image.getRaster();
		
		String filePath = "C:\\Users\\wanglei\\Desktop\\demo\\image\\SKM_C454e19103013150_0001.jpg";
		
		BufferedImage image = readImageFile(filePath);
		
		WritableRaster raster = image.getRaster();
		
		raster.getDataElements(890, 1840, 0, 0, null);
		
		System.out.println(image);

	}

	public static BufferedImage readImageFile(String filePath) throws IOException{
		
		FileInputStream is = null;
		BufferedImage image = null;

		try {
			File file = new File(filePath);
			if (file.exists() && file.isFile() && file.canRead()) {
				is = new FileInputStream(file);
				image = loadImage(is);
			} else {
				throw new RuntimeException("图片文件读取失败");
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (is != null) {
				is.close();
			}
		}
		return image;

	}
	
	private static BufferedImage loadImage(InputStream in) throws IOException {
		return ImageIO.read(in);
	}

}
