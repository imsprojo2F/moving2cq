/**   
* @Title: RestaurantBucketInfo.java 
* @Package com.movingcq.entity 
* @Description: TODO(用一句话描述该文件做什么) 
* @author IsProjo
* @date 2016年12月14日 下午4:35:37 
* @version V1.0   
*/
package com.movingcq.entity;

/**
 * @ClassName: RestaurantBucketInfo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author IsProjo
 * @date 2016年12月14日 下午4:35:37
 * 
 */
public class RestaurantBucketInfo {

	public Integer id;
	public Integer restaurant_id;
	public Integer bucket_id;
	public String binding_date;
	public String create_time;
	public String update_time;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRestaurant_id() {
		return restaurant_id;
	}

	public void setRestaurant_id(Integer restaurant_id) {
		this.restaurant_id = restaurant_id;
	}

	public Integer getBucket_id() {
		return bucket_id;
	}

	public void setBucket_id(Integer bucket_id) {
		this.bucket_id = bucket_id;
	}

	public String getBinding_date() {
		return binding_date;
	}

	public void setBinding_date(String binding_date) {
		this.binding_date = binding_date;
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
		return "RestaurantBucketInfo [id=" + id + ", restaurant_id=" + restaurant_id + ", bucket_id=" + bucket_id
				+ ", bingding_date=" + binding_date + ", create_time=" + create_time + ", update_time=" + update_time
				+ "]";
	}

}
