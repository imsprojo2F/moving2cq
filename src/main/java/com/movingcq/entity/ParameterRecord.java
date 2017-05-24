package com.movingcq.entity;

import java.util.Date;

public class ParameterRecord {
	private String id;

	private Date createtime;

	private Date lastchangetime;

	private Integer status;

	private Integer beendeleted;

	private Date deletedtime;

	private String description;

	private String displayvalue;

	private Integer orderindex;

	private String parametervaluetype;

	private String value;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getLastchangetime() {
		return lastchangetime;
	}

	public void setLastchangetime(Date lastchangetime) {
		this.lastchangetime = lastchangetime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getBeendeleted() {
		return beendeleted;
	}

	public void setBeendeleted(Integer beendeleted) {
		this.beendeleted = beendeleted;
	}

	public Date getDeletedtime() {
		return deletedtime;
	}

	public void setDeletedtime(Date deletedtime) {
		this.deletedtime = deletedtime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public String getDisplayvalue() {
		return displayvalue;
	}

	public void setDisplayvalue(String displayvalue) {
		this.displayvalue = displayvalue == null ? null : displayvalue.trim();
	}

	public Integer getOrderindex() {
		return orderindex;
	}

	public void setOrderindex(Integer orderindex) {
		this.orderindex = orderindex;
	}

	public String getParametervaluetype() {
		return parametervaluetype;
	}

	public void setParametervaluetype(String parametervaluetype) {
		this.parametervaluetype = parametervaluetype == null ? null : parametervaluetype.trim();
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value == null ? null : value.trim();
	}

	@Override
	public String toString() {
		return "ParameterRecord [id=" + id + ", createtime=" + createtime + ", lastchangetime=" + lastchangetime
				+ ", status=" + status + ", beendeleted=" + beendeleted + ", deletedtime=" + deletedtime
				+ ", description=" + description + ", displayvalue=" + displayvalue + ", orderindex=" + orderindex
				+ ", parametervaluetype=" + parametervaluetype + ", value=" + value + "]";
	}

}