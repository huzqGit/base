package com.common.exception;

public class CommitException extends Exception {
  public CommitException(String msg) {
    super(msg);
  }

  public CommitException(String msg, Throwable e) {
    super(msg, e);
  }
}
