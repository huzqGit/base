package com.common.exception;

public class CreateException extends Exception {
  public CreateException(String msg) {
    super(msg);
  }

  public CreateException(String msg, Throwable e){
    super(msg,e);
  }
}
