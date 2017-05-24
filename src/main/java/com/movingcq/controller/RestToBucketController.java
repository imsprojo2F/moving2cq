/**   
* @Title: RestToBucketController.java 
* @Package com.movingcq.controller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author IsProjo
* @date 2016年12月22日 下午4:31:31 
* @version V1.0   
*/
package com.movingcq.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.movingcq.entity.BucketInfo;
import com.movingcq.entity.RestaurantBucketInfo;
import com.movingcq.service.IBucketInfoService;
import com.movingcq.service.IRest2BucketService;
import com.movingcq.service.IRestInfoService;
import com.movingcq.util.ApiResult;

/**
 * @ClassName: RestToBucketController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author IsProjo
 * @date 2016年12月22日 下午4:31:31
 * 
 */
@Controller
@RequestMapping("/rest2bucket")
public class RestToBucketController {

	Object rObject = null;
	Map<String, String> map = new HashMap<String, String>();

	@Autowired
	private IRest2BucketService rest2bucketService;

	@Autowired
	private IBucketInfoService bucketService;

	@Autowired
	private IRestInfoService restInfoService;

	@ResponseBody
	@RequestMapping("bindingBucket")
	public Object bindingBucket(HttpServletRequest request) {

		String restId = request.getParameter("restId");
		String bucketId = request.getParameter("bucketId");

		RestaurantBucketInfo rBucketInfo = new RestaurantBucketInfo();
		rBucketInfo.restaurant_id = Integer.valueOf(restId);
		rBucketInfo.bucket_id = Integer.valueOf(bucketId);

		int isSuccess = rest2bucketService.addBinding(rBucketInfo);
		BucketInfo bucketInfo = new BucketInfo();
		bucketInfo.id = Integer.valueOf(bucketId);
		bucketInfo.is_binding = 1;

		map.put("restId", restId);
		int last_used_barrel = rest2bucketService.getBindByRestId(map);
		map.put("last_used_barrel", String.valueOf(last_used_barrel));

		// 更新桶为绑定状态
		isSuccess = bucketService.updateById(bucketInfo);
		// 更新rest表已使用桶数量
		isSuccess = restInfoService.updateByDynamic(map);
		if (isSuccess > 0) {
			rObject = new ApiResult("保存成功", ApiResult.CODE_SUCCESS);
		} else {
			rObject = new ApiResult("保存失败", ApiResult.CODE_FAIL);
		}
		return rObject;
	}

	@ResponseBody
	@RequestMapping("unbindingBucket")
	public Object unbindingBucket(HttpServletRequest request) {

		String restId = request.getParameter("restId");
		String bucketId = request.getParameter("bucketId");

		int isSuccess = rest2bucketService.deleteById(restId, bucketId);
		BucketInfo bucketInfo = new BucketInfo();
		bucketInfo.id = Integer.valueOf(bucketId);
		bucketInfo.is_binding = 0;

		map.put("restId", restId);
		int last_used_barrel = rest2bucketService.getBindByRestId(map);
		map.put("last_used_barrel", String.valueOf(last_used_barrel));

		// 更新桶为绑定状态
		isSuccess = bucketService.updateById(bucketInfo);
		// 更新rest表已使用桶数量
		isSuccess = restInfoService.updateByDynamic(map);

		if (isSuccess > 0) {
			rObject = new ApiResult("删除成功", ApiResult.CODE_SUCCESS);
		} else {
			rObject = new ApiResult("删除失败", ApiResult.CODE_FAIL);
		}
		return rObject;
	}

	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping("getHasBinding")
	public Object listAllBucket(String restId) {

		List<Map> rList = rest2bucketService.listAllBinding(restId);
		return rList;
	}

}
