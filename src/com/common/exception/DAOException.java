package com.common.exception;

public class DAOException extends Exception {
  public DAOException(String msg) {
    super(msg);
  }

  public DAOException(String msg, Throwable e) {
    super(msg, e);
  }
}
