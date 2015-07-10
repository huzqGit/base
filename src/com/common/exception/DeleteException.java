package com.common.exception;

public class DeleteException extends Exception {
  public DeleteException(String msg) {
    super(msg) ;
  }

  public DeleteException(String msg, Throwable ex) {
    super(msg,ex) ;
  }
}
