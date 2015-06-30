package com.common.filter.security.vo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class VOConverter {

	private VOConverter() {

	}

	/**
	 * 得到指定对象的所有属性的值
	 * 
	 * @param object
	 * 
	 * @return
	 */
	public static Map getFieldsAndValues(Object object) {
		Class objectClass = object.getClass();
		Map objectMap = new HashMap();
		Field field = null;
		try {
			Field[] fields = objectClass.getDeclaredFields();
			// logger.print("分析： 类" + objectClass);

			for (int i = 0; i < fields.length; i++) {
				field = fields[i];
				if (field.getModifiers() < 10) {
					// logger.print("前" + field.getName());
					Method method = objectClass.getMethod(
						getGetFieldValue(field.getName()), new Class[] {});
					// logger.print("后" +field.getName());
					// 这里基本类型会被包成对象
					Object value = method.invoke(object, new Object[] {});

					objectMap.put(field.getName(), value);
				}

			}
		} catch (Exception e) {
			throw new RuntimeException("分析值对象错误！" + "类名：" + object.getClass()
				+ "属性名 ：\"" + field.getName() + "\" \n 错误消息：" + e.getMessage(),
				e);
		}

		return objectMap;
	}


	/**
	 * 说明：从VO中得到Map
	 * 
	 * @param vo
	 * @return
	 */
	public static Map getVOToMap(Object vo) {
		Map objectMap = new HashMap();
		try {
			Class objectClass = vo.getClass();
			Field[] fields = objectClass.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				Field field = fields[i];
				System.out.println("field:" + field.getName());
				Method method = objectClass.getMethod(getGetFieldValue(field
					.getName()), new Class[] {});

				Object value = method.invoke(vo, new Object[] {});
				objectMap.put(field.getName(), value);
			}
		} catch (Exception e) {
			throw new RuntimeException("分析值对象错误！" + "类名：" + vo.getClass(), e);
		}
		return objectMap;
	}
	
	/**
	 * 得到指定对象的所有属性的值, 当isSetNull为true时,属性值为null设为NullField对象
	 * 
	 * @param object
	 * @param isSetNull
	 * @return
	 */
	public static Map getFieldsAndValues(Object object, boolean isSetNull) {
		Class objectClass = object.getClass();
		Map objectMap = new HashMap();

		Field field = null;
		try {
			Field[] fields = objectClass.getDeclaredFields();

			// logger.print("分析： 类" + objectClass);

			for (int i = 0; i < fields.length; i++) {
				field = fields[i];
				if (field.getModifiers() < 10) {
					// logger.print("前" + field.getName());
					Method method = objectClass.getMethod(
						getGetFieldValue(field.getName()), new Class[] {});
					// logger.print("后" +field.getName());
					// 这里基本类型会被包成对象
					Object value = method.invoke(object, new Object[] {});
					objectMap.put(field.getName(), value);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("分析值对象错误！" + "类名：" + object.getClass()
				+ "属性名 ：\"" + field.getName() + "\" \n 错误消息：" + e.getMessage(),
				e);
		}

		return objectMap;
	}

	/**
	 * 得到指定对象的所有属性的值(过滤掉ignoreFieldNames字段),
	 * 
	 * @param object
	 * @param ignoreFieldNames
	 * @param isSetNull
	 * @return
	 */
	public static Map getFieldsAndValues(Object object,
		String[] ignoreFieldNames, boolean isSetNull) {
		Class objectClass = object.getClass();
		Map objectMap = new HashMap();
		Map ignoreFieldNameMap = new HashMap();
		for (int i = 0; i < ignoreFieldNames.length; i++) {
			ignoreFieldNameMap.put(ignoreFieldNames[i], null);
		}

		Field field = null;
		try {
			Field[] fields = objectClass.getDeclaredFields();

			// logger.print("分析： 类" + objectClass);

			for (int i = 0; i < fields.length; i++) {
				field = fields[i];
				if (field.getModifiers() < 10) {
					if (!ignoreFieldNameMap.containsKey(field.getName())) {

						// logger.print("前" + field.getName());
						Method method = objectClass.getMethod(
							getGetFieldValue(field.getName()), new Class[] {});
						// logger.print("后" +field.getName());
						// 这里基本类型会被包成对象

						Object value = method.invoke(object, new Object[] {});

						objectMap.put(field.getName(), value);

					}
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("分析值对象错误！" + "类名：" + object.getClass()
				+ "属性名 ：\"" + field.getName() + "\" \n 错误消息：" + e.getMessage(),
				e);
		}

		return objectMap;
	}

	/**
	 * 得到指定类的所有申明的属性名
	 * 
	 * @param objectClass
	 *            对象的类型
	 * @return 指定类的所有申明的属性名数组
	 */
	public static String[] getFieldNames(Class objectClass) {
		// String[] fieldNames = null;
		List fieldNames = new ArrayList();

		try {
			Field[] fields = objectClass.getDeclaredFields();

			for (int i = 0; i < fields.length; i++) {
				fieldNames.add(fields[i].getName());
			}
		} catch (Exception e) {
			throw new RuntimeException("分析值对象错误！" + "类名：" + objectClass
				+ e.getMessage());
		}

		objectClass = objectClass.getSuperclass();

		return (String[]) fieldNames.toArray(new String[fieldNames.size()]);
	}

	/**
	 * 得到指定类的属性类型信息
	 * 
	 * @param objectClass
	 *            对象的类型
	 * @return key:属性名 value:属性类型 (java.lang.Integer等等 ：（ 不好)
	 */
	public static Map getFieldTypes(Class objectClass, String[] ignoreFieldNames) {
		Map typeMap = new HashMap();
		Map ignoreFieldNameMap = new HashMap();
		for (int i = 0; i < ignoreFieldNames.length; i++) {
			ignoreFieldNameMap.put(ignoreFieldNames[i], null);
		}

		try {
			Field[] fields = objectClass.getDeclaredFields();

			for (int i = 0; i < fields.length; i++) {
				if (!ignoreFieldNameMap.containsKey(fields[i].getName())) {
					typeMap.put(fields[i].getName(), fields[i].getType()
						.getName());
				}

			}
		} catch (Exception e) {

			throw new RuntimeException("分析值对象错误！" + "类名：" + objectClass + "错误消息："
				+ e.getMessage(), e);
		}

		return typeMap;
	}

	/**
	 * 得到指定类的属性类型信息
	 * 
	 * @param objectClass
	 *            对象的类型
	 * @return key:属性名 value:属性类型 (java.lang.Integer等等 ：（ 不好)
	 */
	public static Map getFieldTypes(Class objectClass) {
		Map typeMap = new HashMap();

		try {
			Field[] fields = objectClass.getDeclaredFields();

			for (int i = 0; i < fields.length; i++) {
				typeMap.put(fields[i].getName(), fields[i].getType().getName());

			}
		} catch (Exception e) {

			throw new RuntimeException("分析值对象错误！" + "类名：" + objectClass + "错误消息："
				+ e.getMessage(), e);
		}

		return typeMap;
	}

	/**
	 * 得到指定类的属性类型信息
	 * 
	 * @param objectClass
	 *            对象的类型
	 * @return key:属性名 value:属性类型 Class
	 */
	public static Map getFieldClassTypes(Class objectClass) {
		Map typeMap = new HashMap();

		try {
			Field[] fields = objectClass.getDeclaredFields();

			for (int i = 0; i < fields.length; i++) {
				typeMap.put(fields[i].getName(), fields[i].getType());

			}
		} catch (Exception e) {

			throw new RuntimeException("分析值对象错误！" + "类名：" + objectClass + "错误消息："
				+ e.getMessage(), e);
		}

		return typeMap;
	}

	/**
	 * 得到指定类的指定属性的类型
	 * 
	 * @param objectClass
	 *            类
	 * @param fieldName
	 *            属性名
	 * @return 属性类型 (java.lang.Integer等等 ：（ 不好)
	 */
	public static String getFieldType(Class objectClass, String fieldName) {
		String fieldType = null;

		Field field = null;
		Class tempClass = objectClass;

		// ************************ :(
		label: {
			Field[] fields = tempClass.getDeclaredFields();

			for (int i = 0; i < fields.length; i++) {
				Field f = fields[i];
				if (fieldName.equals(f.getName())) {
					field = f;
					break label;
				}
			}
		}

		try {
			if (field != null)
				fieldType = field.getType().getName();
			else
				throw new RuntimeException("类： " + objectClass + " 不存在属性："
					+ fieldName);

		} catch (Exception e) {

			throw new RuntimeException("分析值对象错误！" + "类：" + objectClass + " 中不存在属性:"
				+ fieldName + "\n错误消息：" + e.getMessage(), e);

		}
		return fieldType;
	}

	/**
	 * 得到指定对象指点属性的值
	 * 
	 * @param object
	 *            指定对象
	 * @param fieldName
	 *            指定属性名
	 * @return 指定属性的值
	 */
	public static Object getFieldValue(Object object, String fieldName) {
		Class objectClass = object.getClass();
		Object fieldValue = null;
		try {
			Method method = objectClass.getMethod(getGetFieldValue(fieldName),
				new Class[] {});
			fieldValue = method.invoke(object, new Object[] {});

		} catch (Exception e) {

			throw new RuntimeException("分析值对象错误！" + "对象：" + object.toString()
				+ "错误消息：" + e.getMessage(), e);
		}

		return fieldValue;
	}

	/**
	 * 设置指定对象指定属性的值
	 * 
	 * @param object
	 *            指定对象
	 * @param fieldName
	 *            指定属性
	 * @param fieldValue
	 *            指定属性的值
	 * @return 把赋值后的对象返回
	 */
	public static Object setFieldValue(Object object, String fieldName,
		Object fieldValue) {
		Class objectClass = object.getClass();
		try {
			if (fieldValue != null) {
				Method method = objectClass.getMethod(
					getSetFieldValue(fieldName), new Class[] { fieldValue
						.getClass() });
				method.invoke(object, new Object[] { fieldValue });
			}

		} catch (Exception e) {

			throw new RuntimeException("分析值对象错误！" + "对象：" + object.toString()
				+ "错误消息：" + e.getMessage(), e);
		}

		return object;
	}

	/**
	 * 创建指定类型的对象
	 * 
	 * @param objectClass
	 *            指定类型
	 * @param objectValues
	 *            指定的值 key :属性名 value：属性值
	 * @return 指定类型的对象，其中值为指定的值
	 */
	// public static Object createObject(Class objectClass, Map objectValues) {
	// Object object = null;
	// List fieldNames = new ArrayList();
	//
	// Class tempClass = objectClass;
	// Field[] fields = tempClass.getDeclaredFields();
	//
	// for (int i = 0; i < fields.length; i++) {
	// Field field = fields[i];
	// fieldNames.add(field.getName());
	// }
	//
	// String fieldName = ""; // 为了显示出来
	// try {
	// object = objectClass.newInstance();
	//
	// for (Iterator it = fieldNames.iterator(); it.hasNext();) {
	// fieldName = (String) it.next();
	//
	// Object value = objectValues.get(fieldName);
	// if (value != null) {
	// Method method = objectClass.getMethod(
	// getSetFieldValue(fieldName), new Class[] { value
	// .getClass() });
	//
	// method.invoke(object, new Object[] { value });
	// }
	// }
	// } catch (Exception e) {
	// throw new RuntimeException("分析值对象错误！" + "类名：" + objectClass + "属性名："
	// + fieldName + "\n错误消息：" + e.getMessage(), e);
	// }
	//
	// return object;
	// }
	public static Object createObject(Class objectClass, Map objectValues) {
		Object object = null;
		List fieldNames = new ArrayList();

		Class tempClass = objectClass;
		Field[] fields = tempClass.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			fieldNames.add(field.getName());
		}
		String fieldName = ""; // 为了显示出来
		try {
			object = objectClass.newInstance();

			for (Iterator it = fieldNames.iterator(); it.hasNext();) {
				fieldName = (String) it.next();

				Object value = objectValues.get(fieldName);
				if (value != null) {
					Field field = tempClass.getDeclaredField(fieldName);
					Method method = objectClass.getMethod(
						getSetFieldValue(fieldName), new Class[] { field
							.getType() });
					Object value1 = null;
					if (value instanceof Cloneable) {
						if (value instanceof ValueObject) {
							value1 = ((ValueObject) value).clone();
						} else if (value instanceof List) {
							value1 = cloneList((List) value);
						} else if (value instanceof Map) {
							value1 = cloneMap((Map) value);
						}
					}
					if (value1 == null)
						method.invoke(object, new Object[] { value });
					else
						method.invoke(object, new Object[] { value1 });
				}

			}
		} catch (Exception e) {
			throw new RuntimeException("分析值对象错误！" + "类名：" + objectClass + "属性名："
				+ fieldName + "\n错误消息：" + e.getMessage(), e);
		}

		return object;
	}

	public static List cloneList(List objectList) {
		if (objectList == null) {
			return null;
		}
		List newList = new ArrayList();
		for (int i = 0; i < objectList.size(); i++) {
			Object object = objectList.get(i);
			if (object == null) {
				newList.add(null);
			} else {
				if (object instanceof Cloneable) {
					if (object instanceof ValueObject) {
						object = ((ValueObject) object).clone();
					} else if (object instanceof Object[]) {
						object = ((Object[]) object).clone();
					} else {
						throw new RuntimeException("不支持此clone对象:"
							+ object.getClass().getName());
					}
				} else if (object instanceof List) {
					object = cloneList((List) object);
				} else if (object instanceof Map) {
					object = cloneMap((Map) object);
				}
				newList.add(object);
			}

		}
		return newList;
	}

	public static Map cloneMap(Map objectMap) {
		if (objectMap == null) {
			return null;
		}
		Map newMap = new HashMap();
		for (Iterator iter = objectMap.entrySet().iterator(); iter.hasNext();) {
			Map.Entry entry = (Map.Entry) iter.next();
			Object object = entry.getValue();
			Object key = entry.getKey();
			if (object instanceof Cloneable) {
				if (object instanceof ValueObject) {
					object = ((ValueObject) object).clone();
				} else if (object instanceof Object[]) {
					object = ((Object[]) object).clone();
				} else {
					throw new RuntimeException("不支持此clone对象:"
						+ object.getClass().getName());
				}
			} else if (object instanceof List) {
				object = cloneList((List) object);
			} else if (object instanceof Map) {
				object = cloneMap((Map) object);
			}
			newMap.put(key, object);
		}
		return newMap;

	}

	/**
	 * 打印指定对象的属性
	 * 
	 * @param vo
	 *            指定对象
	 */
	public static void printVO(Object vo) {
		java.util.Iterator it = getFieldsAndValues(vo).entrySet().iterator();

		Map.Entry en = null;
		while (it.hasNext()) {
			en = (Map.Entry) it.next();
			System.out.println("属性名：" + en.getKey() + " 属性值: " + en.getValue());
		}
	}

	private static String getSetFieldValue(String fieldName) {
		return "set" + Character.toUpperCase(fieldName.charAt(0))
			+ fieldName.substring(1);
	}

	private static String getGetFieldValue(String fieldName) {
		return "get" + Character.toUpperCase(fieldName.charAt(0))
			+ fieldName.substring(1);
	}
}
