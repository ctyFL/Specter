package com.ctyFL.o2o.util;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.junit.Test;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

/**
 * <p>Title: ImageUtilTest</p>
 * <p>Description: Thumbnailator图片处理的单元测试</p>
 * @author ctyFL
 * @date 2021年1月20日
 */
public class ImageUtilTest {
	
	/**
	 * 给图片添加水印并重新生成一个缩略图测试
	 * @throws IOException 
	 */
	@Test
	public void addWatermarkAndGenerateThumbnailsTest() throws IOException {
		//读取测试的要添加水印的图片
		File imgFile = new File("E:/gitHubDev/image/testimg.png");
		//通过线程逆推得到类加载器，从而通过类加载器得到资源的路径
		//因为是单元测试，所以资源路径为test/main/resources下
		String classPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		//读取测试的水印图片
		File watermarkImgFile = new File(classPath + "/image/icon/icon_fl.png");
		
		Thumbnails.of(imgFile)//Thumbnailator图片处理工具类的主类.读取要处理的图片
		.size(200, 200)//大小：长、宽，单位：像素
		.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(watermarkImgFile), 0.25f)//水印：Positiion.BOTTOM_RIGHT——位置右下角，ImageIO.read——读取水印图片的文件流，0.25f——透明度为0.25
		.outputQuality(0.8f)//压缩图片：80%
		.toFile("E:/gitHubDev/image/testimgnew.png");//输出路径：输出到图片原来的路径，命名为testimgnew.png
	}

}
