package com.movingcq.service;

import java.util.List;
import java.util.Map;

import com.movingcq.entity.Bucket2RfidInfo;
import com.movingcq.entity.BucketInfo;

public interface IBucketInfoService {

	public int addBucketInfo(BucketInfo bucketInfo);

	public int deleteById(String[] ids);

	public int deleteByRfids(String[] ids);

	public int updateById(BucketInfo bucketInfo);

	public int updateByRfid(String id, String ids);

	public List<BucketInfo> listAllBucketInfo(Map<String, Object> qMap);

	public List<Bucket2RfidInfo> getAllBucketInfo();

	public List<Map<String, String>> selectByPage(Map<String, Object> qMap);

	BucketInfo selectByAcc(String bucket_code);
}
