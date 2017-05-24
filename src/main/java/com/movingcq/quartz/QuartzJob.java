/**   
* @Title: QuartzJob.java 
* @Package com.movingcq.quartz 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Imsprojo2FAN
* @date 2017年4月11日 下午1:33:01 
* @version V1.0   
*/
package com.movingcq.quartz;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.movingcq.entity.CarDevice;
import com.movingcq.entity.CarInfo;
import com.movingcq.entity.LoadoMasterRecord;
import com.movingcq.entity.ParameterRecord;
import com.movingcq.entity.RestaurantInfo;
import com.movingcq.entity.RfidInfo;
import com.movingcq.service.ICarDeviceService;
import com.movingcq.service.ICarInfoService;
import com.movingcq.service.ILoadoMeterRecordService;
import com.movingcq.service.IParameterRecordService;
import com.movingcq.service.IRestInfoService;
import com.movingcq.service.IRfidInfoService;
import com.movingcq.util.DateUtil;
import com.movingcq.util.GPSTransform;
import com.movingcq.util.HttpClientUtil;

/**
 * @ClassName: QuartzJob
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Imsprojo2FAN
 * @date 2017年4月11日 下午1:33:01
 * 
 */
public class QuartzJob {

	@Autowired
	private IRfidInfoService rfidService;

	@Autowired
	private IRestInfoService restInfoService;

	@Autowired
	private IParameterRecordService parameterRecordService;

	@Autowired
	private ICarInfoService carInfoService;

	@Autowired
	private ICarDeviceService carDeviceService;

	@Autowired
	private ILoadoMeterRecordService loadoMeterRecordService;

	static String geturl;
	static String query;
	static long timeStamp;
	static int j = -1;
	static int result = 0;

	static RfidInfo rInfo = new RfidInfo();
	static ParameterRecord pRecord = new ParameterRecord();
	static RestaurantInfo restInfo = new RestaurantInfo();
	static CarInfo carInfo = new CarInfo();
	static CarDevice carDevice = new CarDevice();
	static LoadoMasterRecord lRecord = new LoadoMasterRecord();

	public void execute() {

		System.out.println("------5分钟轮循任务开始执行------");

		// 获取RFID信息------------
		getRFID(0, rfidService);

		// 获取餐饮企业信息------------
		getRestInfo(0, restInfoService);

		// 获取参数信息------------
		getParameter(0, parameterRecordService);

		// 获取车辆信息------------
		getCarInfo(0, carInfoService);

		// 获取车载设备信息------------
		getDeviceInfo(0, carDeviceService);

		// 获取地磅称重信息------------
		getloadoInfo(0, loadoMeterRecordService);

	}

	public static boolean getRFID(int type, IRfidInfoService rfidService) {

		Date date = new Date();
		timeStamp = date.getTime() - 300000; // 5分钟前毫秒数

		int count = 0;
		boolean flag = false;
		geturl = "http://222.185.140.242:9190/vortexrest/api/czcc/data/rfidDataInsert";
		if (type == 0) {
			query = "parameters={\"time\":" + timeStamp + ",\"pageSize\":" + j + ",\"pageNo\":1}";
		} else {// 数据库初始化
			j = -1;
			query = "parameters={\"pageSize\":" + j + ",\"pageNo\":1}";
		}
		DateUtil.Mill2Time(timeStamp);
		System.err.println("getRFID: " + geturl + "?" + query);
		JSONObject rfidJson = JSONObject.parseObject(HttpClientUtil.loadData(geturl, "POST", query));
		if (rfidJson != null && rfidJson.get("succ").toString().equals("true")) {

			// 数据库操作
			JSONObject rowsJson = JSONObject.parseObject(rfidJson.get("data").toString());
			int total = rowsJson.getIntValue("total");
			JSONArray json = JSONArray.parseArray(rowsJson.get("rows").toString()); // 字符串转成JSONArray对象
			if (json.size() > 0) {
				for (int i = 0; i < json.size(); i++) {
					JSONObject rfid = json.getJSONObject(i);
					rInfo.setId(rfid.get("id").toString());
					rInfo.setCreatetime(rfid.getDate("createTime"));
					rInfo.setLastchangetime(rfid.getDate("lastChangeTime"));
					rInfo.setStatus(rfid.getIntValue("status"));
					rInfo.setBeendeleted(rfid.getIntValue("beenDeleted"));
					long delTime = rfid.getLongValue("deletedTime");
					if (delTime < 1) {
						rInfo.setDeletedtime(null);
					} else {
						rInfo.setDeletedtime(new Date(delTime));
					}

					rInfo.setCardbindingdate(rfid.get("cardBindingDate").toString());
					rInfo.setOrderindex(rfid.getInteger("orderIndex"));
					rInfo.setRemarks(rfid.getString("remarks"));
					rInfo.setRfidcode(rfid.getString("rfidCode"));
					rInfo.setRfidstatus(rfid.getString("rfidStatus"));
					rInfo.setTrashbinmodel(rfid.getString("trashbinModel"));
					rInfo.setTrashweight(rfid.getString("trashbinWeight"));
					rInfo.setRestaurantId(rfid.getString("restaurantId"));
					rInfo.setBeenmark(rfid.getInteger("beenMark"));
					int num = rfidService.selectById(rfid.get("id").toString());
					if (num > 0) {
						rfidService.updateById(rInfo);
					} else {
						result = rfidService.insert(rInfo);
					}

					if (result > 0) {
						count++;
						if (count == total) {
							flag = true;
						}
					}
				}

			}

		}
		return flag;
	}

	public static boolean getRestInfo(int type, IRestInfoService restInfoService) {

		Date date = new Date();
		timeStamp = date.getTime() - 300000; // 5分钟前毫秒数

		int count = 0;
		boolean flag = false;
		geturl = "http://222.185.140.242:9190/vortexrest/api/czcc/data/restDataInsert";
		if (type == 0) {
			query = "parameters={\"time\":" + timeStamp + ",\"pageSize\":" + j + ",\"pageNo\":1}";
		} else {// 数据库初始化
			j = -1;
			query = "parameters={\"pageSize\":" + j + ",\"pageNo\":1}";
		}
		DateUtil.Mill2Time(timeStamp);
		System.err.println("getRestInfo: " + geturl + "?" + query);
		JSONObject restJson = JSONObject.parseObject(HttpClientUtil.loadData(geturl, "POST", query));
		if (restJson != null && restJson.get("succ").toString().equals("true")) {

			// 数据库操作
			JSONObject rowsJson = JSONObject.parseObject(restJson.get("data").toString());
			int total = rowsJson.getIntValue("total");
			JSONArray json = JSONArray.parseArray(rowsJson.get("rows").toString()); // 首先把字符串转成JSONArray对象
			if (json.size() > 0) {
				for (int i = 0; i < json.size(); i++) {
					JSONObject restObject = json.getJSONObject(i);

					String l = restObject.getString("createTime");
					if ("".equals(l) || l == "0") {
						restInfo.setCreatetime(null);
					} else {
						restInfo.setCreatetime(new Date(restObject.getLongValue("createTime")));
					}

					long l1 = restObject.getLongValue("lastChangeTime");
					if (l1 < 1) {
						restInfo.setLastchangetime(null);
					} else {
						restInfo.setLastchangetime(new Date(l1));
					}

					long l2 = restObject.getLongValue("deletedTime");
					if (l2 < 1) {
						restInfo.setDeletedtime(null);
					} else {
						restInfo.setDeletedtime(new Date(l2));
					}

					long l3 = restObject.getLongValue("closeDate");
					if (l3 < 1) {
						restInfo.setClosedate(null);
					} else {
						restInfo.setClosedate(new Date(l3));
					}

					long l4 = restObject.getLongValue("endCollectTime");
					if (l4 < 1) {
						restInfo.setEndcollecttime(null);
					} else {
						restInfo.setEndcollecttime(new Date(l4));
					}

					long l5 = restObject.getLongValue("hygienicLicenseDate");
					if (l5 < 1) {
						restInfo.setHygieniclicensedate(null);
					} else {
						restInfo.setHygieniclicensedate(new Date(l5));
					}

					long l6 = restObject.getLongValue("lastCollectDateTime");
					if (l6 < 1) {
						restInfo.setLastcollectdatetime(null);
					} else {
						restInfo.setLastcollectdatetime(new Date(l6));
					}

					long l7 = restObject.getLongValue("openDate");
					if (l7 < 1) {
						restInfo.setOpendate(null);
					} else {
						restInfo.setOpendate(new Date(l7));
					}

					long l8 = restObject.getLongValue("signingDate");
					if (l8 < 1) {
						restInfo.setSigningdate(null);
					} else {
						restInfo.setSigningdate(new Date(l8));
					}

					String l9 = restObject.getString("startCollectTime");
					if ("".equals(l9)) {
						restInfo.setStartcollecttime(null);
					} else {
						restInfo.setStartcollecttime(new Date(restObject.getLongValue("startCollectTime")));
					}

					long l10 = restObject.getLongValue("logoutTime");
					if (l10 < 1) {
						restInfo.setLogouttime(null);
					} else {
						restInfo.setLogouttime(new Date(l10));
					}

					long l11 = restObject.getLongValue("sourceTime");
					if (l11 < 1) {
						restInfo.setSourcetime(null);
					} else {
						restInfo.setSourcetime(new Date(l11));
					}

					long l12 = restObject.getLongValue("endCollectTime2");
					if (l12 < 1) {
						restInfo.setEndcollecttime2(null);
					} else {
						restInfo.setEndcollecttime2(new Date(l12));
					}

					long l13 = restObject.getLongValue("mealTime");
					if (l13 < 1) {
						restInfo.setMealtime(null);
					} else {
						restInfo.setMealtime(new Date(l13));
					}

					long l14 = restObject.getLongValue("startCollectTime2");
					if (l14 < 1) {
						restInfo.setStartcollecttime2(null);
					} else {
						restInfo.setStartcollecttime2(new Date(l14));
					}

					long l15 = restObject.getLongValue("signingendDate");
					if (l15 < 1) {
						restInfo.setSigningenddate(null);
					} else {
						restInfo.setSigningenddate(new Date(l15));
					}

					long l16 = restObject.getLongValue("syEndDate");
					if (l16 < 1) {
						restInfo.setSyenddate(null);
					} else {
						restInfo.setSyenddate(new Date(l16));
					}

					long l17 = restObject.getLongValue("syStartDate");
					if (l17 < 1) {
						restInfo.setSystartdate(null);
					} else {
						restInfo.setSystartdate(new Date(l17));
					}

					restInfo.setId(restObject.getString("id"));
					restInfo.setStatus(restObject.getInteger("status"));
					restInfo.setBeendeleted(restObject.getInteger("beenDeleted"));
					restInfo.setAddress(restObject.getString("address"));
					restInfo.setBusinessarea(restObject.getFloat("businessArea"));
					restInfo.setCode(restObject.getString("code"));
					restInfo.setCollectfrequency(restObject.getFloat("collectFrequency"));
					restInfo.setComplaintshotline(restObject.getString("complaintsHotline"));
					restInfo.setContactperson(restObject.getString("contactPerson"));
					restInfo.setContactphone(restObject.getString("contactPhone"));
					restInfo.setContractlength(restObject.getFloat("contractLength"));
					restInfo.setContractno(restObject.getString("contractNo"));
					restInfo.setDailyoutput(restObject.getFloat("dailyOutput"));
					restInfo.setDailyoutputwasteoil(restObject.getFloat("dailyOutputWasteOil"));
					restInfo.setDocumentno(restObject.getString("documentNo"));
					restInfo.setIscollectscdoil(restObject.getInteger("isCollectScdOil"));

					double[] gpsT = GPSTransform.gcj02_To_Bd09(restObject.getDouble("latitude"),
							restObject.getDouble("longitude"));
					restInfo.setLatitude(gpsT[0]);
					restInfo.setLongitude(gpsT[1]);

					double[] gpsTD = GPSTransform.gcj02_To_Bd09(restObject.getDouble("latitudeDone"),
							restObject.getDouble("longitudeDone"));
					restInfo.setLatitudedone(gpsTD[0]);
					restInfo.setLongitudedone(gpsTD[1]);
					restInfo.setLegalrepresentative(restObject.getString("legalRepresentative"));
					restInfo.setMealrange(restObject.getString("mealRange"));
					restInfo.setName(restObject.getString("name"));
					restInfo.setOrderindex(restObject.getInteger("orderIndex"));
					restInfo.setPermit(restObject.getInteger("permit"));
					restInfo.setPermitno(restObject.getString("permitNo"));
					restInfo.setPhonenumber(restObject.getString("phoneNumber"));
					restInfo.setPhotofile(restObject.getString("photoFile"));
					restInfo.setPhotoids(restObject.getString("photoIds"));
					restInfo.setRemain(restObject.getFloat("remain"));
					restInfo.setRemarks(restObject.getString("remarks"));
					restInfo.setScale(restObject.getString("scale"));
					restInfo.setStarlevel(restObject.getString("starLevel"));
					restInfo.setSycompanyfile(restObject.getString("syCompanyFile"));
					restInfo.setSycompanyid(restObject.getString("syCompanyId"));
					restInfo.setTrashbinnum(restObject.getInteger("trashbinNum"));
					restInfo.setType(restObject.getString("type"));
					restInfo.setWasteoil(restObject.getFloat("wasteOil"));
					restInfo.setClassesid(restObject.getString("classesId"));
					restInfo.setDocumenttypeid(restObject.getString("documentTypeId"));
					restInfo.setStreetid(restObject.getString("streetId"));
					restInfo.setLogout(restObject.getInteger("logout"));
					restInfo.setSourcetype(restObject.getInteger("sourceType"));
					restInfo.setContacttel(restObject.getString("contactTel"));
					restInfo.setLegalmanfileids(restObject.getString("legalManFileIds"));
					restInfo.setLegalmanphone(restObject.getString("legalManPhone"));
					restInfo.setLegalmantel(restObject.getString("legalManTel"));
					restInfo.setSourcemanid(restObject.getString("sourceManId"));
					restInfo.setFiles(restObject.getString("files"));
					restInfo.setRestaurantaddress(restObject.getString("restaurantAddress"));
					restInfo.setUnitaddress(restObject.getString("unitAdress"));
					restInfo.setUnitname(restObject.getString("unitName"));
					restInfo.setLastcollectcarcode(restObject.getString("lastCollectCarCode"));
					restInfo.setLastcollectcarid(restObject.getString("lastCollectCarId"));
					restInfo.setMealrangedisplayvalue(restObject.getString("mealRangeDisplayValue"));
					restInfo.setMealrangeid(restObject.getString("mealRangeId"));
					restInfo.setPinyin(restObject.getString("pinyin"));
					restInfo.setContactmobile(restObject.getString("contactMobile"));
					restInfo.setSignedstatus(restObject.getInteger("signedStatus"));
					restInfo.setElevator(restObject.getInteger("elevator"));
					restInfo.setStair(restObject.getInteger("stair"));
					restInfo.setFloornum(restObject.getInteger("floorNum"));
					restInfo.setSycompanyname(restObject.getString("syCompanyName"));
					restInfo.setApplytrashbinnum(restObject.getInteger("applyTrashBinNum"));
					restInfo.setDatasource(restObject.getInteger("dataSource"));
					restInfo.setPaperfileids(restObject.getString("paperFileIds"));
					restInfo.setPaperfilenames(restObject.getString("paperFileNames"));
					restInfo.setCreditassessrecord(restObject.getString("creditAssessRecord"));
					restInfo.setAreaId(restObject.getString("areaId"));
					restInfo.setAreaName(restObject.getString("areaName"));
					int num = restInfoService.selectById(restObject.getString("id"));
					if (num > 0) {
						restInfoService.updateById(restInfo);
					} else {
						result = restInfoService.insert(restInfo);
					}
					if (result > 0) {
						count++;
						if (count == total) {
							flag = true;
						}
					}
				}
			}

		}
		return flag;
	}

	public static boolean getParameter(int type, IParameterRecordService parameterRecordService) {

		Date date = new Date();
		timeStamp = date.getTime() - 300000; // 5分钟前毫秒数

		int count = 0;
		boolean flag = false;
		geturl = "http://222.185.140.242:9190/vortexrest/api/czcc/data/commonDataInsert";
		if (type == 0) {
			query = "parameters={\"time\":" + timeStamp + ",\"pageSize\":" + j + ",\"pageNo\":1}";
		} else {// 数据库初始化
			j = -1;
			query = "parameters={\"pageSize\":" + j + ",\"pageNo\":1}";
		}
		DateUtil.Mill2Time(timeStamp);
		System.err.println("getParameter: " + geturl + "?" + query);
		JSONObject parameterJson = JSONObject.parseObject(HttpClientUtil.loadData(geturl, "POST", query));
		if (parameterJson != null && parameterJson.get("succ").toString().equals("true")) {

			// 数据库操作
			JSONObject rowsJson = JSONObject.parseObject(parameterJson.get("data").toString());
			int total = rowsJson.getIntValue("total");
			JSONArray json = JSONArray.parseArray(rowsJson.get("rows").toString()); // 字符串转成JSONArray对象
			if (json.size() > 0) {
				for (int i = 0; i < json.size(); i++) {
					JSONObject pObject = json.getJSONObject(i);
					pRecord.setId(pObject.getString("id"));
					pRecord.setCreatetime(pObject.getDate("createTime"));
					pRecord.setLastchangetime(pObject.getDate("lastChangeTime"));
					pRecord.setStatus(pObject.getInteger("status"));
					pRecord.setBeendeleted(pObject.getInteger("beenDeleted"));
					pRecord.setDeletedtime(pObject.getDate("deletedTime"));
					pRecord.setDescription(pObject.getString("description"));
					pRecord.setDisplayvalue(pObject.getString("displayValue"));
					pRecord.setOrderindex(pObject.getInteger("orderIndex"));
					pRecord.setParametervaluetype(pObject.getString("parameterValueType"));
					pRecord.setValue(pObject.getString("value"));
					ParameterRecord pRecord2 = parameterRecordService.selectByPrimaryKey(pObject.getString("id"));
					if (pRecord2 != null) {
						parameterRecordService.updateByPrimaryKeySelective(pRecord);
					} else {
						result = parameterRecordService.insert(pRecord);
					}

					if (result > 0) {
						count++;
						if (count == total) {
							flag = true;
						}
					}
				}

			}

		}
		return flag;
	}

	public static boolean getCarInfo(int type, ICarInfoService carInfoService) {

		Date date = new Date();
		timeStamp = date.getTime() - 300000; // 5分钟前毫秒数

		int count = 0;
		boolean flag = false;
		geturl = "http://222.185.140.242:9190/vortexrest/api/czcc/data/carDataInsert";
		if (type == 0) {
			query = "parameters={\"time\":" + timeStamp + ",\"pageSize\":" + j + ",\"pageNo\":1}";
		} else {// 数据库初始化
			j = -1;
			query = "parameters={\"pageSize\":" + j + ",\"pageNo\":1}";
		}
		DateUtil.Mill2Time(timeStamp);
		System.err.println("getCarInfo: " + geturl + "?" + query);
		JSONObject carJson = JSONObject.parseObject(HttpClientUtil.loadData(geturl, "POST", query));
		if (carJson != null && carJson.get("succ").toString().equals("true")) {

			// 数据库操作
			JSONObject rowsJson = JSONObject.parseObject(carJson.get("data").toString());
			int total = rowsJson.getIntValue("total");
			JSONArray json = JSONArray.parseArray(rowsJson.get("rows").toString()); // 字符串转成JSONArray对象
			if (json.size() > 0) {
				for (int i = 0; i < json.size(); i++) {
					JSONObject carObject = json.getJSONObject(i);
					carInfo.setId(carObject.getString("id"));
					carInfo.setCreatetime(carObject.getDate("createTime"));
					carInfo.setLastchangetime(carObject.getDate("lastChangeTime"));
					carInfo.setStatus(carObject.getInteger("status"));
					carInfo.setBeendeleted(carObject.getInteger("beenDeleted"));
					carInfo.setDeletedtime(carObject.getDate("deletedTime"));
					carInfo.setCarcode(carObject.getString("carCode"));
					carInfo.setCarload(carObject.getString("carLoad"));
					carInfo.setDriverphone(carObject.getString("driverPhone"));
					carInfo.setDriver(carObject.getString("driver"));
					CarInfo cInfo = carInfoService.selectByPrimaryKey(carObject.getString("id"));
					if (cInfo != null) {
						carInfoService.updateByPrimaryKeySelective(carInfo);
					} else {
						result = carInfoService.insert(carInfo);
					}
					if (result > 0) {
						count++;
						if (count == total) {
							flag = true;
						}
					}
				}

			}

		}
		return flag;
	}

	public static boolean getDeviceInfo(int type, ICarDeviceService carDeviceService) {

		Date date = new Date();
		timeStamp = date.getTime() - 300000; // 5分钟前毫秒数

		int count = 0;
		boolean flag = false;
		geturl = "http://222.185.140.242:9190/vortexrest/api/czcc/data/deviceDataInsert";
		if (type == 0) {
			query = "parameters={\"time\":" + timeStamp + ",\"pageSize\":" + j + ",\"pageNo\":1}";
		} else {// 数据库初始化
			j = -1;
			query = "parameters={\"pageSize\":" + j + ",\"pageNo\":1}";
		}
		DateUtil.Mill2Time(timeStamp);
		System.err.println("getDeviceInfo: " + geturl + "?" + query);
		JSONObject deviceJson = JSONObject.parseObject(HttpClientUtil.loadData(geturl, "POST", query));
		if (deviceJson != null && deviceJson.get("succ").toString().equals("true")) {

			// 数据库操作
			JSONObject rowsJson = JSONObject.parseObject(deviceJson.get("data").toString());
			int total = rowsJson.getIntValue("total");
			JSONArray json = JSONArray.parseArray(rowsJson.get("rows").toString()); // 字符串转成JSONArray对象
			if (json.size() > 0) {
				for (int i = 0; i < json.size(); i++) {
					JSONObject deviceObject = json.getJSONObject(i);
					carDevice.setId(deviceObject.getString("id"));
					carDevice.setCreatetime(deviceObject.getDate("createTime"));
					carDevice.setLastchangetime(deviceObject.getDate("lastChangeTime"));
					carDevice.setBeendeleted(deviceObject.getInteger("beenDeleted"));
					carDevice.setStatus(deviceObject.getInteger("status"));
					carDevice.setDeletedtime(deviceObject.getDate("deletedTime"));
					carDevice.setDevicecode(deviceObject.getString("deviceCode"));
					carDevice.setDevicephoneno(deviceObject.getString("devicePhoneNo"));
					carDevice.setCarid(deviceObject.getString("carId"));
					carDevice.setGpsdevicetype(deviceObject.getString("gpsDeviceType"));
					carDevice.setLastcarid(deviceObject.getString("lastCarId"));
					CarDevice cDevice = carDeviceService.selectByPrimaryKey(deviceObject.getString("id"));
					if (cDevice != null) {
						carDeviceService.updateByPrimaryKeySelective(carDevice);
					} else {
						result = carDeviceService.insert(carDevice);
					}

					if (result > 0) {
						count++;
						if (count == total) {
							flag = true;
						}
					}
				}

			}

		}
		return flag;
	}

	public static boolean getloadoInfo(int type, ILoadoMeterRecordService loadoMeterRecordService) {

		Date date = new Date();
		timeStamp = date.getTime() - 300000; // 5分钟前毫秒数

		int count = 0;
		boolean flag = false;
		geturl = "http://222.185.140.242:9190/vortexrest/api/czcc/data/weighDataInsert";
		if (type == 0) {
			query = "parameters={\"time\":" + timeStamp + ",\"pageSize\":" + j + ",\"pageNo\":1}";
		} else {// 数据库初始化
			j = -1;
			query = "parameters={\"pageSize\":" + j + ",\"pageNo\":1}";
		}
		DateUtil.Mill2Time(timeStamp);
		System.err.println("getloadoInfo: " + geturl + "?" + query);
		JSONObject weighJson = JSONObject.parseObject(HttpClientUtil.loadData(geturl, "POST", query));
		if (weighJson != null && weighJson.get("succ").toString().equals("true")) {
			// 数据库操作
			JSONObject rowsJson = JSONObject.parseObject(weighJson.get("data").toString());
			int total = rowsJson.getIntValue("total");
			JSONArray json = JSONArray.parseArray(rowsJson.get("rows").toString()); // 字符串转成JSONArray对象
			if (json.size() > 0) {
				for (int i = 0; i < json.size(); i++) {
					JSONObject weighObject = json.getJSONObject(i);
					lRecord.setId(weighObject.getString("id"));
					lRecord.setCreatetime(weighObject.getDate("createTime"));
					lRecord.setLastchangetime(weighObject.getDate("lastChangeTime"));
					lRecord.setBeendeleted(weighObject.getInteger("beenDeleted"));
					lRecord.setStatus(weighObject.getInteger("status"));
					lRecord.setDeletedtime(weighObject.getDate("deletedTime"));
					lRecord.setArea(weighObject.getString("area"));
					lRecord.setCarno(weighObject.getString("carNo"));
					lRecord.setCode(weighObject.getString("code"));
					lRecord.setDataoperatetype(weighObject.getString("dataOperateType"));
					lRecord.setDisposeunitcode(weighObject.getString("disposeUnitCode"));
					lRecord.setDriver(weighObject.getString("driver"));
					lRecord.setGrossdatetime(weighObject.getDate("grossDateTime"));
					lRecord.setGrossweight(weighObject.getFloat("grossWeight"));
					lRecord.setHandleunit(weighObject.getString("handleUnit"));
					lRecord.setIccode(weighObject.getString("icCode"));
					lRecord.setMemo(weighObject.getString("memo"));
					lRecord.setNetweight(weighObject.getFloat("netWeight"));
					lRecord.setNo(weighObject.getString("no"));
					lRecord.setProductname(weighObject.getString("productName"));
					lRecord.setProducttowhere(weighObject.getString("productToWhere"));
					lRecord.setProducttype(weighObject.getString("productType"));
					lRecord.setSourceunit(weighObject.getString("sourceUnit"));
					lRecord.setTaredatetime(weighObject.getDate("tareDateTime"));
					lRecord.setTareweight(weighObject.getFloat("tareWeight"));
					lRecord.setTransportunit(weighObject.getString("transportUnit"));
					lRecord.setUrl1(weighObject.getString("url1"));
					lRecord.setUrl2(weighObject.getString("url2"));
					lRecord.setUrl3(weighObject.getString("url3"));
					lRecord.setUrl4(weighObject.getString("url4"));
					lRecord.setWeighman(weighObject.getString("weighMan"));
					lRecord.setWeighmode(weighObject.getString("weighMode"));
					lRecord.setWeightno(weighObject.getString("weightNo"));
					lRecord.setFilltime(weighObject.getDate("fillTime"));
					lRecord.setIcrecordid(weighObject.getString("icRecordId"));
					lRecord.setProductinorout(weighObject.getString("productInOrOut"));
					LoadoMasterRecord lRecord2 = loadoMeterRecordService
							.selectByPrimaryKey(weighObject.getString("id"));
					if (lRecord2 != null) {
						loadoMeterRecordService.updateByPrimaryKeySelective(lRecord);
					} else {
						result = loadoMeterRecordService.insert(lRecord);
					}

					if (result > 0) {
						count++;
						if (count == total) {
							flag = true;
						}
					}
				}

			}

		}
		return flag;
	}

	/**
	 * @Title: main @Description: TODO(这里用一句话描述这个方法的作用) @param @param
	 *         args参数说明 @return void 返回类型 @throws
	 */
	public static void main(String[] args) {

		/*
		 * // 获取parameter信息 String geturl =
		 * "http://222.185.140.242:9190/vortexrest/api/czcc/data/commonDataInsert";
		 * int j = 35; String query = "parameters={\"pageSize\":" + j +
		 * ",\"pageNo\":1}"; //
		 * ?parameters={"time":1422064874000,"pageSize":20,"pageNo":1}
		 * JSONObject parameterJson =
		 * JSONObject.parseObject(HttpClientUtil.loadData(geturl, "POST",
		 * query)); System.err.println("rfidJson:" + rfidJson); if
		 * (parameterJson != null &&
		 * parameterJson.get("succ").toString().equals("true")) { // 数据库操作
		 * JSONObject rowsJson =
		 * JSONObject.parseObject(parameterJson.get("data").toString());
		 * JSONArray json =
		 * JSONArray.parseArray(rowsJson.get("rows").toString()); //
		 * 首先把字符串转成JSONArray对象 if (json.size() > 0) { for (int i = 0; i <
		 * json.size(); i++) { JSONObject pObject = json.getJSONObject(i);
		 * System.out.println("id=" + pObject.get("id"));
		 * pRecord.setId(pObject.getString("id"));
		 * pRecord.setCreatetime(pObject.getDate("createTime"));
		 * pRecord.setLastchangetime(pObject.getDate("lastChangeTime"));
		 * pRecord.setStatus(pObject.getInteger("status"));
		 * pRecord.setBeendeleted(pObject.getInteger("beenDeleted"));
		 * pRecord.setDeletedtime(pObject.getDate("deletedTime"));
		 * pRecord.setDescription(pObject.getString("description"));
		 * pRecord.setDisplayvalue(pObject.getString("displayValue"));
		 * pRecord.setOrderindex(pObject.getInteger("orderIndex"));
		 * pRecord.setParametervaluetype(pObject.getString("parameterValueType")
		 * ); pRecord.setValue(pObject.getString("value"));
		 * System.err.println("NO." + i + "-Object:" + pRecord);
		 * 
		 * } }
		 * 
		 * }
		 */

		// 获取parameter信息
		String geturl = "http://222.185.140.242:9190/vortexrest/api/czcc/data/restDataInsert";
		int j = -1;
		String query = "parameters={\"pageSize\":" + j + ",\"pageNo\":1}";
		// ?parameters={"time":1422064874000,"pageSize":20,"pageNo":1}
		JSONObject restJson = JSONObject.parseObject(HttpClientUtil.loadData(geturl, "POST", query));
		System.err.println("rfidJson:" + restJson);
		if (restJson != null && restJson.get("succ").toString().equals("true")) {
			// 数据库操作
			JSONObject rowsJson = JSONObject.parseObject(restJson.get("data").toString());
			JSONArray json = JSONArray.parseArray(rowsJson.get("rows").toString()); // 首先把字符串转成JSONArray对象
			if (json.size() > 0) {
				for (int i = 0; i < json.size(); i++) {
					JSONObject restObject = json.getJSONObject(i);
					System.out.println("id=" + restObject.get("id"));

				}
			}

		}

	}

}
