package com.movingcq.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movingcq.dao.BucketInfoMapper;
import com.movingcq.entity.Bucket2RfidInfo;
import com.movingcq.entity.BucketInfo;
import com.movingcq.service.IBucketInfoService;

@Service("bucketService")
public class BucketInfoServiceImpl implements IBucketInfoService {

	@Autowired
	private BucketInfoMapper bucketInfoMapper;

	/*
	 * Title: addBucketInfo Description:
	 * 
	 * @param bucketInfo
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IBucketInfoService#addBucketInfo(com.movingcq.entity
	 * .BucketInfo)
	 */

	@Override
	public int addBucketInfo(BucketInfo bucketInfo) {
		// TODO Auto-generated method stub
		return bucketInfoMapper.addBucket(bucketInfo);
	}

	/*
	 * Title: deleteById Description:
	 * 
	 * @param ids
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IBucketInfoService#deleteById(java.lang.String[])
	 */

	@Override
	public int deleteById(String[] ids) {
		// TODO Auto-generated method stub
		return bucketInfoMapper.deleteById(ids);
	}

	/*
	 * Title: updateById Description:
	 * 
	 * @param bucketInfo
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IBucketInfoService#updateById(com.movingcq.entity.
	 * BucketInfo)
	 */

	@Override
	public int updateById(BucketInfo bucketInfo) {
		// TODO Auto-generated method stub
		return bucketInfoMapper.updateById(bucketInfo);
	}

	/*
	 * Title: listAllBucketInfo Description:
	 * 
	 * @param qParameters
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IBucketInfoService#listAllBucketInfo(com.movingcq.
	 * entity.QueryParameters)
	 */

	@Override
	public List<BucketInfo> listAllBucketInfo(Map<String, Object> qMap) {
		// TODO Auto-generated method stub
		return bucketInfoMapper.listAllBucket(qMap);
	}

	/*
	 * Title: selectByPage Description:
	 * 
	 * @param qParameters
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IBucketInfoService#selectByPage(com.movingcq.entity.
	 * QueryParameters)
	 */

	@Override
	public List<Map<String, String>> selectByPage(Map<String, Object> qMap) {
		// TODO Auto-generated method stub
		return bucketInfoMapper.selectByPage(qMap);
	}

	@Override
	public BucketInfo selectByAcc(String bucket_code) {
		// TODO Auto-generated method stub
		return bucketInfoMapper.selectByAcc(bucket_code);
	}

	/*
	 * Title: getAllBucketInfo Description:
	 * 
	 * @return
	 * 
	 * @see com.movingcq.service.IBucketInfoService#getAllBucketInfo()
	 */

	@Override
	public List<Bucket2RfidInfo> getAllBucketInfo() {
		// TODO Auto-generated method stub
		return bucketInfoMapper.getAllBucket();
	}

	/*
	 * Title: deleteByRfids Description:
	 * 
	 * @param ids
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IBucketInfoService#deleteByRfids(java.lang.String[])
	 */

	@Override
	public int deleteByRfids(String[] ids) {
		// TODO Auto-generated method stub
		return bucketInfoMapper.deleteByRfids(ids);
	}

	/*
	 * Title: updateByRfid Description:
	 * 
	 * @param id
	 * 
	 * @param ids
	 * 
	 * @return
	 * 
	 * @see
	 * com.movingcq.service.IBucketInfoService#updateByRfid(java.lang.String,
	 * java.lang.String)
	 */

	@Override
	public int updateByRfid(String id, String ids) {
		// TODO Auto-generated method stub
		return bucketInfoMapper.updateByRfid(id, ids);
	}

}
