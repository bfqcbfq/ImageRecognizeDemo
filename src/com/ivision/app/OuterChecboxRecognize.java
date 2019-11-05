package com.ivision.app;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class OuterChecboxRecognize {

	public static void main(String[] args) {

		int rgbR;
		int rgbG;
		int rgbB;

		// 原点坐标
		int basePointX = 875;
		int basePointY = 1845;

		// 左上坐标
		int leftUpX = 0;
		int leftUpY = 0;

		// 右上坐标
		int rightUpX = 0;
		int rightUpY = 0;

		// 左下坐标
		int leftDownX = 0;
		int leftDownY = 0;

		// 右下坐标
		int rightDownX = 0;
		int rightDownY = 0;

		// 被选择的像素数
		int selectedPixelCount = 0;
		// 未被选择的像素数
		int unSelectedPixelCount = 0;

		// 待处理的图片
		String filePath = "C:\\Users\\wanglei\\Desktop\\demo\\image\\SKM_C454e19103013150_0002.jpg";

		try {

			BufferedImage image = readImageFile(filePath);

			int width = image.getWidth();// 图片宽度
			int height = image.getHeight();// 图片高度
			System.out.println("图片宽度为：" + width + ",高度为:" + height);

			// 找到左上顶点的坐标
//			for (leftUpX = basePointX; leftUpX > 0; leftUpX--) {
//
//				int pixelX = image.getRGB(leftUpX, basePointY);
//
//				// 下面三行代码将一个数字转换为RGB数字
//				rgbR = (pixelX & 0xff0000) >> 16;
//				rgbG = (pixelX & 0xff00) >> 8;
//				rgbB = (pixelX & 0xff);
//
//				if (60 <= rgbR && rgbR <= 160 && 60 <= rgbG && rgbG <= 160 && 60 <= rgbB && rgbB <= 160) {
//
//					System.out.println("leftUpX=" + leftUpX + ",basePointY=" + basePointY + ":(" + rgbR + "," + rgbG
//							+ "," + rgbB + ")");
//
//					break;
//
//				}
//			}

			for (int m = width-1; m > 0; m--) {

				for (int n = height-1; n > 0; n--) {

					int pixelX = image.getRGB(m, n);

					// 下面三行代码将一个数字转换为RGB数字
					rgbR = (pixelX & 0xff0000) >> 16;
					rgbG = (pixelX & 0xff00) >> 8;
					rgbB = (pixelX & 0xff);

					if (0 <= rgbR && rgbR <= 200 && 0 <= rgbG && rgbG <= 160 && 0 <= rgbB && rgbB <= 160) {

						image.setRGB(m, n, -1);

					}else {
						
						continue;
						
					}

				}
			}

			ImageIO.write(image, "jpg", new File("C:\\Users\\wanglei\\Desktop\\demo\\image\\outImage\\demo02.jpg"));

			System.out.println("导出成功");

		} catch (IOException e) {
			System.out.println("读取文件出错");
			e.printStackTrace();
		}

	}

	public static BufferedImage readImageFile(String filePath) throws IOException {

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
