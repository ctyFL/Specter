package com.ctyFL.o2o.util;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>Title: HttpServletRequestUtil</p>
 * <p>Description: HttpServletRequest参数的工具类</p>
 * @author ctyFL
 * @date 2021年2月06日
 */
public class HttpServletRequestUtil {

	public static int getIntValue(HttpServletRequest request, String key) {
		try {
			return Integer.decode(request.getParameter(key));
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public static long getLongValue(HttpServletRequest request, String key) {
		try {
			return Long.valueOf(request.getParameter(key));
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public static Double getDoubleValue(HttpServletRequest request, String key) {
		try {
			return Double.valueOf(request.getParameter(key));
		} catch (Exception e) {
			e.printStackTrace();
			return -1d;
		}
	}
	
	public static boolean getBooleanValue(HttpServletRequest request, String key) {
		try {
			return Boolean.valueOf(request.getParameter(key));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static String getStringValue(HttpServletRequest request, String key) {
		try {
			String value = request.getParameter(key);
			if(value != null && !value.isEmpty()) {
				return value.trim();
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
