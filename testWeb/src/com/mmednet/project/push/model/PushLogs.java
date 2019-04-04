package com.mmednet.project.push.model;

//import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 推送日志
 * </p>
 * 
 * @author Lennon.Wang
 * @site http://www.biubiu.net
 * @version 1.0
 * @date 2016-6-23
 * @since JDK 1.7
 * @copyright Copyright 2015 BeiJing MMEDNET. All rights reserved.
 */
//@Entity
//@Table(name = "sys_push_logs", catalog = "securitydb")
public class PushLogs implements Serializable {

	/** serialVersionUID **/
	private static final long serialVersionUID = 1L;

	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/** 用户ID **/
	private String uid;

	/** 唯一标识 **/
	private String token;

	/** app key **/
	private String appkey;

	/** app 密码 **/
	private String appMasterSecret;

	/** app平台：1 Android，2 IOS **/
	private Integer appPlatform;

	/** APP应用：1健康之星，2甲状腺 **/
	private Integer appApply;

	private String title;
	private String text;

	private String extraFieldKey;
	private String extraFieldVal;

	/** 返回结果 **/
	private String returnResult;

	/** 更新时间 **/
	private Date createTime = new Date();

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

	public String getReturnResult() {
		return returnResult;
	}

	public void setReturnResult(String returnResult) {
		this.returnResult = returnResult;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
