package com.ctyFL.o2o.entity;

import java.util.Date;

/**
 * @author ctyFL
 * 店铺
 */
public class Shop {

	private Long ID;
	private String Name;
	//描述
	private String Description;
	private String Address;
	private String Phone;
	private String Img;
	//权重
	private Integer Priority;
	private Date DataCreationDate;
	private Date LastModifyTime;
	//状态 0：可用 1：审核中 2：不可用
	private Integer Status;
	//管理员的建议
	private String Advice;
	private Long Area_ID;
	private Long PersonInfo_ID;
	private Long ShopType_ID;
	
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
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getImg() {
		return Img;
	}
	public void setImg(String img) {
		Img = img;
	}
	public Integer getPriority() {
		return Priority;
	}
	public void setPriority(Integer priority) {
		Priority = priority;
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
	public Integer getStatus() {
		return Status;
	}
	public void setStatus(Integer status) {
		Status = status;
	}
	public String getAdvice() {
		return Advice;
	}
	public void setAdvice(String advice) {
		Advice = advice;
	}
	public Long getArea_ID() {
		return Area_ID;
	}
	public void setArea_ID(Long area_ID) {
		Area_ID = area_ID;
	}
	public Long getPersonInfo_ID() {
		return PersonInfo_ID;
	}
	public void setPersonInfo_ID(Long personInfo_ID) {
		PersonInfo_ID = personInfo_ID;
	}
	public Long getShopType_ID() {
		return ShopType_ID;
	}
	public void setShopType_ID(Long shopType_ID) {
		ShopType_ID = shopType_ID;
	}
	
}
