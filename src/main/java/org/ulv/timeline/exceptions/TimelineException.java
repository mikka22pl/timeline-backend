package org.ulv.timeline.exceptions;

public class TimelineException extends Exception {

	private static final long serialVersionUID = -1868037833617109050L;

	public TimelineException(String msg) {
		super(msg);
	}
	
	public TimelineException(String msg, Throwable cause) {
		super(msg, cause);
	}
}