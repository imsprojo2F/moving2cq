package com.movingcq.entity;

import java.util.Date;

public class CarInfo {
    private String id;

    private Date createtime;

    private Date lastchangetime;

    private Integer status;

    private Integer beendeleted;

    private Date deletedtime;

    private String carcode;

    private String carload;

    private String driverphone;

    private String driver;

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

    public String getCarcode() {
        return carcode;
    }

    public void setCarcode(String carcode) {
        this.carcode = carcode == null ? null : carcode.trim();
    }

    public String getCarload() {
        return carload;
    }

    public void setCarload(String carload) {
        this.carload = carload == null ? null : carload.trim();
    }

    public String getDriverphone() {
        return driverphone;
    }

    public void setDriverphone(String driverphone) {
        this.driverphone = driverphone == null ? null : driverphone.trim();
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver == null ? null : driver.trim();
    }
}