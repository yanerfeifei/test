package com.mmednet.project.push.dao;

import com.mmednet.common.dao.BaseDao;
import com.mmednet.common.util.BeanHelper;
import com.mmednet.project.push.model.PushUserAppRecord;
import com.mmednet.robot.domain.push.PushUserAppParam;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 
 * </p>
 * 
 * @author Lennon.Wang
 * @site http://www.biubiu.net
 * @version 1.0
 * @date 2016-1-25
 * @since JDK 1.7
 * @copyright Copyright 2015 BeiJing MMEDNET. All rights reserved.
 */
@Repository
public class PushUserAppRecordDao extends BaseDao<PushUserAppRecord> {

	/**
	 * <p>
	 * 查找
	 * </p>
	 * 
	 * @author Lennon.Wang
	 * @date 2016-1-25 下午01:57:24
	 * @param obj
	 * @return
	 */
	public PushUserAppRecord find(PushUserAppRecord obj) {
		String HQL = "FROM PushUserAppRecord WHERE uid=? AND appPlatform=? AND appApply=?";
		PushUserAppRecord model = this.aggregate(HQL, obj.getUid(), obj.getAppPlatform(), obj.getAppApply());
		return model;

	}

	/**
	 * <p>
	 * 删除同一手机同一应用多余账号
	 * </p>
	 * 
	 * @author Lennon.Wang
	 * @date 2016-1-25 下午02:23:10
	 * @param obj
	 */
	public void del(PushUserAppRecord obj) {
		String HQL = "DELETE FROM PushUserAppRecord WHERE token=? AND appApply=? AND uid!=?";
		this.execte(HQL, obj.getToken(), obj.getAppApply(), obj.getUid());
	}

	/**
	 * <p>
	 * 查询用户推送信息
	 * </p>
	 * 
	 * @author Lennon.Wang
	 * @date 2016-1-25 下午03:26:48
	 * @param param
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<PushUserAppParam> findPushInfo(PushUserAppParam param) {
		StringBuffer sb = new StringBuffer();
		sb.append("select b.uid,a.appkey,a.appMasterSecret,b.token,a.appApply,a.appPlatform from ");
		sb.append("securitydb.sys_push_account a RIGHT JOIN ");
		sb.append("(select * from securitydb.sys_push_app_record where appApply=:appApply and uid=:uid) b ");
		sb.append("on a.appApply=b.appApply and a.appPlatform=b.appPlatform ");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("appApply", param.getAppApply());
		map.put("uid", param.getUid());
		List<Object[]> list = (List<Object[]>) findBySql(sb.toString(), map, 0, 0);
		List<PushUserAppParam> rlist = BeanHelper.transformTuple(list, PushUserAppParam.class, new String[] { "uid",
				"appkey", "appMasterSecret", "token", "appApply", "appPlatform" });

		return rlist;

	}

}
