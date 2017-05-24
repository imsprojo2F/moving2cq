/**   
* @Title: RestaurantToRfid.java 
* @Package com.movingcq.entity 
* @Description: TODO(用一句话描述该文件做什么) 
* @author IsProjo
* @date 2016年12月7日 上午10:28:25 
* @version V1.0   
*/
package com.movingcq.entity;

import java.util.Date;

/**
 * @ClassName: RestaurantToRfid
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author IsProjo
 * @date 2016年12月7日 上午10:28:25
 * 
 */
public class RestaurantToRfid {

	public int id;
	public int restaurant_id;
	public int rfid_id;
	public Date card_bingding_date;
	public Date create_time;
	public Date update_time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRestaurant_id() {
		return restaurant_id;
	}

	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}

	public int getRfid_id() {
		return rfid_id;
	}

	public void setRfid_id(int rfid_id) {
		this.rfid_id = rfid_id;
	}

	public Date getCard_bingding_date() {
		return card_bingding_date;
	}

	public void setCard_bingding_date(Date card_bingding_date) {
		this.card_bingding_date = card_bingding_date;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	@Override
	public String toString() {
		return "RestaurantToRfid [id=" + id + ", restaurant_id=" + restaurant_id + ", rfid_id=" + rfid_id
				+ ", card_bingding_date=" + card_bingding_date + ", create_time=" + create_time + ", update_time="
				+ update_time + "]";
	}

}
