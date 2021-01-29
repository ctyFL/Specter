package com.ctyFL.o2o.exceptions;
/**
 * <p>Title: ShopOperationException</p>
 * <p>Description: 店铺操作异常封装类</p>
 * <p>继承RuntimeException：因为当前程序只有抛出RuntimeException
 * 及RuntimeException的子类的Exception的时候，事务才会终止、回滚</p>
 * @author ctyFL
 * @date 2021年1月29日
 */
public class ShopOperationException extends RuntimeException {

	private static final long serialVersionUID = -3273829335414820060L;

	public ShopOperationException(String msg) {
		super(msg);
	}
	
}
