package com.flights.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.flights.modelclasses.Destination;
import com.flights.modelclasses.DestinationFlightList;
import com.flights.modelclasses.DestinationFlightResults;
import com.flights.modelclasses.Destinations;
import com.flights.modelclasses.Flight;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestRouter extends Base {

	public static Response getAllFlightsDepartsFromSchipol() {
		request = getRequestObject();
		request.queryParam("flightDirection", "D");
		request.queryParam("includedelays", "false");
		response = request.get("/flights");
		Assert.assertEquals(response.getStatusCode(), 200);
		return response;
	}

	public static ArrayList<DestinationFlightResults> extractDepartureFlightDetailsWithDepartTmeAndIATA() {
		response = RequestRouter.getAllFlightsDepartsFromSchipol();

		DestinationFlightList destFlights = response.getBody().as(DestinationFlightList.class);
		List<Flight> flights = destFlights.getFlights();
		ArrayList<DestinationFlightResults> flightResults = new ArrayList<DestinationFlightResults>();

		for (Flight flight : flights) {
			DestinationFlightResults flightRecord = new DestinationFlightResults();
			flightRecord.setFlightNumber(flight.getFlightNumber());
			flightRecord.setFlightName(flight.getFlightName());
			flightRecord.setIataMain(flight.getAircraftType().getIataMain());
			flightRecord.setScheduleTime(flight.getScheduleTime());
			flightRecord.setDestinations(flight.getRoute().getDestinations());
			flightResults.add(flightRecord);
		}
		return flightResults;
	}

	public static Response authenticateUser(String appKey) {
		RestAssured.baseURI = BASE_URI;
		request = RestAssured.given();
		Map<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Accept", APPLICATION_JSON);
		headerMap.put("app_id", APPID);
		headerMap.put("app_key", appKey);
		headerMap.put("ResourceVersion", VERSION);
		request.headers(headerMap);
		response = request.get("/flights");
		// Assert.assertEquals(response.getStatusCode(), 200);
		return response;
	}

	public static Response getCountryAndCitiesAsDestShipol() {
		request = getRequestObject();
		request.queryParam("sort", "country");
		request.queryParam("page", "10");
		response = request.get("/destinations");
		Assert.assertEquals(response.getStatusCode(), 200);
		return response;
	}

	public static void sortAllDestinationsByCountry(Response response) {
		Destinations allDestinations = response.getBody().as(Destinations.class);
		List<Destination> destinations = allDestinations.getDestinations();
		for (Destination destination : destinations) {
			logger.info(destination.country + "-------" + destination.city);
		}
	}

	public static void getIataAndCityForCountry(Response response, String country) {
		Destinations allDestinations = response.getBody().as(Destinations.class);
		List<Destination> destinations = allDestinations.getDestinations();
		for (Destination destination : destinations) {
			if (destination.getCountry() != null && destination.getCountry().equalsIgnoreCase(country))
				logger.info(destination.getIata() + "-------" + destination.getCity());
		}
	}

	public static boolean isResultsContrainCityAndCountry(Response response, String city, String country) {
		Destinations allDestinations = response.getBody().as(Destinations.class);
		List<Destination> destinations = allDestinations.getDestinations();
		for (Destination destination : destinations) {
			if (destination.getCity() == null || destination.getCountry() == null)
				continue;
			if ((destination.getCity().contains(city) && destination.getCountry().contains(country)))
				return true;
		}
		return false;
	}

	public static void printIataAndDestinationCode() {
		// Extract the required details from FlightsResults Set
		ArrayList<DestinationFlightResults> flightDetails = RequestRouter
				.extractDepartureFlightDetailsWithDepartTmeAndIATA();

		// Printing Flight Number, IATA Code, Depart Schedule Time, Destination
		Iterator<DestinationFlightResults> itr = flightDetails.iterator();
		while (itr.hasNext()) {
			DestinationFlightResults results = (DestinationFlightResults) itr.next();
			logger.info(results.getFlightNumber() + "--" + results.getIataMain() + "--" + results.getScheduleTime()
					+ "-----" + results.getDestinations());
		}
	}

	public static boolean isResultsContrainNullValuesForIataOrDestnation(Response response) {
		ArrayList<DestinationFlightResults> flightDetails = RequestRouter
				.extractDepartureFlightDetailsWithDepartTmeAndIATA();
		// Assert for each flight is it has IATA
		Iterator<DestinationFlightResults> itr = flightDetails.iterator();
		while (itr.hasNext()) {
			DestinationFlightResults flight = (DestinationFlightResults) itr.next();
			logger.info(
					"===IATA=" + flight.getIataMain() + "===Destinations length=" + flight.getDestinations().size());
			if (flight.getIataMain() == null || flight.getIataMain().equals("") || flight.getDestinations().isEmpty())
				return true;
		}
		return false;
	}

	public static void printResponse(Response response) {
		// response = getCountryAndCitiesAsDestShipol();
		String jsonString = response.asPrettyString();
		logger.info(response.getStatusCode());
		logger.info("Respons String: " + jsonString);
	}

	public static String getNextPageLink(Response response) {
		String links = response.getHeader("link");
		StringTokenizer linkTokens = new StringTokenizer(links, ",");

		while (linkTokens.hasMoreTokens()) {
			String linkToken = linkTokens.nextToken();
			if (linkToken.contains("rel=\"next\"")) {
				String[] linkmsg = linkToken.split(";");
				return linkmsg[0].toString().trim();
			}
		}
		return "";
	}

}
