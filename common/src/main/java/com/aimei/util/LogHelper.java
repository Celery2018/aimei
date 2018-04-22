package com.aimei.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogHelper {
	
	/************************运营平台日志start****************************/
	//reis相关
    public static final Logger log_consoleFile = LoggerFactory.getLogger("consoleFile");
	//action操作相关
	public static final Logger log_action = LoggerFactory.getLogger("action");
	//update操作相关
	public static final Logger update_action = LoggerFactory.getLogger("update");
	//database操作相关
	public static final Logger log_database = LoggerFactory.getLogger("database");


	/**
	 * 同步相关task日志
	 */
	public static final Logger syncTask = LoggerFactory.getLogger("syncTask");

}
