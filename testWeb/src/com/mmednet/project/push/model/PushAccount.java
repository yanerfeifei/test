package com.mmednet.project.push.model;

import java.io.Serializable;//import javax.persistence.*;
import java.io.Serializable;

/**
 * <p>
 * 推送账户
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
//@Table(name = "sys_push_account", catalog = "securitydb")
public class PushAccount implements Serializable {

	/** serialVersionUID **/
	private static final long serialVersionUID = -572449171760381244L;
	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/** app key **/
	private String appkey;

	/** app 密码 **/
	private String appMasterSecret;

	/** app平台：1 Android，2 IOS **/
	private Integer appPlatform;

	/** APP应用：1健康之星，2甲状腺 **/
	private Integer appApply;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAppkey() {
		return appkey;
	}

	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}

	public String getAppMasterSecret() {
		return appMasterSecret;
	}

	public void setAppMasterSecret(String appMasterSecret) {
		this.appMasterSecret = appMasterSecret;
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

}
