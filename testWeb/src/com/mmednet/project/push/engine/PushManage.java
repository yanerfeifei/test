package com.mmednet.project.push.engine;

import com.mmednet.project.health.remind.common.RemindConstants;
import com.mmednet.project.push.um.AndroidNotification;
import com.mmednet.project.push.um.PushClient;
import com.mmednet.project.push.um.android.AndroidUnicast;
import com.mmednet.project.push.um.ios.IOSUnicast;
import com.mmednet.robot.domain.push.PushUserAppParam;
import com.mmednet.robot.utils.CheckNull;
import com.mmednet.robot.utils.Constants;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

/**
 * <p>
 * 推送管理
 * </p>
 * 
 * @author Lennon.Wang
 * @site http://www.biubiu.net
 * @version 1.0
 * @date 2016-1-25
 * @since JDK 1.7
 * @copyright Copyright 2015 BeiJing MMEDNET. All rights reserved.
 */
public class PushManage {

	private final static Logger logger = Logger.getLogger(PushManage.class);

	private static PushManage pm = new PushManage();

	private PushClient client = new PushClient();

	private PushManage() {

	}

	public static PushManage getInstance() {
		synchronized (pm) {
			if (CheckNull.isNull(pm)) {
				pm = new PushManage();
			}
		}
		return pm;

	}

	public String pushMsg(PushUserAppParam param) {
		try {
			if (param.getAppPlatform().intValue() == Constants.APP_PLATFORM.android) {
				return sendAndroidUnicast(param);
			} else {
				return sendIOSUnicast(param);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}

	}

	/**
	 * <p>
	 * 推送安卓手机
	 * </p>
	 * 
	 * @author Lennon.Wang
	 * @date 2016-1-25 下午04:33:20
	 * @param param
	 * @throws Exception
	 */
	public String sendAndroidUnicast(PushUserAppParam param) throws Exception {
		logger.info("<--Android-param:" + param.toString());
		AndroidUnicast unicast = new AndroidUnicast(param.getAppkey(), param.getAppMasterSecret());
		unicast.setDeviceToken(param.getToken());
		unicast.setTicker(param.getTicker());
		unicast.setTitle(param.getTitle());
		unicast.setText(param.getText());

		if (RemindConstants.UM_AFTER_OPEN.go_custom.equals(param.getAfter_open())) {
			unicast.goCustomAfterOpen(param.getExtraFieldVal());
		} else {
			unicast.goAppAfterOpen();
		}
		unicast.setDisplayType(AndroidNotification.DisplayType.NOTIFICATION);
		unicast.setProductionMode();//正式模式
//		unicast.setTestMode();//测试模式
		if(!CheckNull.isNull(param.getExtraFieldKey())){
			unicast.setExtraField(param.getExtraFieldKey(), param.getExtraFieldVal());
		}
		return client.send(unicast);
	}

	public String sendIOSUnicast(PushUserAppParam param) throws Exception {
		logger.info("<--IOS-param:" + param.toString());
		IOSUnicast unicast = new IOSUnicast(param.getAppkey(), param.getAppMasterSecret());
		unicast.setDeviceToken(param.getToken());
		unicast.setAlert(param.getText());
		unicast.setBadge(0);
		unicast.setSound("default");
		
		unicast.setProductionMode();//正式模式
//		unicast.setTestMode();//测试模式
		
		unicast.setCustomizedField("description", param.getText());
		if(!CheckNull.isNull(param.getExtraFieldKey())){
			unicast.setCustomizedField(param.getExtraFieldKey(), param.getExtraFieldVal());
		}
		return client.send(unicast);
	}

	  public static void main(String[] args) {
		PushUserAppParam param = new PushUserAppParam();
		param.setTicker("mmednet");
		param.setAfter_open("go_custom");
		param.setAppkey("5760b5e767e58e37eb003bc0");
		param.setAppMasterSecret("1s0ia12cakamqon2cokivnzlavlfpnjs");
		param.setToken("22e68a0d81986b4258ecce964ac66367b37e8c5c47d560e4d7a461087ffb85be");
		param.setTitle("智能健康管家");
		param.setText("亲，为了您的健康，30001");
		JSONObject json = new JSONObject();
		json.put("type", 1);
		json.put("itemEncoding", "30004");
		param.setExtraFieldKey("dataStr");
		param.setExtraFieldVal(json.toString());

		try {
			PushManage.getInstance().sendIOSUnicast(param);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
}
