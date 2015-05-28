package com.common.exception;

public class JSPNotFoundException extends Exception {

private static final long serialVersionUID = 7034504343812519637L;

public JSPNotFoundException(String msg) {
    super(msg);
  }

  public JSPNotFoundException(String msg, Throwable e) {
    super(msg, e);
  }
}
