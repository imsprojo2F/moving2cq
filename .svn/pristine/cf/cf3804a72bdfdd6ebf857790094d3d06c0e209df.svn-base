/**   
* @Title: QueryParameter.java 
* @Package com.movingcq.entity 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Imsprojo2FAN
* @date 2017年5月9日 下午1:42:08 
* @version V1.0   
*/
package com.movingcq.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: QueryParameter
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Imsprojo2FAN
 * @date 2017年5月9日 下午1:42:08
 * 
 */
public class QueryParameter {

	private Integer draw;

	private Integer start;

	private Integer length;

	private Map<Search, String> search = new HashMap<Search, String>();

	private List<Map<String, String>> order = new ArrayList<Map<String, String>>();

	private List<Map<String, String>> columns = new ArrayList<Map<String, String>>();

	public QueryParameter() {

	}

	public enum Search {
		value, regex
	}

	public enum Order {
		column, dir
	}

	public enum Column {
		data, name, searchable, orderable, searchValue, searchRegex
	}

	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Map<Search, String> getSearch() {
		return search;
	}

	public void setSearch(Map<Search, String> search) {
		this.search = search;
	}

	public List<Map<String, String>> getOrder() {
		return order;
	}

	public void setOrder(List<Map<String, String>> order) {
		this.order = order;
	}

	public List<Map<String, String>> getColumns() {
		return columns;
	}

	public void setColumns(List<Map<String, String>> columns) {
		this.columns = columns;
	}

	@Override
	public String toString() {
		return "QueryParameter [draw=" + draw + ", start=" + start + ", length=" + length + ", search=" + search
				+ ", order=" + order + ", columns=" + columns + "]";
	}

}
