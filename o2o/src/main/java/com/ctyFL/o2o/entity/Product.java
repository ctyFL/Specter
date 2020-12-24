package com.ctyFL.o2o.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ctyFL
 * 商品
 */
public class Product {

	private Long ID;
	private String Name;
	//描述
	private String Description;
	//缩略图
	private String IconImgUrl;
	//原价
	private BigDecimal NormalPrice;
	//折扣价
	private BigDecimal PromotionPrice;
	private Integer Priority;
	//状态 0：可用 1：不可用 2：已下架
	private Integer Status;
	private Long Shop_ID;
	private Long ProductType_ID;
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
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getIconImgUrl() {
		return IconImgUrl;
	}
	public void setIconImgUrl(String iconImgUrl) {
		IconImgUrl = iconImgUrl;
	}
	public BigDecimal getNormalPrice() {
		return NormalPrice;
	}
	public void setNormalPrice(BigDecimal normalPrice) {
		NormalPrice = normalPrice;
	}
	public BigDecimal getPromotionPrice() {
		return PromotionPrice;
	}
	public void setPromotionPrice(BigDecimal promotionPrice) {
		PromotionPrice = promotionPrice;
	}
	public Integer getPriority() {
		return Priority;
	}
	public void setPriority(Integer priority) {
		Priority = priority;
	}
	public Integer getStatus() {
		return Status;
	}
	public void setStatus(Integer status) {
		Status = status;
	}
	public Long getShop_ID() {
		return Shop_ID;
	}
	public void setShop_ID(Long shop_ID) {
		Shop_ID = shop_ID;
	}
	public Long getProductType_ID() {
		return ProductType_ID;
	}
	public void setProductType_ID(Long productType_ID) {
		ProductType_ID = productType_ID;
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
