package com.ctyFL.o2o.util;

import java.io.File;
import java.util.regex.Matcher;

/**
 * <p>Title: PathUtil</p>
 * <p>Description: 路径工具类</p>
 * @author ctyFL
 * @date 2021年1月20日
 */
public class PathUtil {
	
	/**
	 * 获取当前操作系统的分隔符
	 */
	private static String separator = System.getProperty("file.separator");

	/**
	 * 返回存储图片的目标根路径（绝对路径）
	 * @return
	 */
	public static String getImgBasePath() {
		//获取当前操作系统的名称（类型：windows、linux...）
		String os = System.getProperty("os.name");
		String basePath = "";
		if(os.toLowerCase().startsWith("win")) {//若是windows操作系统
			//不将图片保存在工程的resources下，是因为工程重新部署的时候，之前生成的图片就会被删除掉了
			//并且用户会源源不断地上传图片，所以要将图片存储的位置放在工程路径外，防止被自动删除掉
			basePath = "E:/gitHubDev/image/";
		}else {//若是其他操作系统
			basePath = "/home/gitHubDev/image/";
		}
		//替换为当前系统的分隔符
		basePath = basePath.replace("/", separator);
		return basePath;
	}
	
	/**
	 * 返回存储图片的目标相对子路径
	 * @param shopId
	 * @return
	 */
	public static String getShopImgPath(long shopId) {
		String imagePath = "/upload/item/shop/" + shopId + "/";
		//替换为当前系统的分隔符
		return imagePath.replace("/",  separator);
	}
}
