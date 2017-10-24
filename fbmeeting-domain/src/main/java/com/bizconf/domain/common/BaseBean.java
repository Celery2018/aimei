package com.bizconf.domain.common;

/**
 * Created by Byron on 2017/2/24.
 */
public class BaseBean extends  BaseEntity{

	//过渡字段，记录上次cache更新时间。
	protected  long  lastOperationMillions;
//	protected  String redisKey;
	@Override
	public void setId(int id) {
	}

	@Override
	public int getId() {
		return -1;
	}

	public long getLastOperationMillions() {
		return lastOperationMillions;
	}

	public void setLastOperationMillions(long lastOperationMillions) {
		this.lastOperationMillions = lastOperationMillions;
	}


//	public String getRedisKey() {
//		return redisKey;
//	}
//
//	public void setRedisKey(String redisKey) {
//		this.redisKey = redisKey;
//	}
}
