package com.common.bean;

import java.io.Serializable;
import java.lang.reflect.Field;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseCompositePK implements Serializable {
	private static final Logger log = LoggerFactory.getLogger(BaseCompositePK.class);
	private Field fields[]; 
	
	public BaseCompositePK() { 
		fields = this.getClass().getDeclaredFields();
	}

	public boolean equals(Object o) {
		log.info("eq");
		if (this == o)
			return true;
		if (!(o instanceof BaseCompositePK))
			return false;

		BaseCompositePK that = (BaseCompositePK) o;
		EqualsBuilder eb = new EqualsBuilder();
		for (Field field : fields) {
			String name = field.getName();
			eb.append(name, getPropertyValue(name));
		}
		log.info("eq end");
		return eb.isEquals(); 
	}

	public int hashCode() {
		log.info("hash");
		HashCodeBuilder hb = new HashCodeBuilder();
		for (Field field : fields) {
			String name = field.getName();
			hb.append(getPropertyValue(name));
		}
		log.info("hash end");
		return hb.toHashCode();
	}

	public String toString() {
		log.info("toString...");
		ToStringBuilder ts = new ToStringBuilder(this);
		for (Field field : fields) {
			log.info(field.getName());
			String name = field.getName();
			ts.append(name, getPropertyValue(name));
		}
		log.info("toString...end");
		return ts.toString();
	}

	private Object getPropertyValue(String name) {
		try {
			return PropertyUtils.getProperty(this, name);
		} catch (Exception e) {
			log.error(
							"Get {} property from class {} occurs error! Pls check the access modifier level of this property to be public",
							new Object[] { name, this.getClass().getName() });
		}
		return null;
	}
}