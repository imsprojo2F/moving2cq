/**   
* @Title: QuartzJob2.java 
* @Package com.movingcq.quartz 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Imsprojo2FAN
* @date 2017年4月21日 下午1:38:16 
* @version V1.0   
*/
package com.movingcq.quartz;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.movingcq.entity.CarWeigh;
import com.movingcq.entity.GpsPointInfo;
import com.movingcq.service.ICarWeighService;
import com.movingcq.service.IGpsPointInfoService;
import com.movingcq.util.GPSTransform;
import com.movingcq.util.HttpClientUtil;

/**
 * @ClassName: QuartzJob2
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Imsprojo2FAN
 * @date 2017年4月21日 下午1:38:16
 * 
 */
public class QuartzJob2 {

	@Autowired
	private IGpsPointInfoService gpsPointInfoService;
	@Autowired
	private ICarWeighService carweighService;

	static String geturl2;
	static String query2;
	static long startTime;
	static long endTime;
	static int j2 = -1;

	static GpsPointInfo gpsPointInfo = new GpsPointInfo();

	static CarWeigh carWeigh = new CarWeigh();

	public void execute() {

		System.out.println("------1分钟轮循任务开始执行------");
		getGPS(0, gpsPointInfoService);
		getCarRt(0, carweighService);
	}

	public static void getGPS(int type, IGpsPointInfoService gpsPointInfoService) {

		Date date = new Date();
		//startTime = date.getTime() - 60000; // 1分钟前毫秒数
		
		// 接口是 [startTime,endTime] 为了避免返回重复的数据，[startTime+1秒 ,endTime]
		startTime = date.getTime() - 59000; // 1分钟前毫秒数
		endTime = date.getTime();
		geturl2 = "http://222.185.140.242:9190/vortexrest/api/czcc/data/gpsDataInsert";
		if (type == 0) {
			query2 = "parameters={\"endTime\":" + endTime + ",\"startTime\":" + startTime + ",\"pageSize\":" + j2
					+ ",\"pageNo\":1}";
		} else {// 数据库初始化
			j2 = -1;
			query2 = "parameters={\"pageSize\":" + j2 + ",\"pageNo\":1}";
		}
		JSONObject gpsJson = JSONObject.parseObject(HttpClientUtil.loadData(geturl2, "POST", query2));
		if (gpsJson != null && gpsJson.get("succ").toString().equals("true")) {
			// 数据库操作
			JSONObject rowsJson = JSONObject.parseObject(gpsJson.get("data").toString());
			JSONArray json = JSONArray.parseArray(rowsJson.get("rows").toString()); // 字符串转成JSONArray对象
			if (json.size() > 0) {
				for (int i = 0; i < json.size(); i++) {

					JSONObject gps = json.getJSONObject(i);
					gpsPointInfo.setId(gps.get("id").toString());
					gpsPointInfo.setCreatetime(gps.getDate("createTime"));
					gpsPointInfo.setDevcode(gps.getString("devCode"));
					gpsPointInfo.setGpsvalid(gps.getInteger("gpsValid"));
					gpsPointInfo.setEquipmenttime(gps.getDate("equipmentTime"));

					gpsPointInfo.setGpsaltitude(gps.getDouble("gpsAltitude"));
					gpsPointInfo.setGpsspeed(gps.getDouble("gpsSpeed"));
					gpsPointInfo.setStateignition(gps.getInteger("stateIgnition"));
					gpsPointInfo.setDone(gps.getInteger("done"));

					gpsPointInfo.setAddress(gps.getString("address"));

					double[] gpsT = GPSTransform.gcj02_To_Bd09(gps.getDouble("gpsLatitude"),
							gps.getDouble("gpsLongitude"));
					gpsPointInfo.setGpslatitude(gpsT[0]);
					gpsPointInfo.setGpslongitude(gpsT[1]);

					double[] gpsTD = GPSTransform.gcj02_To_Bd09(gps.getDouble("latitudeDone"),
							gps.getDouble("longitudeDone"));
					gpsPointInfo.setLongitudedone(gpsTD[1]);
					gpsPointInfo.setLatitudedone(gpsTD[0]);

					gpsPointInfoService.insert(gpsPointInfo);

				}

			}

		}

	}

	public static void getCarRt(int type, ICarWeighService carweighService) {

		Date date = new Date();
		// startTime = date.getTime() - 60000; // 1分钟前毫秒数
		// 接口是 [startTime,endTime] 为了避免返回重复的数据，[startTime+1秒 ,endTime]，车载称重会有10分钟的延迟
		startTime = date.getTime() - 59000 - (10 * 60 * 1000); // 1分钟前毫秒数
		endTime = date.getTime() - (10 * 60 * 1000);
		geturl2 = "http://222.185.140.242:9190/vortexrest/api/czcc/data/carRtDataInsert";
		if (type == 0) {
			query2 = "parameters={\"endTime\":" + endTime + ",\"startTime\":" + startTime + ",\"pageSize\":" + j2
					+ ",\"pageNo\":1}";
		} else {// 数据库初始化
			j2 = -1;
			query2 = "parameters={\"pageSize\":" + j2 + ",\"pageNo\":1}";
		}
		JSONObject carRtJson = JSONObject.parseObject(HttpClientUtil.loadData(geturl2, "POST", query2));
		System.out.println(geturl2+"?"+query2);
		if (carRtJson != null && carRtJson.get("succ").toString().equals("true")) {
			// 数据库操作
			JSONObject rowsJson = JSONObject.parseObject(carRtJson.get("data").toString());
			JSONArray json = JSONArray.parseArray(rowsJson.get("rows").toString()); // 字符串转成JSONArray对象
			if (json.size() > 0) {
				for (int i = 0; i < json.size(); i++) {

					JSONObject carRt = json.getJSONObject(i);
					carWeigh.setId(carRt.get("id").toString());
					carWeigh.setCreatetime(carRt.getDate("createTime"));
					carWeigh.setLastchangetime(carRt.getDate("lastChangeTime"));
					carWeigh.setStatus(carRt.getInteger("status"));
					carWeigh.setBeendeleted(carRt.getInteger("beenDeleted"));
					carWeigh.setDeletedtime(carRt.getDate("deletedTime"));
					carWeigh.setCarcode(carRt.getString("carCode"));
					carWeigh.setCarid(carRt.getString("carId"));
					carWeigh.setCarphotocapturetime(carRt.getDate("carPhotoCaptureTime"));
					carWeigh.setCarphotorealtimeid(carRt.getString("carPhotoRealTimeId"));
					carWeigh.setCarweighid(carRt.getString("carWeighId"));
					carWeigh.setMatchstatus(carRt.getString("matchStatus"));
					carWeigh.setNetweigh(carRt.getFloat("netWeigh"));
					carWeigh.setRecordstatus(carRt.getString("recordStatus"));
					carWeigh.setRemark(carRt.getString("remark"));
					carWeigh.setRestaurantid(carRt.getString("restaurantId"));
					carWeigh.setRestaurantname(carRt.getString("restaurantName"));
					carWeigh.setRfidcode(carRt.getString("rfidCode"));
					carWeigh.setRfidcreatetime(carRt.getDate("rfidCreateTime"));
					carWeigh.setRfidrecordrealtimeid(carRt.getString("rfidRecordRealTimeId"));
					carWeigh.setWeightime(carRt.getDate("weighTime"));
					carWeigh.setGpscarpositionid(carRt.getString("gpsCarPositionId"));
					carWeigh.setGpslatitude(carRt.getDouble("gpsLatitude"));
					carWeigh.setGpslongitude(carRt.getDouble("gpsLongitude"));
					carWeigh.setLatitudedone(carRt.getDouble("latitudeDone"));
					carWeigh.setLongitudedone(carRt.getDouble("longitudeDone"));
					carWeigh.setDevcode(carRt.getString("devCode"));
					carWeigh.setGrossweight(carRt.getDouble("grossWeight"));
					carWeigh.setTareweight(carRt.getDouble("tareWeight"));
					carWeigh.setCarmileage(carRt.getDouble("carMileage"));
					carweighService.insert(carWeigh);

				}

			}

		}
	}

}
