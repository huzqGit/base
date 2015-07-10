package com.common.exception;

public class DataNotFoundException extends Exception{
  public DataNotFoundException(String msg) {
    super(msg);
  }

  public DataNotFoundException(String msg, Throwable e){
    super(msg,e);
  }
}
