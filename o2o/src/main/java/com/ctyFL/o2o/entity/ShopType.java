package com.ctyFL.o2o.entity;

import java.util.Date;

/**
 * @author ctyFL
 * 店铺类别
 */
public class ShopType {

	private Long ID;
	private String Name;
	//描述
	private String Description;
	private String Img;
	//权重
	private Integer Priority;
	private Date DataCreationDate;
	private Date LastModifyTime;
	private Long ParentId;
	
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
	public Long getParentId() {
		return ParentId;
	}
	public void setParentId(Long parentId) {
		ParentId = parentId;
	}
	
}
