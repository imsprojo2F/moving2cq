package com.movingcq.entity;

import java.util.Date;

public class DailyReport {
    private Integer id;

    private String area;

    private String stree;

    private Date date;

    private Double weight;

    private Integer restaurantCountNew;

    private Integer restaurantCountLogout;

    private Integer restaurantCount;

    private Integer restaurantCountRc;

    private Double weightAvg;

    private Integer rfidCount;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getStree() {
        return stree;
    }

    public void setStree(String stree) {
        this.stree = stree == null ? null : stree.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getRestaurantCountNew() {
        return restaurantCountNew;
    }

    public void setRestaurantCountNew(Integer restaurantCountNew) {
        this.restaurantCountNew = restaurantCountNew;
    }

    public Integer getRestaurantCountLogout() {
        return restaurantCountLogout;
    }

    public void setRestaurantCountLogout(Integer restaurantCountLogout) {
        this.restaurantCountLogout = restaurantCountLogout;
    }

    public Integer getRestaurantCount() {
        return restaurantCount;
    }

    public void setRestaurantCount(Integer restaurantCount) {
        this.restaurantCount = restaurantCount;
    }

    public Integer getRestaurantCountRc() {
        return restaurantCountRc;
    }

    public void setRestaurantCountRc(Integer restaurantCountRc) {
        this.restaurantCountRc = restaurantCountRc;
    }

    public Double getWeightAvg() {
        return weightAvg;
    }

    public void setWeightAvg(Double weightAvg) {
        this.weightAvg = weightAvg;
    }

    public Integer getRfidCount() {
        return rfidCount;
    }

    public void setRfidCount(Integer rfidCount) {
        this.rfidCount = rfidCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}