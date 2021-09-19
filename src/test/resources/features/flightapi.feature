Feature: End to End Testing for Flight APIs

Description: The purpose of these tests are to cover Flight_API functionalities

Scenario: To retrieve list of all countries as destination Schipol and sort them.
Given As am an authorized user
When I search for all countries and city combinations as destination Schipol
And Sort them by country in ascending order
Then verify results contains city "Sydney" and country "Australia"

Scenario: To retrieve list of IATA and City for country "Australia"
Given As am an authorized user
When I search for all countries and city combinations as destination Schipol
Then It should list out all IATA codes and destination city for country "Australia"

Scenario: Retrieve and validate IATA codes for flights leaving Schiphol today
Given As am an authorized user
When Access the API and retrieve data for all flights leaving Schiphol today
Then print the IATA code,destination and time of schedule departure
And Verify there is an IATA code for each flight

Scenario: Verify user access with INVALID key
Given As am an INVALID authorized user
When I access the API to retrieve data for all flights leaving Schiphol today
Then Access should be Forbidden