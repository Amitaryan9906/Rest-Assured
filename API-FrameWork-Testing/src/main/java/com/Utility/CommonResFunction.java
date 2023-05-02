package com.Utility;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CommonResFunction {
	
	public static JsonPath jsonpath;
	
	public static String getResponseBody(String responseBody,String responseKey) {
		jsonpath = new JsonPath(responseBody);
		return jsonpath.get(responseKey);
	}
	public static int getStatusCode(Response res) {
		int statusCode=res.getStatusCode();
		return statusCode;
	}
}
