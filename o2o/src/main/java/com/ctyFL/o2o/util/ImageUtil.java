package com.ctyFL.o2o.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.imageio.ImageIO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

/**
 * <p>Title: ImageUtil</p>
 * <p>Description: 图片工具类</p>
 * @author ctyFL
 * @date 2021年1月20日
 */
public class ImageUtil {
	private static Logger logger = LoggerFactory.getLogger(ImageUtil.class);
	
	//通过线程逆推得到类加载器，从而通过类加载器得到classPath的绝对值路径
	private static String classPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	private static final Random random = new Random();
	
	/**
	 * 将CommonsMultipartFile转换成java.io.File
	 * CommonsMultipartFile：是spring中接收前端上传的文件的类
	 * @param cFile
	 * @return
	 */
	public static File transferCommonsMultipartFileToFile(CommonsMultipartFile cFile) {
		File file = new File(cFile.getOriginalFilename());
		try {
			cFile.transferTo(file);
		} catch (IllegalStateException | IOException e) {
			logger.error(e.toString());
			e.printStackTrace();
		}
		return file;
	}
	
	/**
	 * 处理缩略图，并返回新生成图片存储的目标相对路径
	 * @param file
	 * @param targetPath
	 * @return
	 */
	public static String generateThumbnail(InputStream inputStream, String fileName, String targetPath) {
		//文件名
		String realFileName = getRandomFileName();
		//文件扩展名（格式）
		String extension = getFileExtension(fileName);
		//创建文件夹
		makeDirPath(targetPath);
		//相对路径
		String relativePath = targetPath + realFileName + extension;
		logger.debug("图片存储的目标相对路径：" + relativePath);
		//保存文件的全路径（绝对路径）
		String saveFilePath = PathUtil.getImgBasePath() + relativePath;
		logger.debug("图片存储的目标绝对路径：" + saveFilePath);
		File saveFile = new File(saveFilePath);
		//读取测试的水印图片
		File watermarkImgFile = new File(classPath + "/image/icon/icon_fl.png");
		try {
			Thumbnails.of(inputStream)//Thumbnailator图片处理工具类的主类.读取要处理的图片
			.size(1628, 762)//大小：长、宽，单位：像素（即要生成的图片的长、宽的像素）
			.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(watermarkImgFile), 0.25f)//水印：Positiion.BOTTOM_RIGHT——位置右下角，ImageIO.read——读取水印图片的文件流，0.25f——透明度为0.25
			.outputQuality(0.8f)//压缩图片：80%
			.toFile(saveFile);//输出路径：输出到保存文件的目标路径
		} catch (IOException e) {
			logger.error(e.toString());
			e.printStackTrace();
		}
		//返回目标图片存储的相对地址
		//返回相对地址而不是绝对地址：是因为希望以后假如程序迁移到别的系统，也能正常读取图片，而不需要去改变相应实体的图片路径值，因为读取到绝对路径，再动态拼上实际根路径（绝对路径）就可以正常读取了
		return relativePath;
	}

	/**
	 * 生成随机文件名：当前年月日时分秒+随机五位数
	 * @return
	 */
	public static String getRandomFileName() {
		int ranNum = random.nextInt(89999) + 10000;
		String nowTimeStr = sdf.format(new Date());
		return nowTimeStr + ranNum;
	}
	
	/**
	 * 获取输入文件的扩展名（格式）
	 * @param file
	 * @return
	 */
	private static String getFileExtension(String fileName) {
		return fileName.substring(fileName.lastIndexOf("."));
	}
	
	/**
	 * 创建目标路径所涉及到的目录\文件夹
	 * @param targetPath
	 */
	private static void makeDirPath(String targetPath) {
		//因为传入的targetPath是相对路径，因此需要获取全路径（绝对路径）
		String realFileTargetPath = PathUtil.getImgBasePath() + targetPath;
		File dirPath = new File(realFileTargetPath);
		if(!dirPath.exists()) {
			dirPath.mkdirs();
		}
	}

}
