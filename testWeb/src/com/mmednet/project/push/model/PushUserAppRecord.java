package com.mmednet.project.push.model;

import java.io.Serializable;//import javax.persistence.*;
import java.util.Date;

/**
 * <p>
 * 用户推送APP记录
 * </p>
 * 
 * @author Lennon.Wang
 * @site http://www.biubiu.net
 * @version 1.0
 * @date 2016-1-25
 * @since JDK 1.7
 * @copyright Copyright 2015 BeiJing MMEDNET. All rights reserved.
 */
//@Entity
//@Table(name = "sys_push_app_record", catalog = "securitydb")
public class PushUserAppRecord implements Serializable {

	/** serialVersionUID **/
	private static final long serialVersionUID = -3954899320845867627L;

	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/** 用户ID **/
	private String uid;

	/** 唯一标识 **/
	private String token;

	/** app平台：1 Android，2 IOS **/
	private Integer appPlatform;

	/** APP应用：1健康之星，2甲状腺 **/
	private Integer appApply;

	/** 更新时间 **/
	private Date updateTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getAppPlatform() {
		return appPlatform;
	}

	public void setAppPlatform(Integer appPlatform) {
		this.appPlatform = appPlatform;
	}

	public Integer getAppApply() {
		return appApply;
	}

	public void setAppApply(Integer appApply) {
		this.appApply = appApply;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
