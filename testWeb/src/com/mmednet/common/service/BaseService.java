package com.mmednet.common.service;

import com.mmednet.common.dao.BaseDao;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 数据业务基础类
 * </p>
 * 
 * @author Lennon.Wang
 * @site http://www.grablove.com
 * @version 1.0
 * @date 2016-11-10
 * @since JDK 1.7
 * @copyright Copyright 2015 BeiJing MMEDNET. All rights reserved.
 */
public abstract class BaseService<E extends Serializable> {

	/** 数据访问基础类 **/
	protected BaseDao<E> baseDao;

	public abstract void setBaseDao(BaseDao<E> baseDao);

	/**
	 * <p>
	 * 保存业务对象
	 * </p>
	 * 
	 * @author Lennon.Wang
	 * @date 2015-12-22 下午04:29:27
	 * @param model
	 * @return
	 */
	public Serializable save(E model) {
		return baseDao.save(model);
	}

	/**
	 * <p>
	 * 更新业务对象
	 * </p>
	 * 
	 * @author Lennon.Wang
	 * @date 2015-12-22 下午04:29:38
	 * @param model
	 */
	public void merge(E model) {
		baseDao.merge(model);
	}

	/**
	 * <p>
	 * 保存更新业务对象
	 * </p>
	 * 
	 * @author Lennon.Wang
	 * @date 2015-12-22 下午04:29:47
	 * @param model
	 */
	public void saveOrUpdate(E model) {
		baseDao.saveOrUpdate(model);
	}

	/**
	 * <p>
	 * 更新对象
	 * </p>
	 * 
	 * @author Lennon.Wang
	 * @date 2015-12-22 下午04:29:53
	 * @param model
	 */
	public void update(E model) {
		baseDao.update(model);
	}

	/**
	 * <p>
	 * 删除业务对象
	 * </p>
	 * 
	 * @author Lennon.Wang
	 * @date 2015-12-22 下午04:30:00
	 * @param id
	 */
	public void delete(Serializable id) {
		baseDao.delete(id);
	}

	/**
	 * <p>
	 * 获取对象
	 * </p>
	 * 
	 * @author Lennon.Wang
	 * @date 2015-12-22 下午04:30:20
	 * @param id
	 * @return
	 */
	public E get(Serializable id) {
		return baseDao.get(id);
	}

	public List<E> listAll() {
		return baseDao.listAll();
	}
	
	public void flush(){
		baseDao.flush();
	}

}
