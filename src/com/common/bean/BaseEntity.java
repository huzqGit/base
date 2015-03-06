package com.common.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public abstract class BaseEntity<T> implements java.io.Serializable {

  public T id;

  public T getId() {
    return id;
  }

  public void setId(T id) {
    this.id = id;
  }

  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof BaseEntity))
      return false;

    BaseEntity that = (BaseEntity) o;
    if (this.getId() != null && that.getId() != null) {
      return new EqualsBuilder().append(this.getId(), that.getId()).isEquals();
    }
    return equalsIfIdNull(o);
  }

  public int hashCode() {
    if (this.getId() != null) {
      return new HashCodeBuilder().append(getId()).toHashCode();
    } else {
      return hashCodeIfIdNull();
    }
  }

  public String toString() {
  	if (this.getId() != null) {
  		return new ToStringBuilder(this).append("id", getId()).toString();
  	}
  	else {
  		return toStringIfIdNull();
  	}
  }

  public abstract boolean equalsIfIdNull(Object o);

  public abstract int hashCodeIfIdNull();
  
  public String toStringIfIdNull() {
  	return "";
  }

}