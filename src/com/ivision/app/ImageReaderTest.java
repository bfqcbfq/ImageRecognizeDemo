package com.ivision.app;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageReaderTest {

	public static void main(String[] args) {

		int rgbR;
		int rgbG;
		int rgbB;
		int basePointX = 890;
		int basePointY = 1838;
		
		int[] rgb = new int[3];
		rgb[0] = 237;
        rgb[1] = 28;
        rgb[2] = 36;
		

		try {
			File file = new File("C:\\\\Users\\\\wanglei\\\\Desktop\\\\demo\\\\image\\\\SKM_C454e19103013150_0001.jpg");
			BufferedImage image = ImageIO.read(file);
			int width = image.getWidth();// 图片宽度
			int height = image.getHeight();// 图片高度
			//Graphics graphics = image.getGraphics();
			System.out.println("图片宽度为：" + width + ",高度为:" + height);

			//遍历第一象限
			//找到第一象限 边角 宽度像素坐标
			for (int i = basePointX; i <= basePointX+30; i++) {

				//for (int j = basePointY; j >= basePointY-15; j--) {
					int pixelX = image.getRGB(i, basePointY); // 下面三行代码将一个数字转换为RGB数字
					rgbR = (pixelX & 0xff0000) >> 16;
					rgbG = (pixelX & 0xff00) >> 8;
					rgbB = (pixelX & 0xff);
					
					//image.setRGB(i, j, -65281);
					
					//image.setRGB(startX, startY, w, h, rgbArray, offset, scansize);
					
					System.out.println("i=" + i + ",j=" + "1840" + ":(" + rgbR + "," + rgbG + "," + rgbB + ")");

					if(0<=rgbR && rgbR<=228 && 0<=rgbG && rgbG<=228 && 0<=rgbB && rgbB<=228) {
						
						System.out.println("找到第一象限边角宽度的像素坐标为："+"i=" + i + ",j=" + "1840"+ ":(" + rgbR + "," + rgbG + "," + rgbB + ")");
						System.out.println("第一象限边角像素左边距坐标为："+i);
						break;
						
					}else {
						
						System.out.println("未找到");
					}
					
			}
			
			//System.out.println("第一象限边角像素坐标为：("+i+"");
			
			System.out.println("===============================================");
					
					//找到第一象限 边角 高度像素坐标
					for (int y = basePointY; y >= basePointY-30; y--) {
						int pixelY = image.getRGB(basePointX, y); // 下面三行代码将一个数字转换为RGB数字
						rgbR = (pixelY & 0xff0000) >> 16;
						rgbG = (pixelY & 0xff00) >> 8;
						rgbB = (pixelY & 0xff);
						
						System.out.println("z=" + "890" + ",y=" + y + ":(" + rgbR + "," + rgbG + "," + rgbB + ")");

						if(0<=rgbR && rgbR<=228 && 0<=rgbG && rgbG<=228 && 0<=rgbB && rgbB<=228) {
							
							System.out.println("找到第一象限边角高度的像素坐标为："+"z=" + "890" + ",y=" + y + ":(" + rgbR + "," + rgbG + "," + rgbB + ")");
							System.out.println("第一象限边角像素左边距坐标为："+y);
							break;
						}else {
							
							System.out.println("未找到");
						}
						
					}
					
				
					//System.out.println("i=" + i + ",j=" + j + ":(" + rgbR + "," + rgbG + "," + rgbB + ")");

				//}

			//遍历第二象限
			for (int k = basePointX; k >= basePointX-15; k--) {

				for (int l = basePointY; l >= basePointY-15; l--) {
					int pixel = image.getRGB(k, l); // 下面三行代码将一个数字转换为RGB数字
					rgbR = (pixel & 0xff0000) >> 16;
					rgbG = (pixel & 0xff00) >> 8;
					rgbB = (pixel & 0xff);
					//System.out.println("k=" + k + ",l=" + l + ":(" + rgbR + "," + rgbG + "," + rgbB + ")");
					
					//image.setRGB(k, l, -65281);
					

//					if(0<=rgbR && rgbR<=228 && 0<=rgbG && rgbG<=228 && 0<=rgbB && rgbB<=228) {
//						
//						System.out.println("找到边角RGB,坐标为："+"k=" + k + ",l=" + l+ ":(" + rgbR + "," + rgbG + "," + rgbB + ")");
//						
//					}else {
//						
//						System.out.println("未找到");
//					}

				}
			}
			//遍历第三象限
			for (int m = basePointX; m >= basePointX-15; m--) {

				for (int n = basePointY; n <= basePointY+15; n++) {
					int pixel = image.getRGB(m, n); // 下面三行代码将一个数字转换为RGB数字
					rgbR = (pixel & 0xff0000) >> 16;
					rgbG = (pixel & 0xff00) >> 8;
					rgbB = (pixel & 0xff);
					
					//image.setRGB(m, n, -65281);
					

//					if(0<=rgbR && rgbR<=228 && 0<=rgbG && rgbG<=228 && 0<=rgbB && rgbB<=228) {
//						
//						System.out.println("找到边角RGB,坐标为："+"m=" + m + ",n=" + n+ ":(" + rgbR + "," + rgbG + "," + rgbB + ")");
//						
//					}else {
//						
//						System.out.println("未找到");
//					}

					//System.out.println("m=" + m + ",n=" + n + ":(" + rgbR + "," + rgbG + "," + rgbB + ")");

				}
			}
			//遍历第四象限
			for (int o = basePointX; o <=basePointX+15; o++) {

				for (int p = basePointY; p <= basePointY+15; p++) {
					int pixel = image.getRGB(o, p); // 下面三行代码将一个数字转换为RGB数字
					rgbR = (pixel & 0xff0000) >> 16;
					rgbG = (pixel & 0xff00) >> 8;
					rgbB = (pixel & 0xff);
					
					
					//image.setRGB(o, p, -65281);
					

//					if(0<=rgbR && rgbR<=228 && 0<=rgbG && rgbG<=228 && 0<=rgbB && rgbB<=228) {
//						
//						System.out.println("找到边角RGB,坐标为："+"o=" + o + ",p=" + p+ ":(" + rgbR + "," + rgbG + "," + rgbB + ")");
//						
//					}else {
//						
//						System.out.println("未找到");
//					}
					
					//System.out.println("o=" + o + ",p=" + p + ":(" + rgbR + "," + rgbG + "," + rgbB + ")");

				}
			}
			
			//ImageIO.write(image, "jpg", new File("C:\\Users\\wanglei\\Desktop\\demo\\image\\outImage\\demo.jpg"));
			
			//System.out.println("导出成功");

		} catch (IOException e) {
			System.out.println("读取文件出错");
			e.printStackTrace();
		}

	}


}
