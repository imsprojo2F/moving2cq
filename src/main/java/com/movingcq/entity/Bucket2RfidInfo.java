/**   
* @Title: BucketInfo.java 
* @Package com.movingcq.entity 
* @Description: TODO(用一句话描述该文件做什么) 
* @author IsProjo
* @date 2016年12月14日 下午4:31:23 
* @version V1.0   
*/
package com.movingcq.entity;

/**
 * @ClassName: BucketInfo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author IsProjo
 * @date 2016年12月14日 下午4:31:23
 * 
 */
public class Bucket2RfidInfo {

	public Integer id;
	public String bucket_code;
	public String bucket_mode;
	public Integer is_binding;
	public Double volume;
	public Integer rfid_id;
	public String create_time;
	public String update_time;
	public String rfid;
	public String rfid_status;

	public Integer getIs_binding() {
		return is_binding;
	}

	public void setIs_binding(Integer is_binding) {
		this.is_binding = is_binding;
	}

	public Integer getRfid_id() {
		return rfid_id;
	}

	public void setRfid_id(Integer rfid_id) {
		this.rfid_id = rfid_id;
	}

	public String getRfid_status() {
		return rfid_status;
	}

	public void setRfid_status(String rfid_status) {
		this.rfid_status = rfid_status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBucket_code() {
		return bucket_code;
	}

	public void setBucket_code(String bucket_code) {
		this.bucket_code = bucket_code;
	}

	public String getBucket_mode() {
		return bucket_mode;
	}

	public void setBucket_mode(String bucket_mode) {
		this.bucket_mode = bucket_mode;
	}

	public Double getVolume() {
		return volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

	public String getRfid() {
		return rfid;
	}

	public void setRfid(String rfid) {
		this.rfid = rfid;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}

	@Override
	public String toString() {
		return "BucketInfo [id=" + id + ", bucket_code=" + bucket_code + ", bucket_mode=" + bucket_mode + ", volume="
				+ volume + ", rfid=" + rfid + ", create_time=" + create_time + ", update_time=" + update_time + "]";
	}

}
