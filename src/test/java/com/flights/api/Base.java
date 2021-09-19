package com.flights.api;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Base {
	public static String BASE_URI = "https://api.schiphol.nl/public-flights";

	public static final String APPID = "02f3c458";
	public static final String APPKEY = "99d69d44190cecb00a70827d031e9265";
	public static final String INVALID_APPKEY = "INVALID99d69d44190cecb00a70827d031e9265";
	public static final String VERSION = "v4";
	public static final String APPLICATION_JSON = "application/json";
	public static Logger logger = LogManager.getLogger("ApiMessage");

	public static Response response;
	public static RequestSpecification request;

	public static Map<String, String> getHeaders() {
		Map<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Accept", APPLICATION_JSON);
		headerMap.put("app_id", APPID);
		headerMap.put("app_key", APPKEY);
		headerMap.put("ResourceVersion", VERSION);
		return headerMap;
	}

	public static RequestSpecification getRequestObject() {
		RestAssured.baseURI = BASE_URI;
		Map<String, String> headerMap = getHeaders();
		RequestSpecification request = RestAssured.given();
		request.headers(headerMap);
		return request;

	}

}
