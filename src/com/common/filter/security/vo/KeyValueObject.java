package com.common.filter.security.vo;

public class KeyValueObject<T1, T2> extends ValueObject {
	private T1 key;
	private T2 value;

	public KeyValueObject() {

	}

	public KeyValueObject(T1 key) {
		this.key = key;
	}
	
	public KeyValueObject(T1 key, T2 value) {
		this.key = key;
		this.value = value;
	}
	
	public T1 getKey() {
		return key;
	}

	public void setKey(T1 key) {
		this.key = key;
	}

	public T2 getValue() {
		return value;
	}

	public void setValue(T2 value) {
		this.value = value;
	}

	public String toString() {
		return (value == null) ? "null": value.toString();
	}
}
