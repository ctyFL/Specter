package com.ctyFL.o2o.entity;

import java.util.Date;

/**
 * @author ctyFL
 * 商品类别
 */
public class ProductType {

	private Long ID;
	private String Name;
	//权重
	private Integer Priority;
	private Long Shop_ID;
	private Date DataCreationDate;
	private Date LastModifyTime;
	
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Integer getPriority() {
		return Priority;
	}
	public void setPriority(Integer priority) {
		Priority = priority;
	}
	public Long getShop_ID() {
		return Shop_ID;
	}
	public void setShop_ID(Long shop_ID) {
		Shop_ID = shop_ID;
	}
	public Date getDataCreationDate() {
		return DataCreationDate;
	}
	public void setDataCreationDate(Date dataCreationDate) {
		DataCreationDate = dataCreationDate;
	}
	public Date getLastModifyTime() {
		return LastModifyTime;
	}
	public void setLastModifyTime(Date lastModifyTime) {
		LastModifyTime = lastModifyTime;
	}
	
}
