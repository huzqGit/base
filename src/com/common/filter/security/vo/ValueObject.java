package com.common.filter.security.vo;

import java.util.Iterator;
import java.util.Map;



public abstract class ValueObject implements java.io.Serializable, Cloneable {
	public Object clone() {
		return VOConverter.createObject(this.getClass(), VOConverter
			.getFieldsAndValues(this));
	}
	/**
	 * 有equeals()方法
	 * 
	 * @param other
	 * @return
	 */
	public boolean equeals(ValueObject other) {
		if (other == null)
			return false;

		if (!super.equals(other))
			return false;

		if (this.getClass() != other.getClass())
			return false;

		String[] fields = VOConverter.getFieldNames(this.getClass());
		Map thisValues = VOConverter.getFieldsAndValues(this);
		Map otherValues = VOConverter.getFieldsAndValues(other);

		return equals(thisValues, otherValues);
	}
	
	private static boolean equals(Map ma, Map mb) {
		Object thisField = null;
		Object otherField = null;
		if (ma == null || mb == null)
			return false;

		if (ma.size() != mb.size())
			return false;

		Map.Entry entry = null;
		for (Iterator it = ma.entrySet().iterator(); it.hasNext();) {
			entry = (Map.Entry) it.next();

			thisField = entry.getValue();
			otherField = mb.get(entry.getKey());

			if (!(thisField == null && otherField == null)) {
				if (thisField == null || otherField == null)
					return false;

				if (!thisField.equals(otherField))
					return false;
			}
		}

		return true;
	}
	
	/**
	 * 输出值对象中所有属性以及对应值。
	 * 
	 * @return
	 */
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("值对象 ");
		buf.append(this.getClass().getName());
		buf.append(" ");
		buf.append(this.hashCode());
		buf.append(" 值 :\n ( ");

		Map thisValues = VOConverter.getFieldsAndValues(this);
		Map.Entry entry = null;
		for (Iterator it = thisValues.entrySet().iterator(); it.hasNext();) {
			entry = (Map.Entry) it.next();
			buf.append(entry.getKey());
			buf.append(" : ");
			buf.append(entry.getValue());
			buf.append("   ");
		}

		buf.append(" ) ");
		return buf.toString();

	}
}
