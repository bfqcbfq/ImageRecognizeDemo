package com.ivision.app;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;

import com.ivision.app.domain.Rgb;

public class OuterChecboxRecognize {

	public static void main(String[] args) {

		int rgbR;
		int rgbG;
		int rgbB;

		// 待处理的图片
		String filePath = "C:\\Users\\wanglei\\Desktop\\demo\\image\\SKM_C454e19103013150_0003.jpg";

		try {

			BufferedImage image = readImageFile(filePath);

			int width = image.getWidth();// 图片宽度
			int height = image.getHeight();// 图片高度
			
			//图片像素点的数量
			int count = 0;
			System.out.println("图片宽度为：" + width + ",高度为:" + height);
			
			List<Rgb> rgbList = new ArrayList<Rgb>();
			
			Set<Rgb> rgbSet = new HashSet<Rgb>();
			
			HashSet<Integer> hashCodeSet = new HashSet<>();
			
			Rgb rgb = new Rgb();
//			
//			Set<Object> rgbRSet = new HashSet<>();
//			
//			Set<Object> rgbGSet = new HashSet<>();
//			
//			Set<Object> rgbBSet = new HashSet<>();
//			
//			Map<Integer, HashSet<Rgb>> rgbMap = new HashMap<>();

	
			
			
			for (int m = 750; m < 800; m++) {

				for (int n = 300; n < 350 ; n++) {

					int pixelX = image.getRGB(m, n);

					// 下面三行代码将一个数字转换为RGB数字
					rgbR = (pixelX & 0xff0000) >> 16;
					rgbG = (pixelX & 0xff00) >> 8;
					rgbB = (pixelX & 0xff);
					
					rgb.setRgbR(rgbR);
					rgb.setRgbG(rgbG);
					rgb.setRgbB(rgbB);
					count++;
					
					rgbList.add(rgb);
					
					//System.out.println("第"+count+"个像素点的坐标为："+"(" + m + "," + n + ")"+"RGB"+":(" + rgbR + "," + rgbG + "," + rgbB + ")");

					//x(1+0.05)=y
					
					//y/x=1.05;
					
					//rgbSet.add(rgb);
					
					
					//System.out.println(rgbSet.size());
					
				}
			}
			//System.out.println(rgbList.size());
			int diffRCount = 0;
			int diffGCount = 0;
			int diffBCount = 0;
			for(int i =0; i<rgbList.size()-1;i++) {
				
				
				
				double previousRgbR2 = rgbList.get(i).getRgbR();
				double previousRgbG2 = rgbList.get(i).getRgbG();
				double previousRgbB2 = rgbList.get(i).getRgbB();
				
				for(int j =i+1; j<=rgbList.size();j++) {
					
					double nextRgbR2 = rgbList.get(j).getRgbR();
					double nextRgbG2 = rgbList.get(j).getRgbR();
					double nextRgbB2 = rgbList.get(j).getRgbB();
					
					if((previousRgbR2/nextRgbR2)>1.05) {
						
						diffRCount++;
					}else if((previousRgbG2/nextRgbG2)>1.05){
						diffGCount++;
						
					}else if((previousRgbB2/nextRgbB2)>1.15) {
						
						diffBCount++;
					}
				}
				
				
				
			}
			
			System.out.println(diffRCount);
			System.out.println(diffGCount);
			System.out.println(diffBCount);
			
			
			
			
			//rgbSet.addAll(rgbList);
			
			//rgbList = new ArrayList<>(new LinkedHashSet<>(rgbList));
			
			//System.out.println(rgbList);
			//System.out.println(rgbSet);
			
			System.out.println("页面共有"+count+"个像素点");


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
