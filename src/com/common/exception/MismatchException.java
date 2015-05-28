package com.common.exception;

public class MismatchException extends RuntimeException {

	private static final long serialVersionUID = 2007739827689310018L;
	
	public MismatchException(String msg) {
	    super(msg) ;
	  }

	  public MismatchException(String msg, Throwable ex) {
	    super(msg,ex) ;
	  }

}
