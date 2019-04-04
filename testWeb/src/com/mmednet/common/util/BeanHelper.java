package com.mmednet.common.util;

import com.mmednet.robot.utils.CheckNull;
import org.apache.log4j.Logger;
import org.hibernate.transform.AliasToBeanResultTransformer;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 实体转换类
 * </p>
 * 
 * @author Lennon.Wang
 * @version 1.0
 * @date 2015-8-25
 * @since JDK 1.7
 * @copyright Copyright 2015 CLOUD SERVICES.
 */
public class BeanHelper<T extends java.io.Serializable> {

	private static final Logger logger = Logger.getLogger(BeanHelper.class);

	/**
	 * 将hibernate中执行的HQL语句返回的结果封装到自定义的javabean中 保证javabean中的属性名与HQL中返回的列名保持一致
	 * 
	 * @param list
	 *            hibernateHQL语句的返回结果
	 * @param resultType
	 *            自定义的javabean的class
	 * @param parameters
	 *            返回的试题对象字段参数
	 * @return List数据
	 */
	public static List transformTuple(List list, Class resultType, String[] parameters) {
		List list2 = new ArrayList();
		if (list == null || list.size() == 0){
			return list2;
		}

		if (parameters == null || parameters.length == 0){
			return list2;
		}

		AliasToBeanResultTransformer at = new AliasToBeanResultTransformer(resultType);
		for (int i = 0; i < list.size(); i++) {
			Object[] o = null;
			if (parameters.length > 1) {
				o = (Object[]) list.get(i);
			} else {
				o = new Object[] { list.get(i) };
			}
			Object obj = at.transformTuple(o, parameters);
			list2.add(obj);
			
		}
		return list2;
	}

	/**
	 * 单个对象转换
	 * 
	 * @param o
	 *            Object数组
	 * @param resultType
	 *            类型
	 * @param parameters
	 *            参数
	 * @return 转换后的对象
	 */
	public static Object transformTuple(Object[] o, Class resultType, String[] parameters) {
		AliasToBeanResultTransformer at = new AliasToBeanResultTransformer(resultType);
		Object obj = at.transformTuple(o, parameters);
		return obj;
	}

	/**
	 * 将目标对象中属性值的属性从来源目标中拷贝过来
	 * 
	 * @param from
	 *            来的对象
	 * @param to
	 *            到什么对象
	 * @throws IllegalArgumentException
	 *             不合法或不正确的参数异常
	 * @throws IllegalAccessException
	 *             反射异常
	 * @throws InvocationTargetException
	 *             调用方法或构造方法所抛出异常
	 */
	public static void copyProperties(Object from, Object to) {
		if (CheckNull.isNull(from)) {
			return;
		}
		Class fromclazz = from.getClass();
		try {
			Method[] frommethods = fromclazz.getDeclaredMethods();
			for (Method method1 : frommethods) {
				String name = method1.getName();
				String type = name.substring(0, 3);
				name = name.substring(3, name.length());
				if ("get".equals(type)) {
					getFieldValue(to, name, method1.invoke(from, null));

				}
			}
		} catch (Exception e) {
			logger.error("COPY CLASS:" + fromclazz.getName() + "," + e);
			e.printStackTrace();
		}

	}

	public void copyPropertiesList(List<T> fromlist, List<T> tolist, Class resultType) throws IllegalArgumentException,
			IllegalAccessException, InvocationTargetException, InstantiationException {
		if (fromlist == null || tolist == null || fromlist.size() == 0) {
			return;
		}
		Class fromclazz = fromlist.get(0).getClass();
		Method[] frommethods = fromclazz.getMethods();
		for (int i = 0; i < fromlist.size(); i++) {
			Object to = resultType.newInstance();
			for (Method method1 : frommethods) {
				String name = method1.getName();
				String type = name.substring(0, 3);
				name = name.substring(3, name.length());
				if ("get".equals(type)) {
					getFieldValue(to, name, method1.invoke(fromlist.get(i), null));
				}
			}
			tolist.add((T) to);
		}

	}

	/**
	 * 将目标对象中属性值的属性从来源目标中拷贝过来
	 * 
	 * @param from
	 *            来的对象
	 * @param to
	 *            到什么对象
	 * @throws IllegalArgumentException
	 *             不合法或不正确的参数异常
	 * @throws IllegalAccessException
	 *             反射异常
	 * @throws InvocationTargetException
	 *             调用方法或构造方法所抛出异常
	 */
	public static void copyPropertiesAll(Object from, Object to) throws IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {
		Class fromclazz = from.getClass();
		Method[] frommethods = fromclazz.getMethods();
		for (Method method1 : frommethods) {
			String name = method1.getName();
			String type = name.substring(0, 3);
			name = name.substring(3, name.length());
			if ("get".equals(type)) {
				getFieldValue(to, name, method1.invoke(from, null));

			}
		}

	}

	/**
	 * 获得Field值
	 * 
	 * @param aObject
	 *            对象
	 * @param aFieldName
	 *            字段名
	 * @param object
	 *            对象
	 */
	public static void getFieldValue(Object aObject, String aFieldName, Object object) {
		Field field = getClassField(aObject.getClass(), aFieldName);// get the
		// field in
		// this
		// object
		if (field != null) {
			field.setAccessible(true);
			try {
				field.set(aObject, object);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 获得Class中字段名的字段属性
	 * 
	 * @param aClazz
	 *            类
	 * @param aFieldName
	 *            字段名
	 * @return 字段属性
	 */
	private static Field getClassField(Class aClazz, String aFieldName) {
		Field[] declaredFields = aClazz.getDeclaredFields();
		for (Field field : declaredFields) {
			// 注意：这里判断的方式，是用字符串的比较。
			if (field.getName().toLowerCase().equals(aFieldName.toLowerCase())) {
				return field;// define in this class
			}
		}

		Class superclass = aClazz.getSuperclass();
		if (superclass != null) {// 简单的递归一下
			return getClassField(superclass, aFieldName);
		}
		return null;
	}

}