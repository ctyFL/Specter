package com.ctyFL.o2o.util;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>Title: CodeUtil</p>
 * <p>Description: 校验验证码工具类</p>
 * @author ctyFL
 * @date 2021年2月13日
 */
public class CodeUtil {

	/**
	 * 校验验证码
	 * @param request
	 * @return
	 */
	public static boolean checkVerifyCode(HttpServletRequest request) {
		//从会话中获取验证码图片
		String verifyCodeExpected = String.valueOf(request.getSession()
				.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY));
		//获取用户输入验证码
		String verifyCodeActual = HttpServletRequestUtil.getStringValue(request, "verifyCodeActual");
		if(verifyCodeActual != null && !verifyCodeActual.isEmpty() && verifyCodeExpected.equals(verifyCodeActual)) {
			return true;
		}else {
			return false;
		}
	}
	
}
