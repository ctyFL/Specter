package com.ctyFL.o2o.enumeration;
/**
 * <p>Title: ShopStateEnum</p>
 * <p>Description: 店铺操作状态的枚举类</p>
 * @author ctyFL
 * @date 2021年1月21日
 */
public enum ShopStateEnum {
	CHECK(0, "审核中"),
	OFFLINE(-1, "店铺非法"),
	SUCCESS(1, "操作成功"),
	PASS(2, "通过认证"),
	INNER_ERROR(-1001, "内部系统错误"),
	NULL_SHOPID(-1002, "ShopId为空"),
	NULL_SHOP(-1003, "Shop为空");
	
	private int state;
	private String stateInfo;
	
	/**
	 * 私有构造器，因为我们不希望外部程序构造这个枚举类，而是希望通过上面定义的枚举值来构造
	 */
	private ShopStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}
	
	/**
	 * 依据传入的state值返回相应的enum值
	 * @param state
	 * @return
	 */
	public static ShopStateEnum stateOf(int state) {
		for(ShopStateEnum stateEnum : values()) {
			if(stateEnum.getState() == state) {
				return stateEnum;
			}
		}
		return null;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}
	
}
