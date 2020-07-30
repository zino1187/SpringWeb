package com.dj.app.exception;

public class DMLException extends BusinessException{
	public DMLException(String msg) {
		super(msg);
	}
	public DMLException(Throwable e) {
		super(e);
	}
	public DMLException(String msg, Throwable e) {
		super(msg, e);
	}

}
