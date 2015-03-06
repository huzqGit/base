package com.common.exception;

/**
 * Exception for DAO.
 * <p>Title: KM modular</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Pouchen group</p>
 * @author Sand Chang
 * @version 1.0
 */

public class DataNotFoundException extends Exception{
  public DataNotFoundException(String msg) {
    super(msg);
  }

  public DataNotFoundException(String msg, Throwable e){
    super(msg,e);
  }
}
