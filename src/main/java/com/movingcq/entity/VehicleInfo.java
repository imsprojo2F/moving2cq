/**   
* @Title: VehicleInfo.java 
* @Package com.movingcq.entity 
* @Description: TODO(用一句话描述该文件做什么) 
* @author IsProjo
* @date 2016年12月21日 上午9:52:31 
* @version V1.0   
*/
package com.movingcq.entity;

/**
 * @ClassName: VehicleInfo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author IsProjo
 * @date 2016年12月21日 上午9:52:31
 * 
 */
public class VehicleInfo {

	public Integer id;
	public String vehicle_number;
	public String vehicle_type;
	public Integer company_id;
	public String company_name;
	public String create_time;
	public String update_time;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVehicle_number() {
		return vehicle_number;
	}

	public void setVehicle_number(String vehicle_number) {
		this.vehicle_number = vehicle_number;
	}

	public String getVehicle_type() {
		return vehicle_type;
	}

	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}

	public Integer getCompany_id() {
		return company_id;
	}

	public void setCompany_id(Integer company_id) {
		this.company_id = company_id;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
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
		return "VehicleInfo [id=" + id + ", vehicle_number=" + vehicle_number + ", vehicle_type=" + vehicle_type
				+ ", company_id=" + company_id + ", company_name=" + company_name + ", create_time=" + create_time
				+ ", update_time=" + update_time + "]";
	}

}
