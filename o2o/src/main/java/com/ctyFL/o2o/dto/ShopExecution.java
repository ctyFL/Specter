package com.ctyFL.o2o.dto;

import java.util.List;
import com.ctyFL.o2o.entity.Shop;
import com.ctyFL.o2o.enumeration.ShopStateEnum;

/**
 * <p>Title: ShopExecution</p>
 * <p>Description: 操作店铺的返回参数封装类</p>
 * @author ctyFL
 * @date 2021年1月21日
 */
public class ShopExecution {
	//店铺操作的状态值
	private int state;
	//店铺操作的状态信息
	private String stateInfo;
	//操作的店铺数量
	private int count;
	//操作的店铺实体（增删改店铺时用到）
	private Shop shop;
	//操作的店铺实体列表（查询店铺时用到）
	private List<Shop> shopList;
	
	public ShopExecution() {
		
	}
	
	//店铺操作失败时用的构造器
	public ShopExecution(ShopStateEnum stateEnum) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
	}
	
	//店铺操作成功时用的构造器
	public ShopExecution(ShopStateEnum stateEnum, Shop shop) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.shop = shop;
	}
	
	//店铺操作成功时用的构造器
	public ShopExecution(ShopStateEnum stateEnum, List<Shop> shopList) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.shopList = shopList;
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public List<Shop> getShopList() {
		return shopList;
	}

	public void setShopList(List<Shop> shopList) {
		this.shopList = shopList;
	}
	
}
