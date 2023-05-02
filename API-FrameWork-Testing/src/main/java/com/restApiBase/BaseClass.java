package com.restApiBase;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {	

	 public static Response GetRequest(String requesturi) {
		 RequestSpecification requestSpecification = RestAssured.given();
		 requestSpecification.contentType (ContentType.JSON);
		 Response response = requestSpecification.get(requesturi);
		 return response;

	 }
    
	 public static Response PostRequest(String requesturi, String requestpayLoad) { 
		 RequestSpecification requestSpecification = RestAssured.given().body (requestpayLoad); 
		 requestSpecification.contentType (ContentType.JSON);
		 Response response = requestSpecification.post(requesturi); 
		 return response;

	 }

	 public static Response PostRequest(String requesturi, String requestpayLoad, String bearer_token) {
		 RequestSpecification requestSpecification = RestAssured.given().body (requestpayLoad); 
	 requestSpecification.contentType (ContentType.JSON);
	 requestSpecification.header("Authorization", "Bearer "+bearer_token); Response response = requestSpecification.post(requesturi);
	 return response;

	 }
	
public static Response PutRequest(String requesturi, String requestpayLoad) { 
	RequestSpecification requestSpecification = RestAssured.given().body (requestpayLoad); 
	requestSpecification.contentType (ContentType.JSON); 
	Response response = requestSpecification.put(requesturi); 
	return response;

}

public static Response DeleteRequest(String requesturi) {
	RequestSpecification requestSpecification =RestAssured.given(); 
	requestSpecification.contentType (ContentType.JSON); 
	Response response = requestSpecification.delete(requesturi); 
	return response;

} 

public static Response DeleteRequestwithpayLoad(String requesturi, String requestpayLoad) {
	RequestSpecification requestSpecification = RestAssured.given().body(requestpayLoad); 
	requestSpecification.contentType (ContentType.JSON);
	Response response = requestSpecification.delete(requesturi); 
	return response;
}
public static Response DeleteRequest(String requesturi, String bearer_token) { 
	RequestSpecification requestSpecification= RestAssured.given(); 
	requestSpecification.contentType (ContentType.JSON); 
	requestSpecification.header("Authorization", "Bearer "+bearer_token);
	Response response = requestSpecification.delete(requesturi); 
	return response;
}
}
