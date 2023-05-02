package com.Utility;

public class CreateUrl {

	public static String baseUrl="https://api.github.com";

	public static String getBaseUrl() {
		return baseUrl;
	}

	public static String getBaseUrl(String resource) {
		return baseUrl+resource;
	}
	
}
