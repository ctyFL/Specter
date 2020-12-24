package com.ctyFL.o2o.entity;

/**
 * @author ctyFL
 * 区域
 */
import java.util.Date;

public class Area {

	private Long ID;
	private String Name;
	//权重
	private Integer Priority;
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
