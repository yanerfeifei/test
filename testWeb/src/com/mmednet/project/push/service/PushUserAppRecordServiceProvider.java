package com.mmednet.project.push.service;

import com.mmednet.robot.domain.push.PushUserAppParam;
import com.mmednet.robot.serviceapi.push.PushUserAppRecordServiceApi;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("pushUserAppRecordServiceProvider")
public class PushUserAppRecordServiceProvider implements PushUserAppRecordServiceApi {

    private final static Logger logger = Logger.getLogger(PushUserAppRecordServiceProvider.class);

    @Resource
    PushUserAppRecordService pushUserAppRecordService;

    /**
     * 更新推送账号信息
     *
     * @param applyType  APP应用：1健康之星，2甲状腺，3，4 pad
     * @param systemType app平台：1 Android，2 IOS
     * @param identity   唯一标示
     * @param uid        用户编号
     */
    @Override
    public void updatePushUserAppRecord(Integer applyType, Integer systemType, String identity, String uid) {
        pushUserAppRecordService.updatePushUserAppRecord(applyType, systemType, identity, uid);
    }

    /**
     * 去推送
     *
     * @param param
     * @return
     */
    @Override
    public int createPushMsg(PushUserAppParam param) {
        return pushUserAppRecordService.createPushMsg(param);
    }

}
