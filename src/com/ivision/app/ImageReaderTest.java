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
		// 顶点坐标轴之间的距离
		int lenght = 0;

		// 被选择的像素数
		int selectedPixelCount = 0;
		// 未被选择的像素数
		int unSelectedPixelCount = 0;

		// 待处理的图片
		String filePath = "C:\\Users\\wanglei\\Desktop\\demo\\image\\SKM_C454e19103013150_0004.jpg";

		try {

			BufferedImage image = readImageFile(filePath);

			int width = image.getWidth();// 图片宽度
			int height = image.getHeight();// 图片高度
			System.out.println("图片宽度为：" + width + ",高度为:" + height);

			// 找到左上顶点的坐标
			for (leftUpX = basePointX; leftUpX > 0; leftUpX--) {

				int pixelX = image.getRGB(leftUpX, basePointY);

				// 下面三行代码将一个数字转换为RGB数字
				rgbR = (pixelX & 0xff0000) >> 16;
				rgbG = (pixelX & 0xff00) >> 8;
				rgbB = (pixelX & 0xff);

				// System.out.println("leftUpX=" + leftUpX + ",basePointY=" + basePointY + ":("
				// + rgbR + "," + rgbG + "," + rgbB + ")");

				if (60 <= rgbR && rgbR < 182 && 69 <= rgbG && rgbG < 185 && 200 <= rgbB && rgbB < 228) {
					continue;
					// System.out.println("找到第一象限边角宽度的像素坐标为："+"leftUpX=" + leftUpX + ",basePointY="
					// + basePointY+ ":(" + rgbR + "," + rgbG + "," + rgbB + ")");
					// System.out.println("左上坐标横轴为："+leftUpX);
					// break;

				} else if (63 <= rgbR && rgbR <= 145 && 62 <= rgbG && rgbG <= 149 && 68 <= rgbB && rgbB <= 152) {

					// System.out.println("找到第一象限边角宽度的像素坐标为："+"leftUpX=" + leftUpX + ",basePointY="
					// + basePointY+ ":(" + rgbR + "," + rgbG + "," + rgbB + ")");
					System.out.println("左上坐标横轴为：" + leftUpX);
					break;

				} else {
					// System.out.println("未找到");

				}
			}

			System.out.println("===============================================");

			for (leftUpY = basePointY; leftUpY > 0; leftUpY--) {
				int pixelY = image.getRGB(basePointX, leftUpY); // 下面三行代码将一个数字转换为RGB数字
				rgbR = (pixelY & 0xff0000) >> 16;
				rgbG = (pixelY & 0xff00) >> 8;
				rgbB = (pixelY & 0xff);

				 System.out.println("basePointX=" + basePointX + ",leftUpY=" + leftUpY + ":(" + rgbR + "," + rgbG + "," + rgbB + ")");

				if (60 <= rgbR && rgbR < 182 && 69 <= rgbG && rgbG < 185 && 200 <= rgbB && rgbB < 228) {
					continue;

				} else if (63 <= rgbR && rgbR < 145 && 62 <= rgbG && rgbG < 149 && 68 <= rgbB && rgbB < 152) {

					System.out.println("左上坐标纵轴为：" + leftUpY);
					break;

				} else {

					// System.out.println("未找到");

				}

			}

			System.out.println("===============================================");

			System.out.println("左上顶点的坐标为：" + "(" + leftUpX + "," + leftUpY + ")");
			// 找到右上顶点的坐标

			// 向右延长的长度
			int add = 0;
			for (rightUpX = basePointX; rightUpX <= basePointX + add; rightUpX++) {

				// System.out.println("add="+add);

				int pixel = image.getRGB(rightUpX, basePointY);

				rgbR = (pixel & 0xff0000) >> 16;
				rgbG = (pixel & 0xff00) >> 8;
				rgbB = (pixel & 0xff);

				// System.out.println("rightUpX=" + rightUpX + ",basePointY=" + basePointY +
				// ":(" + rgbR + "," + rgbG + "," + rgbB + ")");

				if (60 <= rgbR && rgbR < 182 && 69 <= rgbG && rgbG < 185 && 200 <= rgbB && rgbB < 228) {
					add++;
					continue;

				} else if (63 <= rgbR && rgbR < 145 && 62 <= rgbG && rgbG < 149 && 68 <= rgbB && rgbB < 152) {

					// System.out.println("右上顶点的横轴坐标为:"+rightUpX);
					// System.out.println("找到原点与右边相交坐标为："+"k=" + k + ",basePointY=" +basePointY +
					// ":(" + rgbR + "," + rgbG + "," + rgbB + ")");
					// 左上与右上纵轴坐标相同，直接赋值
					rightUpY = leftUpY;

					System.out.println("右上顶点的坐标为：" + "(" + rightUpX + "," + rightUpY + ")");

					// 计算出右上横轴与左上横轴坐标之间的直线距离
					lenght = rightUpX - leftUpX;

					// System.out.println("左上顶点与右上顶点之间距离为："+lenght);
					// 左下顶点的坐标
					leftDownX = leftUpX;
					leftDownY = leftUpY + lenght;
					System.out.println("左下顶点的坐标为：" + "(" + leftDownX + "," + leftDownY + ")");

					// 右下顶点的坐标
					rightDownX = rightUpX;
					rightDownY = rightUpY + lenght;

					System.out.println("右下顶点的坐标为：" + "(" + rightDownX + "," + rightDownY + ")");

					break;

				} else {
					add++;
					continue;

					// System.out.println("未找到");
				}

			}

			// 对图片进行颜色填涂

			for (int m = rightDownX; m > leftDownX; m--) {

				for (int n = rightDownY; n > rightUpY; n--) {

					int pixel = image.getRGB(m, n); // 下面三行代码将一个数字转换为RGB数字
					rgbR = (pixel & 0xff0000) >> 16;
					rgbG = (pixel & 0xff00) >> 8;
					rgbB = (pixel & 0xff);
					// System.out.println("m=" + m + ",n=" + n + ":(" + rgbR + "," + rgbG + "," +
					// rgbB + ")");

					if (60 <= rgbR && rgbR < 182 && 69 <= rgbG && rgbG < 185 && 200 <= rgbB && rgbB < 228) {

						// System.out.println("复选框被勾选");

						selectedPixelCount++;

					} else {

						// System.out.println("复选框未被勾选");

						unSelectedPixelCount++;

					}

					// image.setRGB(m, n, -65281);

				}

			}
			System.out.println("被勾选的像素数为：" + selectedPixelCount);
			System.out.println("未被勾选的像素数为：" + unSelectedPixelCount);

			// 将未勾选的像素设置为白色
			for (int m = width - 1; m > 0; m--) {

				for (int n = height - 1; n > 0; n--) {

					int pixelX = image.getRGB(m, n);

					// 下面三行代码将一个数字转换为RGB数字
					rgbR = (pixelX & 0xff0000) >> 16;
					rgbG = (pixelX & 0xff00) >> 8;
					rgbB = (pixelX & 0xff);

					if (!(60 <= rgbR && rgbR < 182 && 69 <= rgbG && rgbG < 185 && 200 <= rgbB && rgbB < 228)) {

						image.setRGB(m, n, -1);

					} else {

						continue;

					}

				}
			}

			// 如果方框内的像素数量为0，尝试去识别出方框外是否打了对勾
			if (selectedPixelCount == 0) {
				// 左上顶点外的像素数
				int leftUpPixel = 0;

				// 右上顶点外的像素数
				int rightUpPixel = 0;
				
				// 左下顶点外的像素数
				int leftDownPixel = 0;
				
				// 右下顶点外的像素数
				int rightDownPixel = 0;
				
				//左方像素
				int leftPixel = 0;
				
				//左方像素
				int upPixel = 0;
				
				//左方像素
				int rightPixel = 0;
				
				//左方像素
				int downPixel = 0;
				// 识别四个顶点外被勾选的像素
				// 识别出左上顶点坐标外围的像素
				for (int o = leftUpX; o > leftUpX - lenght; o--) {

					for (int p = leftUpY; p >leftUpY -lenght; p--) {

						
						int pixelX = image.getRGB(o, p);

						// 下面三行代码将一个数字转换为RGB数字
						rgbR = (pixelX & 0xff0000) >> 16;
						rgbG = (pixelX & 0xff00) >> 8;
						rgbB = (pixelX & 0xff);

						if (60 <= rgbR && rgbR < 182 && 69 <= rgbG && rgbG < 185 && 200 <= rgbB && rgbB < 228) {

							leftUpPixel++;


						}
					}
				}
				System.out.println("左上顶点外的像素数为：" + leftUpPixel);
				// 识别出右上顶点坐标外围的像素
				for (int q = rightUpX; q < rightUpX + lenght; q++) {

					for (int r = rightUpY; r > rightUpY - lenght; r--) {

						int pixelX = image.getRGB(q, r);

						// 下面三行代码将一个数字转换为RGB数字
						rgbR = (pixelX & 0xff0000) >> 16;
						rgbG = (pixelX & 0xff00) >> 8;
						rgbB = (pixelX & 0xff);

						if (60 <= rgbR && rgbR < 182 && 69 <= rgbG && rgbG < 185 && 200 <= rgbB && rgbB < 228) {

							rightUpPixel++;


						}
					}
				}
				System.out.println("右上顶点外的像素数为：" + rightUpPixel);
				
				//识别出左下顶点坐标外围的像素
				
				for (int s = leftDownX; s > leftDownX - lenght; s--) {

					for (int t = leftDownY; t < leftDownY + lenght; t++) {

						

						int pixelX = image.getRGB(s, t);

						// 下面三行代码将一个数字转换为RGB数字
						rgbR = (pixelX & 0xff0000) >> 16;
						rgbG = (pixelX & 0xff00) >> 8;
						rgbB = (pixelX & 0xff);

						if (60 <= rgbR && rgbR < 182 && 69 <= rgbG && rgbG < 185 && 200 <= rgbB && rgbB < 228) {

							leftDownPixel++;


						}
					}
				}
				System.out.println("左下顶点外的像素数为：" + leftDownPixel);
				
				//识别出右下顶点坐标外围的像素
				for (int u = rightDownX; u < rightDownX + lenght; u++) {

					for (int v = leftDownY; v < leftDownY + lenght; v++) {

						int pixelX = image.getRGB(u, v);

						// 下面三行代码一个数字转换为RGB数字
						rgbR = (pixelX & 0xff0000) >> 16;
						rgbG = (pixelX & 0xff00) >> 8;
						rgbB = (pixelX & 0xff);

						if (60 <= rgbR && rgbR < 182 && 69 <= rgbG && rgbG < 185 && 200 <= rgbB && rgbB < 228) {

							rightDownPixel++;


						}
					}
				}
				System.out.println("下方被勾选的像素数为：" + rightDownPixel);
				
				// 识别勾选框四边外被勾选的像素
				// 识别左边勾选的像素
				for (int o = leftUpX; o > leftUpX - lenght; o--) {

					for (int p = leftUpY; p <leftUpY +lenght; p++) {

						
						int pixelX = image.getRGB(o, p);

						// 下面三行代码将一个数字转换为RGB数字
						rgbR = (pixelX & 0xff0000) >> 16;
						rgbG = (pixelX & 0xff00) >> 8;
						rgbB = (pixelX & 0xff);

						if (60 <= rgbR && rgbR < 182 && 69 <= rgbG && rgbG < 185 && 200 <= rgbB && rgbB < 228) {

							leftPixel++;


						}
					}
				}
				System.out.println("左边被勾选的像素数为：" + leftPixel);
				// 识别上方勾选的像素
				for (int q = rightUpX; q > rightUpX - lenght; q--) {

					for (int r = rightUpY; r > rightUpY - lenght; r--) {

						int pixelX = image.getRGB(q, r);

						// 下面三行代码将一个数字转换为RGB数字
						rgbR = (pixelX & 0xff0000) >> 16;
						rgbG = (pixelX & 0xff00) >> 8;
						rgbB = (pixelX & 0xff);

						if (60 <= rgbR && rgbR < 182 && 69 <= rgbG && rgbG < 185 && 200 <= rgbB && rgbB < 228) {

							upPixel++;


						}
					}
				}
				System.out.println("上方被勾选的像素数为：" + upPixel);
				
				//识别右方勾选的像素
				
				for (int s = leftDownX; s < leftDownX + lenght; s++) {

					for (int t = leftDownY; t > leftDownY - lenght; t--) {

						

						int pixelX = image.getRGB(s, t);

						// 下面三行代码将一个数字转换为RGB数字
						rgbR = (pixelX & 0xff0000) >> 16;
						rgbG = (pixelX & 0xff00) >> 8;
						rgbB = (pixelX & 0xff);

						if (60 <= rgbR && rgbR < 182 && 69 <= rgbG && rgbG < 185 && 200 <= rgbB && rgbB < 228) {

							rightPixel++;


						}
					}
				}
				System.out.println("右边被勾选的像素数为：" + rightPixel);
				
				//识别下方勾选的像素
				for (int u = rightDownX; u < rightDownX + lenght; u++) {

					for (int v = leftDownY; v < leftDownY + lenght; v++) {

						int pixelX = image.getRGB(u, v);

						// 下面三行代码一个数字转换为RGB数字
						rgbR = (pixelX & 0xff0000) >> 16;
						rgbG = (pixelX & 0xff00) >> 8;
						rgbB = (pixelX & 0xff);

						if (60 <= rgbR && rgbR < 182 && 69 <= rgbG && rgbG < 185 && 200 <= rgbB && rgbB < 228) {

							downPixel++;


						}
					}
				}
				System.out.println("下方被勾选的像素数为：" + downPixel);
				
			}

			// ImageIO.write(image, "jpg", new
			// File("C:\\Users\\wanglei\\Desktop\\demo\\image\\outImage\\demo01.jpg"));

			// System.out.println("导出成功");

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
