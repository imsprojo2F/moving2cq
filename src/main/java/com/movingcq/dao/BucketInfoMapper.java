package com.movingcq.dao;

import java.util.List;
import java.util.Map;

import com.movingcq.entity.Bucket2RfidInfo;
import com.movingcq.entity.BucketInfo;

public interface BucketInfoMapper {

	List<BucketInfo> listAllBucket(Map<String, Object> qMap);

	List<Bucket2RfidInfo> getAllBucket();

	List<Map<String, String>> selectByPage(Map<String, Object> qMap);

	BucketInfo selectByAcc(String bucket_code);

	/**
	 * @param sysBucket
	 * @return
	 */
	int addBucket(BucketInfo bucketInfo);

	/**
	 * @param ids
	 * @return
	 */
	int deleteById(String[] ids);

	int deleteByRfids(String[] ids);

	/**
	 * @param Bucket
	 * @return
	 */
	int updateById(BucketInfo bucketInfo);

	int updateByRfid(String id, String id1);
}