package com.common.exception;

public class UpdateException extends Exception {
  public UpdateException(String msg) {
    super(msg);
  }

  public UpdateException(String msg, Throwable e){
    super(msg,e);
  }
}
