package com.movingcq.entity;

import java.util.Date;

public class CarWeigh {
    private String id;

    private Date createtime;

    private Date lastchangetime;

    private Integer status;

    private Integer beendeleted;

    private Date deletedtime;

    private String carcode;

    private String carid;

    private Date carphotocapturetime;

    private String carphotorealtimeid;

    private String carweighid;

    private String matchstatus;

    private Float netweigh;

    private String recordstatus;

    private String restaurantid;

    private String restaurantname;

    private String rfidcode;

    private Date rfidcreatetime;

    private String rfidrecordrealtimeid;

    private Date weightime;

    private String gpscarpositionid;

    private Double gpslatitude;

    private Double gpslongitude;

    private Double latitudedone;

    private Double longitudedone;

    private String devcode;

    private Double grossweight;

    private Double tareweight;

    private Double carmileage;

    private String remark;

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

    public String getCarid() {
        return carid;
    }

    public void setCarid(String carid) {
        this.carid = carid == null ? null : carid.trim();
    }

    public Date getCarphotocapturetime() {
        return carphotocapturetime;
    }

    public void setCarphotocapturetime(Date carphotocapturetime) {
        this.carphotocapturetime = carphotocapturetime;
    }

    public String getCarphotorealtimeid() {
        return carphotorealtimeid;
    }

    public void setCarphotorealtimeid(String carphotorealtimeid) {
        this.carphotorealtimeid = carphotorealtimeid == null ? null : carphotorealtimeid.trim();
    }

    public String getCarweighid() {
        return carweighid;
    }

    public void setCarweighid(String carweighid) {
        this.carweighid = carweighid == null ? null : carweighid.trim();
    }

    public String getMatchstatus() {
        return matchstatus;
    }

    public void setMatchstatus(String matchstatus) {
        this.matchstatus = matchstatus == null ? null : matchstatus.trim();
    }

    public Float getNetweigh() {
        return netweigh;
    }

    public void setNetweigh(Float netweigh) {
        this.netweigh = netweigh;
    }

    public String getRecordstatus() {
        return recordstatus;
    }

    public void setRecordstatus(String recordstatus) {
        this.recordstatus = recordstatus == null ? null : recordstatus.trim();
    }

    public String getRestaurantid() {
        return restaurantid;
    }

    public void setRestaurantid(String restaurantid) {
        this.restaurantid = restaurantid == null ? null : restaurantid.trim();
    }

    public String getRestaurantname() {
        return restaurantname;
    }

    public void setRestaurantname(String restaurantname) {
        this.restaurantname = restaurantname == null ? null : restaurantname.trim();
    }

    public String getRfidcode() {
        return rfidcode;
    }

    public void setRfidcode(String rfidcode) {
        this.rfidcode = rfidcode == null ? null : rfidcode.trim();
    }

    public Date getRfidcreatetime() {
        return rfidcreatetime;
    }

    public void setRfidcreatetime(Date rfidcreatetime) {
        this.rfidcreatetime = rfidcreatetime;
    }

    public String getRfidrecordrealtimeid() {
        return rfidrecordrealtimeid;
    }

    public void setRfidrecordrealtimeid(String rfidrecordrealtimeid) {
        this.rfidrecordrealtimeid = rfidrecordrealtimeid == null ? null : rfidrecordrealtimeid.trim();
    }

    public Date getWeightime() {
        return weightime;
    }

    public void setWeightime(Date weightime) {
        this.weightime = weightime;
    }

    public String getGpscarpositionid() {
        return gpscarpositionid;
    }

    public void setGpscarpositionid(String gpscarpositionid) {
        this.gpscarpositionid = gpscarpositionid == null ? null : gpscarpositionid.trim();
    }

    public Double getGpslatitude() {
        return gpslatitude;
    }

    public void setGpslatitude(Double gpslatitude) {
        this.gpslatitude = gpslatitude;
    }

    public Double getGpslongitude() {
        return gpslongitude;
    }

    public void setGpslongitude(Double gpslongitude) {
        this.gpslongitude = gpslongitude;
    }

    public Double getLatitudedone() {
        return latitudedone;
    }

    public void setLatitudedone(Double latitudedone) {
        this.latitudedone = latitudedone;
    }

    public Double getLongitudedone() {
        return longitudedone;
    }

    public void setLongitudedone(Double longitudedone) {
        this.longitudedone = longitudedone;
    }

    public String getDevcode() {
        return devcode;
    }

    public void setDevcode(String devcode) {
        this.devcode = devcode == null ? null : devcode.trim();
    }

    public Double getGrossweight() {
        return grossweight;
    }

    public void setGrossweight(Double grossweight) {
        this.grossweight = grossweight;
    }

    public Double getTareweight() {
        return tareweight;
    }

    public void setTareweight(Double tareweight) {
        this.tareweight = tareweight;
    }

    public Double getCarmileage() {
        return carmileage;
    }

    public void setCarmileage(Double carmileage) {
        this.carmileage = carmileage;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}