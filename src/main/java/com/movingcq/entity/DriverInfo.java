/**   
* @Title: DriverInfo.java 
* @Package com.movingcq.entity 
* @Description: TODO(用一句话描述该文件做什么) 
* @author IsProjo
* @date 2016年12月21日 上午9:48:51 
* @version V1.0   
*/
package com.movingcq.entity;

/**
 * @ClassName: DriverInfo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author IsProjo
 * @date 2016年12月21日 上午9:48:51
 * 
 */
public class DriverInfo {

	public Integer id;
	public String pic_code;
	public String name;
	public String id_card_number;
	public String phone_number;
	public String photo_name;
	public String src;
	public String create_time;
	public String update_time;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPic_code() {
		return pic_code;
	}

	public void setPic_code(String pic_code) {
		this.pic_code = pic_code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId_card_number() {
		return id_card_number;
	}

	public void setId_card_number(String id_card_number) {
		this.id_card_number = id_card_number;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getPhoto_name() {
		return photo_name;
	}

	public void setPhoto_name(String photo_name) {
		this.photo_name = photo_name;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
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
		return "DriverInfo [id=" + id + ", pic_code=" + pic_code + ", name=" + name + ", id_card_number="
				+ id_card_number + ", phone_number=" + phone_number + ", photo_name=" + photo_name + ", src=" + src
				+ ", create_time=" + create_time + ", update_time=" + update_time + "]";
	}

}
