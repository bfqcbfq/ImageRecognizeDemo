package com.ivision.app;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;

import com.ivision.app.domain.Rgb;

public class OuterChecboxRecognize {

	public static void main(String[] args) {

		int rgbR;
		int rgbG;
		int rgbB;
		
		Rgb rgb =null;
		
		Set<Rgb> rgbSet = null;

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
			
			//Set<Rgb> rgbSet =new HashSet<Rgb>();
			
			
			
			
			Set<Object> rgbGSet = new HashSet<>();
			
			Set<Object> rgbBSet = new HashSet<>();
			
			List<Object> rgbRList = new ArrayList<>();
			
			Map<Integer, HashSet<Rgb>> rgbMap = new HashMap<>();

	
			
			
			rgbSet =new HashSet<Rgb>();
			for (int m = 0; m < width; m++) {

				
				for (int n = 1853; n < height ; n++) {

					int pixelX = image.getRGB(m, n);
					rgb = new Rgb();
					// 下面三行代码将一个数字转换为RGB数字
					rgbR = (pixelX & 0xff0000) >> 16;
					rgbG = (pixelX & 0xff00) >> 8;
					rgbB = (pixelX & 0xff);
					
					
					rgb.setRgbR(rgbR);
					rgb.setRgbG(rgbG);
					rgb.setRgbB(rgbB);
					
					count++;
					
					rgbSet.add(rgb);
					
					//System.out.println("第"+count+"个像素点的坐标为："+"(" + m + "," + n + ")"+"RGB"+":(" + rgbR + "," + rgbG + "," + rgbB + ")");
					
				}
			}
			System.out.println(rgbSet);
			rgbList.addAll(rgbSet);
			System.out.println(rgbList.size());
			int diffRCount = 0;
			int diffGCount = 0;
			int diffBCount = 0;
			boolean rgbRFirstFlag  = true;
			for(int i =0; i<rgbList.size()-1;i++) {

				double previousRgbR2 = 0;;
				double previousRgbG2 = 0;
				double previousRgbB2 = 0;
				if(rgbRFirstFlag) {
					
					 previousRgbR2  = rgbList.get(i).getRgbR();
				
					
					 previousRgbG2 = rgbList.get(i).getRgbG();
				
					
					 previousRgbB2 = rgbList.get(i).getRgbB();
				}
				
				for(int j =i+1; j<rgbList.size();j++) {
					
					double nextRgbR2 = rgbList.get(j).getRgbR();
					double nextRgbG2 = rgbList.get(j).getRgbR();
					double nextRgbB2 = rgbList.get(j).getRgbB();

					if((previousRgbR2/nextRgbR2)>1.5) {
						
						diffRCount++;
					}else if((previousRgbG2/nextRgbG2)>1.5){
						
						diffGCount++;
					}else if((previousRgbB2/nextRgbB2)>1.5) {
						
						diffBCount++;
					}
				}
				
			}
			
			System.out.println("R色差大于5%的像素有"+diffRCount+"个");
			
			
			System.out.println("G色差大于5%的像素有"+diffGCount+"个");
			
			
			System.out.println("B色差大于5%的像素有"+diffBCount+"个");
			
			
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
