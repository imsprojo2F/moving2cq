package com.movingcq.entity;

import java.math.BigDecimal;

public class MapBasicInfo {
	private Integer id;

	private String restaurantUid;

	private Integer carId;

	private Integer type;

	private BigDecimal longitude;

	private BigDecimal latitude;

	private Integer selectType;

	private Integer order_num;

	private String createTime;

	private String updateTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRestaurantUid() {
		return restaurantUid;
	}

	public void setRestaurantUid(String restaurantUid) {
		this.restaurantUid = restaurantUid == null ? null : restaurantUid.trim();
	}

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public Integer getSelectType() {
		return selectType;
	}

	public void setSelectType(Integer selectType) {
		this.selectType = selectType;
	}

	public Integer getOrderNum() {
		return order_num;
	}

	public void setOrderNum(Integer order_num) {
		this.order_num = order_num;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime == null ? null : createTime.trim();
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime == null ? null : updateTime.trim();
	}
}