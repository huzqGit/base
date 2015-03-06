package com.common.bean;

import java.util.Collection;
import java.util.List;

public abstract class EntityHierarchy<T1, T extends EntityHierarchy> extends BaseEntity<T1> {
  public abstract void addChild(T child);
  
  public abstract T getParent();

  public abstract List<T> getChildren();
  
  public abstract void addAll(Collection<T> children);
  
  public String toTreeNodeString() {
  	return "";
  }
}