package com.all.utils;

import java.util.StringTokenizer;

import io.restassured.response.Response;

public class FlightUtilities {
	public String getNextPageLink(Response response) {
		String links = response.getHeader("link");
		StringTokenizer linkTokens = new StringTokenizer(links, ",");
		 
		while (linkTokens.hasMoreTokens())
		{
		    String linkToken= linkTokens.nextToken();
		    if (linkToken.contains("rel=\"next\"")) {
		    	String[] linkmsg = linkToken.split(";");
		    	return linkmsg[0].toString().trim();
		    }
		}
		return "";
	}

}
