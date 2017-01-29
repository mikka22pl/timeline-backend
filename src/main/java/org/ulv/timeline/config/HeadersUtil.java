package org.ulv.timeline.config;

import org.springframework.http.HttpHeaders;

public class HeadersUtil {
	public static final HttpHeaders HEADERS = new HttpHeaders();
	static {
		HEADERS.add("Content-Type", "application/json; charset=utf-8");
	}
}
