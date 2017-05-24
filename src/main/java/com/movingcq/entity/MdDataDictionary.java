/**   
* @Title: MdDataDictionary.java 
* @Package com.movingcq.entity 
* @Description: TODO(用一句话描述该文件做什么) 
* @author IsProjo
* @date 2016年12月7日 上午10:26:11 
* @version V1.0   
*/
package com.movingcq.entity;

import java.util.Date;

/**
 * @ClassName: MdDataDictionary
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author IsProjo
 * @date 2016年12月7日 上午10:26:11
 * 
 */
public class MdDataDictionary {

	public int id;
	public String type;
	public String name;
	public Date create_time;
	public Date update_time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "MdDataDictionary [id=" + id + ", type=" + type + ", name=" + name + ", create_time=" + create_time
				+ ", update_time=" + update_time + "]";
	}

}
