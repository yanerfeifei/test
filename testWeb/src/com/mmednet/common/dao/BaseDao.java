package com.mmednet.common.dao;

import com.mmednet.common.paging.PageObject;
import com.mmednet.robot.utils.CheckNull;
import org.apache.commons.collections.MapUtils;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import javax.annotation.Resource;
import javax.persistence.Id;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.math.BigInteger;
import java.util.*;
import java.util.Map.Entry;

/**
 * <p>
 * 数据访问基础类
 * </p>
 *
 * @author Lennon.Wang
 * @version 1.0
 * @date 2015-12-22
 * @since JDK 1.7
 * @copyright Copyright 2015 CLOUD SERVICES.
 */

public class BaseDao<E extends Serializable> {

	private final Class<E> entityClass;
	private final String HQL_LIST_ALL;
	private String pkName = null;

	@SuppressWarnings("unchecked")
	public BaseDao() {
		this.entityClass = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		Field[] fields = this.entityClass.getDeclaredFields();
		for (Field f : fields) {
			if (f.isAnnotationPresent(Id.class)) {
				this.pkName = f.getName();
			}
		}
		String entityName = this.entityClass.getSimpleName();
		HQL_LIST_ALL = "FROM " + entityName + " ORDER BY " + pkName + " desc";
	}

	@Resource
	protected SessionFactory sessionFactory;

	public Session getSession() {
		// 事务必须是开启的(Required)，否则获取不到
		return sessionFactory.getCurrentSession();
	}

	/**
	 * <p>
	 * Title: flush
	 * </p>
	 * <p>
	 * Description: 释放资源
	 * </p>
	 */
	public void flush() {
		getSession().flush();
	}

	public void clear() {
		getSession().clear();
	}

	protected void setParameters(Query query, Object[] paramlist) {
		query.setCacheable(true);
		if (paramlist != null) {
			for (int i = 0; i < paramlist.length; i++) {
				if (paramlist[i] instanceof Date) {
					// 难道这是bug 使用setParameter不行？？
					query.setTimestamp(i, (Date) paramlist[i]);
				} else {
					query.setParameter(i, paramlist[i]);
				}
			}
		}
	}

	/**
	 * <p>
	 * 查询唯一数据
	 * </p>
	 *
	 * @author Lennon.Wang
	 * @date 2016-10-27 下午03:17:39
	 * @param <T>
	 * @param hql
	 * @param paramlist
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected <T> T unique(final String hql, final Object... paramlist) {
		Query query = getSession().createQuery(hql);
		query.setCacheable(true);
		setParameters(query, paramlist);
		return (T) query.setMaxResults(1).uniqueResult();
	}

	/**
	 * <p>
	 * 查询唯一数据
	 * </p>
	 *
	 * @author Lennon.Wang
	 * @date 2016-11-28 下午05:55:29
	 * @param sql
	 * @param paramlist
	 * @return
	 */
	protected Object[] uniqueSql(final String sql) {
		Query query = getSession().createSQLQuery(sql);
		Object[] objs = null;
		Object uniqueResult = query.setMaxResults(1).uniqueResult();
		try {
			objs = (Object[]) uniqueResult;
		} catch (Exception e) {
			objs = new Object[1];
			objs[0] = uniqueResult;
		}

		return objs;
	}

	@SuppressWarnings("unchecked")
	protected <T> T aggregate(final String hql, final Object... paramlist) {
		Query query = getSession().createQuery(hql);
		query.setCacheable(true);
		setParameters(query, paramlist);
		return (T) query.uniqueResult();
	}

	/**
	 * 通过主键Id来删除数据
	 *
	 * @param objClass
	 *            删除数据的类型
	 * @param id
	 *            主键ID
	 */
	public void delete(Serializable id) {
		getSession().delete(this.get(id));
	}

	/**
	 * 通过HQL来分页查询
	 *
	 * @param hql
	 *            HQL语句
	 * @param map
	 *            条件MAP
	 * @param pageSize
	 *            一页条数
	 * @param pageNo
	 *            页数
	 * @return
	 */
	public List<?> findByHql(String hql, Map<String, Object> map, int pageSize, int pageNo) {
		return this.getQuery(hql, map, pageSize, pageNo).list();
	}

	/**
	 * 通过SQL条件来分页查询
	 *
	 * @param sql
	 *            SQL语句
	 * @param map
	 *            条件MAP
	 * @param pageSize
	 *            一页条数
	 * @param pageNo
	 *            页数
	 * @return
	 */
	public List<?> findBySql(String sql, Map<String, Object> map, int pageSize, int pageNo) {
		return this.getSQLQuery(sql, map, pageSize, pageNo).list();
	}

	/**
	 * 获得主键ID来查询数据
	 *
	 * @param objClass
	 *            数据的类型
	 * @param id
	 *            主键Id
	 * @return
	 */
	public E get(Serializable id) {
		return (E) getSession().get(entityClass, id);
	}

	/**
	 * 通过HQL来查询条数
	 *
	 * @param hql
	 *            HQL语句
	 * @param map
	 *            条件MAP
	 * @param pageSize
	 *            一页条数
	 * @param pageNo
	 *            页数
	 * @return
	 */
	public Long getCountByHql(String hql, Map<String, Object> map, int pageSize, int pageNo) {
		String totalHql = hql.substring(hql.toLowerCase().indexOf("from"), hql.length());
		totalHql = "SELECT COUNT(*) " + totalHql;
		return (Long) this.findByHql(totalHql, map, pageSize, pageNo).get(0);
	}

	/**
	 * 通过SQL来查询条数
	 *
	 * @param sql
	 *            SQL语句
	 * @param map
	 *            条件MAP
	 * @param pageSize
	 *            一页条数
	 * @param pageNo
	 *            页数
	 * @return
	 */
	public Long getCountBySql(String sql, Map<String, Object> map, int pageSize, int pageNo) {
		// 截取from后的SQL语句
		// String totalHql = sql.substring(sql.toLowerCase().indexOf(" from "),
		// sql
		// .length());

		// 加上前COUNT
		sql = "SELECT COUNT(*) from (" + sql + ") as ccsdfsdf";
		return (Long) ((BigInteger) this.findBySql(sql, map, pageSize, pageNo).get(0)).longValue();
	}

	/**
	 * 根据SQL查询条件获得 记录数目
	 * @param sql
	 * @param map
	 * @return
	 */
	public long countBySQL(String sql,Map<String, Object> map){
		long recordCount = 0L;
		SQLQuery query = createSQLQuery(sql);
		if(MapUtils.isNotEmpty(map)){
			for(Entry<String,Object> entry : map.entrySet()){
				query.setParameter(entry.getKey(),entry.getValue());
			}
			recordCount = ((BigInteger)query.uniqueResult()).longValue();
		}
		return recordCount;
	}

	/**
	 * 插入新的记录
	 *
	 * @param obj
	 *            记录
	 */
	public Object insert(Object obj) {
		return getSession().save(obj);

	}

	/**
	 * 通过主建查询数据
	 *
	 * @param objClass
	 *            数据
	 * @param id
	 *            主建
	 * @return
	 */
	public E load(Class<E> objClass, Serializable id) {
		return (E) getSession().load(objClass, id);
	}

	/**
	 * 保存或者修改对象
	 *
	 * @param obj
	 *            对象
	 */
	public void saveOrUpdate(Object obj) {
		getSession().saveOrUpdate(obj);
	}

	public Serializable save(Object obj) {
		return getSession().save(obj);
	}

	/**
	 * 修改单个对象
	 *
	 * @param obj
	 *            对象
	 */
	public void update(Object obj) {
		getSession().update(obj);
	}

	public void merge(E model) {
		getSession().merge(model);
	}

	/*
	 * ----------------------private method---------------------
	 */

	/**
	 * @Title: getQuery @Description: 通过一些参数获得查询对象 @param hql HQL语句 @param map
	 *         参数对象 @return Query @throws
	 */
	public Query getQuery(String hql, Map<String, Object> map) {
		Query query = this.createQuery(hql);
		query = this.setParameter(query, map);
		return query;
	}

	/**
	 * @Title: createQuery @Description: 通过HQL获得Query对象 @param hql HQL语句 @return
	 *         Query @throws
	 */
	private Query createQuery(String hql) {
		return getSession().createQuery(hql);
	}

	/**
	 * @Title: setParameter @Description: 设置参数值来方便查询 @param query 查询对象 @param
	 *         map 参数MAP @return Query @throws
	 */
	private Query setParameter(Query query, Map<String, Object> map) {
		if (!CheckNull.isNull(map)) {
			for (Entry<String, Object> entry : map.entrySet()) {
				Object obj = entry.getValue();

				// 这里考虑传入的参数是什么类型，不同类型使用的方法不同
				if (obj instanceof Collection) {
					query.setParameterList(entry.getKey(), (Collection<E>) obj);
				} else if (obj instanceof Object[]) {
					query.setParameterList(entry.getKey(), (Object[]) obj);
				} else {
					query.setParameter(entry.getKey(), obj);
				}
			}
		}
		return query;
	}

	/**
	 * @Title: getQuery @Description: 分页+参数来获得查询对象 @param hql HQL语句 @param map
	 *         参数MAP @param pageSize 一页数条数 @param pageNo 页数 @return Query @throws
	 */
	private Query getQuery(String hql, Map<String, Object> map, int pageSize, int pageNo) {
		// 通过HQL来获得HQL查询器
		Query query = this.createQuery(hql);

		// 给HQL查询器来设置过滤条件
		query = this.setParameter(query, map);

		// 给HQL查询器来设置分页
		query = this.setPageProperty(query, pageSize, pageNo);
		return query;
	}

	/**
	 * @Title: setPageProperty @Description: 往Query对象中设置分页参数 @param query 查询对象 @param
	 *         pageSize 一页的条数 @param pageNo 页数 @return Query @throws
	 */
	private Query setPageProperty(Query query, int pageSize, int pageNo) {
		if (pageNo != 0 && pageSize != 0) {
			query.setFirstResult((pageNo - 1) * pageSize);
			query.setMaxResults(pageSize);
		}
		return query;
	}

	/**
	 * @Title: getSQLQuery @Description: 获得SQL的查询器 @param sql SQL语句 @param map
	 *         参数 @return SQLQuery @throws
	 */
	private SQLQuery getSQLQuery(String sql, Map<String, Object> map) {
		SQLQuery query = this.createSQLQuery(sql);
		query = this.setParameter(query, map);
		return query;
	}

	/**
	 * @Title: createSQLQuery @Description: 通过SQL获得SQL的查询器 @param sql SQL语句 @return
	 *         SQLQuery @throws
	 */
	private SQLQuery createSQLQuery(String sql) {
		return getSession().createSQLQuery(sql);
	}

	/**
	 * @Title: setParameter @Description: 给查询器设置一些过滤参数 @param query 查询条件器 @param
	 *         map 参数 @return SQLQuery @throws
	 */
	private SQLQuery setParameter(SQLQuery query, Map<String, Object> map) {
		if (!CheckNull.isNull(map)) {
			for (Entry<String, Object> entry : map.entrySet()) {
				Object obj = entry.getValue();

				// 这里考虑传入的参数是什么类型，不同类型使用的方法不同
				if (obj instanceof Collection) {
					query.setParameterList(entry.getKey(), (Collection<E>) obj);
				} else if (obj instanceof Object[]) {
					query.setParameterList(entry.getKey(), (Object[]) obj);
				} else {
					query.setParameter(entry.getKey(), obj);
				}
			}
		}
		return query;
	}

	/**
	 * @Title: getSQLQuery @Description: 通过SQL，过滤条件，分页来获得SQL查询器 @param sql SQL语句 @param
	 *         map 过滤条件 @param pageSize 一页条数 @param pageNo 页数 @return SQLQuery @throws
	 */
	private SQLQuery getSQLQuery(String sql, Map<String, Object> map, int pageSize, int pageNo) {
		// 首选通过SQL语句来创建SQL查询器
		SQLQuery query = this.createSQLQuery(sql);

		// 给SQL查询器来设置过滤条件
		query = this.setParameter(query, map);

		// 给SQL查询器来设置分页条件
		query = this.setPageProperty(query, pageSize, pageNo);
		return query;
	}

	/**
	 * @Title: setPageProperty @Description: 分页来获得查询数据 @param query SQL查询器 @param
	 *         pageSize 一页条数 @param pageNo 页数 @return SQLQuery @throws
	 */
	private SQLQuery setPageProperty(SQLQuery query, int pageSize, int pageNo) {
		if (pageNo != 0 && pageSize != 0) {
			query.setFirstResult((pageNo - 1) * pageSize);
			query.setMaxResults(pageSize);
		}
		return query;
	}

	/**
	 * @Title: createPaging @Description: 条件查询-分页 @param criteria 条件 @param
	 *         pageSize 一页条数 @param pageNo 页数 @return Criteria @throws
	 */
	private Criteria createPaging(Criteria criteria, int pageSize, int pageNo) {
		if (pageSize != 0 && pageNo != 0) {
			criteria.setFirstResult((pageNo - 1) * pageSize);
			criteria.setMaxResults(pageSize);
		}
		return criteria;
	}

	/**
	 * 创建条件查询对象
	 */
	private Criteria createCriteria(Class<E> objClass) {
		return getSession().createCriteria(objClass);
	}

	/**
	 * @Title: createCriteriaExpressionEq @Description: 设置HQL的查询条件 @param
	 *         criteria 条件器 @param proMap 条件 @return Criteria @throws
	 */
	private Criteria createCriteriaExpressionEq(Criteria criteria, Map<String, Object> proMap) {
		if (!CheckNull.isNull(proMap)) {
			for (Entry<String, Object> entry : proMap.entrySet()) {
				criteria.add(Restrictions.eq(entry.getKey(), entry.getValue()));
			}
		}
		return criteria;
	}

	/**
	 * 通过HQL来统计条数
	 *
	 * @param hql
	 *            HQL语句
	 * @return
	 */
	public Long getCountByHql(String hql) {
		return getCountByHql(hql, null, 0, 0);
	}

	/**
	 * 通过SQL来统计条数
	 *
	 * @param sql
	 *            SQL语句
	 * @return
	 */
	public Long getCountBySql(String sql) {
		return getCountBySql(sql, null, 0, 0);
	}

	/**
	 * findByHql 执行hql分页查询
	 *
	 * @param hql
	 *            HQL语句
	 * @param pageSize
	 *            一页条数
	 * @param pageNo
	 *            页数
	 * @return
	 */
	public List<?> findByHql(String hql, int pageSize, int pageNo) {
		return findByHql(hql, null, pageSize, pageNo);
	}

	/**
	 * findBySql 执行sql分页查询
	 *
	 * @param sql
	 *            SQL语句
	 * @param pageSize
	 *            一页的条数
	 * @param pageNo
	 *            页数
	 * @return
	 */
	public List<?> findBySql(String sql, int pageSize, int pageNo) {
		return findBySql(sql, null, pageSize, pageNo);
	}

	/**
	 * <p>
	 * 方法重载(后加)
	 * <p>
	 *
	 * @param sql
	 * @param pageSize
	 * @param pageNo
	 * @param clazz
	 * @return 封装好的结果集
	 */
	public List<?> findBySql(String sql, int pageSize, int pageNo, Class clazz) {
		/*List<Object[]> list = (List<Object[]>) findBySql(sql, null, pageSize, pageNo);
		String[] parameter = packageParameter(clazz);
		List resultList = BeanHelper.transformTuple(list, clazz, parameter);
		return resultList;
*/
		return this.getSQLQuery(sql, null, pageSize, pageNo).addEntity(clazz).list();

	}

	public List<?> findBySql(String sql, Map<String,Object> param,int pageSize, int pageNo, Class clazz) {
		return this.getSQLQuery(sql, param, pageSize, pageNo).addEntity(clazz).list();
	}

	/**
	 * @Title: queryPage @Description:分页工具方法 @param sb @param pu @return
	 *         PageObjectLogicBean @throws
	 */
	public List<?> queryPageSql(String sb, PageObject po) {
		// 获得查询后的记录数
		po.setSum(this.getCountBySql(sb).intValue());

		if (null != po && !CheckNull.isNullOrZero(po.getOnePageSize())) {
			int sumPage = po.getSum() / po.getOnePageSize();
			if (po.getSum() % po.getOnePageSize() != 0) {
				sumPage += 1;
			}
			return this.findBySql(sb, po.getOnePageSize(), po.getCurrPage());
		} else {
			return this.findBySql(sb, 0, 0);
		}
	}

	public void queryPageHql(String sb, PageObject po) {
		// 返回对象

		// 获得查询后的记录数
		po.setSum(this.getCountByHql(sb).intValue());

		if (null != po && !CheckNull.isNullOrZero(po.getOnePageSize())) {
			int sumPage = po.getSum() / po.getOnePageSize();
			if (po.getSum() % po.getOnePageSize() != 0) {
				sumPage += 1;
			}

			po.setPageList(this.findByHql(sb, po.getOnePageSize(), po.getCurrPage()));
		} else {
			po.setPageList(this.findByHql(sb, 0, 0));
		}
	}

	public List<E> list(final String hql, final Object... paramlist) {
		Query query = getSession().createQuery(hql);
		query.setCacheable(true);
		query.setCacheRegion("SpringCache");
		// query.setCacheRegion("myCacheRegion");//指定要使用的cacheRegion，可选
		setParameters(query, paramlist);
		List<E> results = query.list();
		return results;
	}
	@SuppressWarnings("unchecked")
	protected <T> List<T> list(final String hql, List<Integer> ids) {
		Query query = getSession().createQuery(hql);
		query.setCacheable(true);
		query.setParameterList("ids", ids);
		List<T> results = query.list();
		return results;
	}
	public List<?> list2(final String hql, final Object... paramlist) {
		Query query = getSession().createQuery(hql);
		query.setCacheable(true);
		query.setCacheRegion("SpringCache");
		setParameters(query, paramlist);
		List<?> results = query.list();
		return results;
	}

	protected List<E> pageList(final String hql, final int pn, final int pageSize, final Object... paramlist) {
		Query query = getSession().createQuery(hql);
		query.setCacheable(true);
		query.setCacheRegion("SpringCache");// query.setCacheRegion("myCacheRegion");//指定要使用的cacheRegion，可选
		setParameters(query, paramlist);
		query = this.setPageProperty(query, pageSize, pn);
		List<E> results = query.list();
		return results;
	}

	public List<E> listAll() {
		return list(HQL_LIST_ALL);
	}

	/**
	 * <p>
	 * 执行hql
	 * </p>
	 *
	 * @author Lennon.Wang
	 * @date 2016-11-29 上午09:41:43
	 * @param hql
	 * @return
	 */
	protected int execte(final String hql) {
		Query query = getSession().createQuery(hql);
		query.setCacheable(true);
		Object result = query.executeUpdate();
		return result == null ? 0 : ((Integer) result).intValue();
	}

	/**
	 * <p>
	 * 执行hql
	 * </p>
	 *
	 * @author Lennon.Wang
	 * @date 2016-11-29 上午09:42:05
	 * @param hql
	 * @param paramlist
	 * @return
	 */
	protected int execte(final String hql, final Object... paramlist) {
		Query query = getSession().createQuery(hql);
		query.setCacheable(true);
		setParameters(query, paramlist);
		Object result = query.executeUpdate();
		return result == null ? 0 : ((Integer) result).intValue();
	}

	/**
	 * <p>
	 * 执行sql
	 * </p>
	 *
	 * @author Lennon.Wang
	 * @date 2016-11-29 上午09:42:10
	 * @param sql
	 * @return
	 */
	protected int execteSql(final String sql) {
		Query query = getSession().createSQLQuery(sql);
		query.setCacheable(true);
		Object result = query.executeUpdate();
		return result == null ? 0 : ((Integer) result).intValue();
	}

	/**
	 * <p>
	 * 执行sql
	 * </p>
	 *
	 * @author Lennon.Wang
	 * @date 2016-11-29 上午09:42:18
	 * @param sql
	 * @param paramlist
	 * @return
	 */
	protected int execteSql(final String sql, final Object... paramlist) {
		Query query = getSession().createSQLQuery(sql);
		query.setCacheable(true);
		setParameters(query, paramlist);
		Object result = query.executeUpdate();
		return result == null ? 0 : ((Integer) result).intValue();
	}

	/**
	 * <p>
	 * 执行参数封装(后加)
	 * <p>
	 *
	 * @date 2017-1-19 下午14:30:26
	 * @param clazz
	 * @return 封装好的String[]
	 *
	 */
	protected String[] packageParameter(Class clazz) {
		List<String> list = new ArrayList<String>();
		list.clear();
		String[] parameters = null;
		Field[] fields = null;
		try {
			// 实例化对象
			Object object = clazz.newInstance();
			// 获得所有属性名的数组
			fields = object.getClass().getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				String name = fields[i].getName();
				list.add(name);
			}
			parameters = (String[]) list.toArray(new String[0]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return parameters;
	}

	protected List<E> listSelf(final String hql, final int pn, final int pageSize, final Object... paramlist) {
		return this.list(hql, pn, pageSize, paramlist);
	}

	public void setParameters(Query query, Map<String, Object> param) {
		query.setCacheable(true);
		for (Entry<String, Object> entry : param.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
	}

	public int executeByHql(final String hql, Map<String, Object> param) {
		Query query = getSession().createQuery(hql);
		query.setCacheable(true);
		setParameter(query, param);
		Object result = query.executeUpdate();
		return result == null ? 0 : ((Integer) result).intValue();
	}
}