package com.mmednet.robot.domain.push;

import java.io.Serializable;

/**
 * <p>
 * 用户APP推送参数
 * </p>
 * 
 * @author Lennon.Wang
 * @site http://www.biubiu.net
 * @version 1.0
 * @date 2016-1-25
 * @since JDK 1.7
 * @copyright Copyright 2015 BeiJing MMEDNET. All rights reserved.
 */
public class PushUserAppParam implements Serializable{

	/** 用户ID **/
	private String uid;

	/** app key **/
	private String appkey;

	/** app 密码 **/
	private String appMasterSecret;

	/** 唯一标识 **/
	private String token;

	/** app平台：1 Android，2 IOS **/
	private Integer appPlatform;

	/** APP应用：1健康之星，2甲状腺 **/
	private Integer appApply;

	private String title;
	private String text;

	private String extraFieldKey;
	private String extraFieldVal;
	
	/**
	 * "go_app": 打开应用 "go_url": 跳转到URL "go_activity": 打开特定的activity "go_custom":
	 * 用户自定义内容。
	 **/
	private String after_open;

	private String ticker;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getExtraFieldKey() {
		return extraFieldKey;
	}

	public void setExtraFieldKey(String extraFieldKey) {
		this.extraFieldKey = extraFieldKey;
	}

	public String getExtraFieldVal() {
		return extraFieldVal;
	}

	public void setExtraFieldVal(String extraFieldVal) {
		this.extraFieldVal = extraFieldVal;
	}

	public String getAfter_open() {
		return after_open;
	}

	public void setAfter_open(String afterOpen) {
		after_open = afterOpen;
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	@Override
	public String toString() {
		return "PushUserAppParam [after_open=" + after_open + ", appApply=" + appApply + ", appMasterSecret="
				+ appMasterSecret + ", appPlatform=" + appPlatform + ", appkey=" + appkey + ", extraFieldKey="
				+ extraFieldKey + ", extraFieldVal=" + extraFieldVal + ", text=" + text + ", ticker=" + ticker
				+ ", title=" + title + ", token=" + token + ", uid='" + uid + "'" + "]";
	}

}
