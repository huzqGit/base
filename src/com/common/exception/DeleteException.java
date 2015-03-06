package com.common.exception;

/**
 * <p>Title: KM modular</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Pouchen group</p>
 * @author allan
 * @version 1.0
 */
public class DeleteException extends Exception {
  public DeleteException(String msg) {
    super(msg) ;
  }

  public DeleteException(String msg, Throwable ex) {
    super(msg,ex) ;
  }
}
