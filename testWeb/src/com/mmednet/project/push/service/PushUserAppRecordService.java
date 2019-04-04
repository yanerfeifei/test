package com.mmednet.project.push.service;

import com.mmednet.common.dao.BaseDao;
import com.mmednet.common.service.BaseService;
import com.mmednet.common.util.BeanHelper;
import com.mmednet.project.push.dao.PushLogsDao;
import com.mmednet.project.push.dao.PushUserAppRecordDao;
import com.mmednet.project.push.engine.PushManage;
import com.mmednet.project.push.model.PushLogs;
import com.mmednet.project.push.model.PushUserAppRecord;
import com.mmednet.robot.domain.push.PushUserAppParam;
import com.mmednet.robot.utils.CheckNull;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class PushUserAppRecordService extends BaseService<PushUserAppRecord> {

    private final static Logger logger = Logger.getLogger(PushUserAppRecordService.class);

    PushUserAppRecordDao pushUserAppRecordDao;

    @Resource
    PushLogsDao pushLogsDao;

    @Resource
    @Override
    public void setBaseDao(BaseDao<PushUserAppRecord> pushUserAppRecordDao) {
        this.pushUserAppRecordDao = (PushUserAppRecordDao) pushUserAppRecordDao;
        this.baseDao = pushUserAppRecordDao;
    }

    /**
     * <p>
     * 保存
     * </p>
     *
     * @param model
     * @return
     * @author Lennon.Wang
     * @date 2016-1-25 下午01:48:50
     */
    public Integer savePushUserAppRecord(PushUserAppRecord model) {
        model.setUpdateTime(new Date());
        return (Integer) pushUserAppRecordDao.save(model);
    }

    /**
     * 更新推送账号信息
     *
     * @param applyType  APP应用：1健康之星，2甲状腺，3，4 pad
     * @param systemType app平台：1 Android，2 IOS
     * @param identity   唯一标示
     * @param uid        用户编号
     */
    public void updatePushUserAppRecord(Integer applyType, Integer systemType, String identity, String uid) {
        PushUserAppRecord obj = new PushUserAppRecord();
        obj.setAppApply(applyType);
        obj.setAppPlatform(systemType);
        obj.setToken(identity);
        obj.setUid(uid);
        try {
            if (CheckNull.isNull(obj) || CheckNull.isNull(obj.getToken())) {
                return;
            }
            // 查找userid+appPlatform+appApply是否存在
            PushUserAppRecord model = find(obj);
            if (CheckNull.isNull(model)) {
                // 找不到就加一条
                savePushUserAppRecord(obj);
            } else if (!obj.getToken().equals(model.getToken())) {

                // 删除同一手机同一应用多余账号
                pushUserAppRecordDao.del(obj);

                // 找到了就更新其最新token
                model.setToken(obj.getToken());
                model.setUpdateTime(new Date());
                pushUserAppRecordDao.update(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * <p>
     * 查找
     * </p>
     *
     * @param obj
     * @return
     * @author Lennon.Wang
     * @date 2016-1-25 下午01:58:13
     */
    public PushUserAppRecord find(PushUserAppRecord obj) {
        return pushUserAppRecordDao.find(obj);
    }

    /**
     * <p>
     * 查询用户推送信息
     * </p>
     *
     * @param param
     * @return
     * @author Lennon.Wang
     * @date 2016-1-25 下午03:27:29
     */
    public List<PushUserAppParam> findPushInfo(PushUserAppParam param) {
        return pushUserAppRecordDao.findPushInfo(param);
    }

    /**
     * 去推送
     *
     * @param param
     * @return
     */
    public int createPushMsg(PushUserAppParam param) {
        logger.info("pushMsg-->开始推送...");
        int a = 0;
        int b = 1;
        try {
            // 查询推送参数
            List<PushUserAppParam> puaplist = findPushInfo(param);
            if (!CheckNull.isNull(puaplist)) {
                for (PushUserAppParam puap : puaplist) {
                    // 设置推送消息
                    puap.setTicker(param.getTicker());
                    puap.setTitle(param.getTitle());
                    puap.setText(param.getText());
                    puap.setAfter_open(param.getAfter_open());
                    puap.setExtraFieldKey(param.getExtraFieldKey());
                    puap.setExtraFieldVal(param.getExtraFieldVal());
                    String rt = PushManage.getInstance().pushMsg(puap);

                    // 记录推送日志
                    PushLogs logs = new PushLogs();
                    BeanHelper.copyProperties(puap, logs);
                    logs.setReturnResult(rt);
                    pushLogsDao.save(logs);
                    if (!"".equals(rt)) {
                        JSONObject json = JSONObject.fromObject(rt);
                        String ret = (String) json.get("ret");
                        if ("SUCCESS".equals(ret)) {
                            a++;
                        }

                    }
                }
                // 全部失败
                if (a == 0) {
                    b = 1;
                }
                // 部分成功
                else if (a < puaplist.size()) {
                    b = 2;
                }
                // 全部成功
                else if (a == puaplist.size()) {
                    b = 3;
                }
            }

            logger.info("<--pushMsg推送完成");
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug(e);
        }

        return b;

    }

}
