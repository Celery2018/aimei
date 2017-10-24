package com.bizconf.domain.net;

import java.io.Serializable;

/**
 * Created by Byron on 2017/6/6.
 */
public class BaseResponse<T> implements Serializable {

	private String status;

	private String message;

	private T data;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}


