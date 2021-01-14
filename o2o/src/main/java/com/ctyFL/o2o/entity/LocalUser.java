package com.ctyFL.o2o.entity;

import java.util.Date;

/**
 * @author ctyFL
 * 本地用户
 */
public class LocalUser {

	private Long ID;
	private String Username;
	private String Password;
	private Long PersonInfo_ID;
	private Date DataCreationDate;
	private Date LastModifyTime;
	
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public Long getPersonInfo_ID() {
		return PersonInfo_ID;
	}
	public void setPersonInfo_ID(Long personInfo_ID) {
		PersonInfo_ID = personInfo_ID;
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
