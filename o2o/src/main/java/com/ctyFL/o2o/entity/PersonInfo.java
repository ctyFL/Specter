package com.ctyFL.o2o.entity;

import java.util.Date;

/**
 * @author ctyFL
 * 用户信息
 */
public class PersonInfo {

	private Long ID;
	private String Name;
	//头像
	private String ProfileImg;
	private String Email;
	//性别 0：女 1：男
	private Integer Gender;
	//用户状态 0：有效 1：无效
	private Integer Status;
	//用户类型 0：顾客 1：商家 2：系统管理员
	private Integer UserType;
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
	public String getProfileImg() {
		return ProfileImg;
	}
	public void setProfileImg(String profileImg) {
		ProfileImg = profileImg;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public Integer getGender() {
		return Gender;
	}
	public void setGender(Integer gender) {
		Gender = gender;
	}
	public Integer getStatus() {
		return Status;
	}
	public void setStatus(Integer status) {
		Status = status;
	}
	public Integer getUserType() {
		return UserType;
	}
	public void setUserType(Integer userType) {
		UserType = userType;
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
