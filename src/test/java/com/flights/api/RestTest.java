package com.flights.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParser;
import com.flights.modelclasses.Destination;
import com.flights.modelclasses.DestinationFlightList;
import com.flights.modelclasses.DestinationFlightResults;
import com.flights.modelclasses.Flight;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyData;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class RestTest {
	
	public String APPLICATION_JSON = "application/json";
	public String APPID = "02f3c458";
	public String APPKEY = "99d69d44190cecb00a70827d031e9265";
	public String INVALID_APPKEY = "INVALID99d69d44190cecb00a70827d031e9265";
	public String VERSION = "v4";
	public String BASE_URI = "https://api.schiphol.nl/public-flights";
	public String FLIGHT_URI = "https://api.schiphol.nl/public-flights/flights";
	public String DESTINATIONS_URL = "https://api.schiphol.nl/public-flights/destinations";
	
	//@Test
	public void getAllCountryCities() {
		Response response = RequestRouter.getAllFlightsDepartsFromSchipol();
		/*
		 * String jsonString = response.asPrettyString();
		 * System.out.println(response.getStatusCode());
		 * System.out.println("Respons String: "+jsonString);
		 */

		String jsonString = response.asPrettyString();
		System.out.println("Respons String: "+jsonString);
		
		DestinationFlightList flights = response.getBody().as(DestinationFlightList.class);
		//JsonPath jsonEvaluator = response.jsonPath();
		//List<DestinationFlightList> flights = jsonEvaluator.getList("flights", DestinationFlightList.class);
		List<Flight> flats = flights.getFlights();
		ArrayList<DestinationFlightResults> flightResults = new ArrayList<DestinationFlightResults>();
		int i=0;
		System.out.println("===========================================");
		for(Flight flight: flats) {
			System.out.println(flight.getFlightName()+"--"+ flight.getAircraftType().getIataMain() +"--"+ flight.getScheduleTime()+"-----"+flight.getRoute().getDestinations().get(0));
			DestinationFlightResults flightRecord= new DestinationFlightResults();
			flightRecord.setFlightNumber(flight.getFlightNumber());
			flightRecord.setFlightName(flight.getFlightName());
			flightRecord.setIataMain(flight.getAircraftType().getIataMain());
			flightRecord.setScheduleTime(flight.getScheduleTime());
			flightRecord.setDestinations(flight.getRoute().getDestinations());
			flightResults.add(flightRecord);
		}
		System.out.println("===========================================");
		
	}
	
	@Test
	public void getAllFlightsLeavingFromSchipol() {
		//Response response = APIBase.getAllFlightsDepartsFromSchipol();
		//APIBase.extractDepartureFlightDetailsWithDepartTmeAndIATA();
		
		RestAssured.baseURI = BASE_URI;
		RequestSpecification request = RestAssured.given();
		request.headers(RequestRouter.getHeaders());
		request.queryParam("sort", "country");
		request.queryParam("page", "10");

		Response response = request.get("/destinations");
		Assert.assertEquals(response.getStatusCode(), 200);
		
		String links = response.getHeader("link");
		StringTokenizer linkTokens = new StringTokenizer(links, ",");
		 
		while (linkTokens.hasMoreTokens())
		{
		    String linkToken= linkTokens.nextToken();
		    if (linkToken.contains("rel=\"next\"")) {
		    	String[] linkmsg = linkToken.split(";");
		    	System.out.println("Next link is:"+linkmsg[0].toString().trim());
		    }
		    	
			//System.out.println("1: "+linkToken);
		}
		
	}
	
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
	
	//@Test
	public void getAllCountryCitiesFromSchiphol() {
		// https://api.schiphol.nl/public-flights/destinations?sort=%2Bcountry
		//RestAssured.baseURI = DESTINATIONS_URL; 
		
		RestAssured.baseURI = BASE_URI;
		Map<String, Object> headerMap = new HashMap<String, Object>();
		headerMap.put("Accept", APPLICATION_JSON);
		headerMap.put("app_id", APPID);
		headerMap.put("app_key", APPKEY);
		headerMap.put("ResourceVersion", VERSION );
	
		RequestSpecification request = RestAssured.given();
		request.headers(headerMap);
		request.queryParam("sort", "country");
		
		
		Response response = request.get("/destinations");
		//response.asPrettyString();
		String jsonString = response.asPrettyString();
		System.out.println(response.getStatusCode());
		System.out.println("Respons String: "+jsonString);
		
		JsonPath jsonEvaluator = response.jsonPath();
		List<Destination> destinations = jsonEvaluator.getList("destinations", Destination.class);
		
		System.out.println("===========================================");
		for(Destination destination: destinations) {
			System.out.println(destination.country +"-------"+destination.city);
		}
		System.out.println("===========================================");

		
		/*
		 * List<HashMap> countries=response.jsonPath().getList("destinations"); for(Map
		 * country: countries) System.out.println(country);
		 * 
		 * response.jsonPath().getJsonObject("destinations");
		 */
		
		/*
		 * List<Map.Entry<String, String>> list1 = new List<Map.Entry<String,
		 * String>>(); Map.Entry<String, Integer> entry = new
		 * AbstractMap.SimpleEntry<String, Integer>("key", 1);
		 */
	}
	
	
	//  DONE  4. Attempting a call to API with an invalid API key – and validating the response_Code/line.
	//@Test
	public void testAPIWithInValidAppKey() {
		Response response = given()
		.header("Accept","application/json")
		.header("app_id","02f3c458")
		.header("app_key",INVALID_APPKEY)
		.header("ResourceVersion","v4")
		.when()
		.get("https://api.schiphol.nl/public-flights/flights")
		.then().extract().response();
		
		Assert.assertEquals(response.getStatusCode(), 403);
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 403 Forbidden");
	}
	
}
