package com.ctyFL.o2o.entity;

import java.util.Date;

/**
 * @author ctyFL
 * 微信用户
 */
public class WechatUser {

	private Long ID;
	private String OpenId;
	private Date DatacreationDate;
	private Date LastModifyTime;
	private Long PersonInfo_ID;
	
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public String getOpenId() {
		return OpenId;
	}
	public void setOpenId(String openId) {
		OpenId = openId;
	}
	public Date getDatacreationDate() {
		return DatacreationDate;
	}
	public void setDatacreationDate(Date datacreationDate) {
		DatacreationDate = datacreationDate;
	}
	public Date getLastModifyTime() {
		return LastModifyTime;
	}
	public void setLastModifyTime(Date lastModifyTime) {
		LastModifyTime = lastModifyTime;
	}
	public Long getPersonInfo_ID() {
		return PersonInfo_ID;
	}
	public void setPersonInfo_ID(Long personInfo_ID) {
		PersonInfo_ID = personInfo_ID;
	}
	
}
