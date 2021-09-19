package com.flights.stepdefinitions;

import org.testng.Assert;
import com.flights.api.RequestRouter;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlightAPISteps extends RequestRouter {

	@Given("As am an authorized user")
	public void as_am_an_authorized_user() {
		response = RequestRouter.authenticateUser(APPKEY);
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@When("I search for all countries and city combinations as destination Schipol")
	public void i_search_for_all_countries_and_city_combinations_as_destination_Schipol() {
		response = RequestRouter.getCountryAndCitiesAsDestShipol();
		Assert.assertEquals(response.getStatusCode(), 200);
		RequestRouter.printResponse(response);
	}

	@When("Sort them by country in ascending order")
	public void sort_them_by_country_in_ascending_order() {
		Assert.assertEquals(response.getStatusCode(), 200);
		RequestRouter.sortAllDestinationsByCountry(response);
	}

	@Then("verify results contains city {string} and country {string}")
	public void verify_results_contains_city_and_country(String city, String country) {
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertTrue(RequestRouter.isResultsContrainCityAndCountry(response, city, country), "Verifying ");
	}
	
	@Then("It should list out all IATA codes and destination city for country {string}")
	public void it_should_list_out_all_iata_codes_and_destination_city_for_country(String country) {
		RequestRouter.getIataAndCityForCountry(response, country);

	}

	//   ********************  Step Defs for Flight departing today from Schipol
	@When("Access the API and retrieve data for all flights leaving Schiphol today")
	public void access_the_API_and_retrieve_data_for_all_flights_leaving_Schiphol_today() {
		response = RequestRouter.getAllFlightsDepartsFromSchipol();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Then("print the IATA code,destination and time of schedule departure")
	public void print_the_IATA_code_destination_and_time_of_schedule_departure() {
		RequestRouter.printIataAndDestinationCode();
	}

	@Then("Verify there is an IATA code for each flight")
	public void verify_there_is_an_IATA_code_for_each_flight() {
		Assert.assertFalse(RequestRouter.isResultsContrainNullValuesForIataOrDestnation(response), "Verifying is any Flight doesn't contain IATA/Destination values.");
	}
	
	//   ******************  Step Defs for INVALID USER   ***************
	@Given("As am an INVALID authorized user")
	public void as_am_an_INVALID_authorized_user() {
		System.out.println("As part of API GET call we send INVALID KEY");
	}

	@When("I access the API to retrieve data for all flights leaving Schiphol today")
	public void i_access_the_API_to_retrieve_data_for_all_flights_leaving_Schiphol_today() {
		response = RequestRouter.authenticateUser(INVALID_APPKEY);
		Assert.assertEquals(response.getStatusCode(), 403);
	}

	@Then("Access should be Forbidden")
	public void access_should_be_Forbidden() {
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 403 Forbidden");
	}


}
