package com.ivision.app;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class ImageReaderTest {

	public static void main(String[] args) {

		int rgbR;
		int rgbG;
		int rgbB;
		
		//原点坐标
		int basePointX = 890;
		int basePointY = 1851;
		int i = 0;
		int y = 0;
		
		//左上坐标
		int leftUpX = 0;
		int leftUpY = 0;
		
		//右上坐标
		int rightUpX = 0;
		int rightUpY = 0;
		
		//左下坐标
		int leftDownX = 0;
		int leftDownY = 0;
		
		//右下坐标
		int rightDownX = 0;
		int rightDownY = 0;
		

		//待处理的图片
		String filePath = "C:\\Users\\wanglei\\Desktop\\demo\\image\\SKM_C454e19103013150_0001.jpg";

		try {
			
			BufferedImage image = readImageFile(filePath);
			
			int width = image.getWidth();// 图片宽度
			int height = image.getHeight();// 图片高度
			System.out.println("图片宽度为：" + width + ",高度为:" + height);

			//找到左上顶点的坐标
			for (leftUpX = basePointX; leftUpX >0; leftUpX--) {

					int pixelX = image.getRGB(leftUpX, basePointY); 
					// 下面三行代码将一个数字转换为RGB数字
					rgbR = (pixelX & 0xff0000) >> 16;
					rgbG = (pixelX & 0xff00) >> 8;
					rgbB = (pixelX & 0xff);
					
					System.out.println("leftUpX=" + leftUpX + ",basePointY=" + basePointY + ":(" + rgbR + "," + rgbG + "," + rgbB + ")");

					if(0<=rgbR && rgbR<250 && 0<=rgbG && rgbG<250 && 0<=rgbB && rgbB<250) {
						
						System.out.println("找到第一象限边角宽度的像素坐标为："+"leftUpX=" + leftUpX + ",basePointY=" + basePointY+ ":(" + rgbR + "," + rgbG + "," + rgbB + ")");
						System.out.println("左上坐标横轴为："+leftUpX);
						break;
						
					}else {
						
						System.out.println("未找到");
					}
			}

			System.out.println("===============================================");

					for (leftUpY = basePointY; leftUpY > 0; leftUpY--) {
						int pixelY = image.getRGB(basePointX, leftUpY); // 下面三行代码将一个数字转换为RGB数字
						rgbR = (pixelY & 0xff0000) >> 16;
						rgbG = (pixelY & 0xff00) >> 8;
						rgbB = (pixelY & 0xff);
						
						//System.out.println("z=" + "890" + ",y=" + y + ":(" + rgbR + "," + rgbG + "," + rgbB + ")");

						if(0<=rgbR && rgbR<250 && 0<=rgbG && rgbG<250 && 0<=rgbB && rgbB<250) {
							
							//System.out.println("找到第一象限边角高度的像素坐标为："+"z=" + "890" + ",y=" + y + ":(" + rgbR + "," + rgbG + "," + rgbB + ")");
							System.out.println("左上坐标纵轴为："+leftUpY);
							break;
						}else {
							
							System.out.println("未找到");

						}
						
					}
					
					System.out.println("===============================================");
					
					System.out.println("左上顶点的坐标为："+"("+leftUpX+","+leftUpY+")");
			//找到右上顶点的坐标
					
					//向右延长的长度
					int add = 0;
			for (rightUpX = basePointX; rightUpX <= basePointX+add; rightUpX++) {

					int pixel = image.getRGB(rightUpX, basePointY);
					rgbR = (pixel & 0xff0000) >> 16;
					rgbG = (pixel & 0xff00) >> 8;
					rgbB = (pixel & 0xff);
					
					if(0<=rgbR && rgbR<250 && 0<=rgbG && rgbG<250 && 0<=rgbB && rgbB<250) {

						System.out.println("右上顶点的横轴坐标为:"+rightUpX);
						//System.out.println("找到原点与右边相交坐标为："+"k=" + k + ",basePointY=" +basePointY + ":(" + rgbR + "," + rgbG + "," + rgbB + ")");
						//左上与右上纵轴坐标相同，直接赋值
						rightUpY =leftUpY;

						System.out.println("右上顶点的坐标为："+"("+rightUpX+","+rightUpY+")");

						//计算出右上横轴与左上横轴坐标之间的直线距离
						int lenght = rightUpX-leftUpX;

						//System.out.println("左上顶点与右上顶点之间距离为："+lenght);
						//左下顶点的坐标
						leftDownX = leftUpX;
						leftDownY = leftUpY+lenght;
						System.out.println("左下顶点的坐标为："+"("+leftDownX+","+leftDownY+")");

						//右下顶点的坐标
						rightDownX = rightUpX;
						rightDownY = rightUpY+lenght;

						System.out.println("右下顶点的坐标为："+"("+rightDownX+","+rightDownY+")");

						break;
						
					}else {
						add++;
						continue;
						
						//System.out.println("未找到");
					}

			}
			
			//对图片进行颜色填涂
			
			for(int m =rightDownX;m>leftDownX;m--) {
				
				for(int n =rightDownY;n>rightUpY;n--) {
					
					int pixel = image.getRGB(m, n); // 下面三行代码将一个数字转换为RGB数字
					rgbR = (pixel & 0xff0000) >> 16;
					rgbG = (pixel & 0xff00) >> 8;
					rgbB = (pixel & 0xff);
					//System.out.println("m=" + m + ",n=" + n + ":(" + rgbR + "," + rgbG + "," + rgbB + ")");
					
					image.setRGB(m, n, -65281);
					
				}
				
				
				
			}

			
			ImageIO.write(image, "jpg", new File("C:\\Users\\wanglei\\Desktop\\demo\\image\\outImage\\demo.jpg"));
			
			System.out.println("导出成功");

		} catch (IOException e) {
			System.out.println("读取文件出错");
			e.printStackTrace();
		}

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
