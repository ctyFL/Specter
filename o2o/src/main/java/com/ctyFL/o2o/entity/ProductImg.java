package com.ctyFL.o2o.entity;

import java.util.Date;

/**
 * @author ctyFL
 * 商品图片
 */
public class ProductImg {

	private Long ID;
	private String Url;
	//描述
	private String Description;
	//权重
	private Integer Priority;
	private Long Product_ID;
	private Date DataCreationDate;
	private Date LastModifyTime;
	
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Integer getPriority() {
		return Priority;
	}
	public void setPriority(Integer priority) {
		Priority = priority;
	}
	public Long getProduct_ID() {
		return Product_ID;
	}
	public void setProduct_ID(Long product_ID) {
		Product_ID = product_ID;
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
