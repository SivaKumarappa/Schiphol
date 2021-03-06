
Technologies used: 
------------------
Maven as a build tool with mavensure/maven-config plugins
Cucumber - for Test case preparation (features, Stepdefinitions and TestRunner)
Restassured using JAVA(16.0.2) for API automation testing
TestNG for Assertions/running the tests using testng.xml suite
Eclipse IDE for development.

Steps to execute:
-----------------
Pre-requis: Maven/Java need to be installed on local PC, for running the code/test
1. Clone the project using https://github.com/SivaKumarappa/Schiphol.git
2. go to downloaded Project root folder, make sure once you cd into that folder you can see pom.xml file
3. Give commond: mvn install verify
4. It will /install/compile/test the code and generates the reports(HTML/JSON/CUCUMBER). 
5. To see test results/reports - Goto ( {project-root}/target/cucumber-reports/maven_cucumber_reports/cucumber-html-reports/) and pick overview-steps.html. It will show all the steps, and we can see a grafical view when you click on Features tab on top left. 
Configured EXTENTREPORT too, but they are not generating the reports, looks like a misconfigure issue, becuase of time constraint I didn't spend much time to fix it.

Framework Flow:
===============
com.flights.runner - This package will have all the runner classer. Cucumber starts execting runners from here.

com.flights.stepdefinitions - It will contains the definitions for all the steps which we declared/wrote in the cucumber feature files( All the feature files we are keeping it in src/test/resources)

com.flights.api : This package contains Base and RequestRouter related classes.

com.flights.modelclasses : It contains all the pojo(model) classes for the response objects, we will store all the response objects in these classes so that the retrieval will be easy.

Additional INFO:
----------------
1. I have implemented based on single page response for each API.
2. All the APIs are having pagination concept, I found the way to take a nextlink from each response. But I haven't implemented that. I might be needed little more time to do so, I couldnot able to complete all in 2 days. Apologies for that.
3. I know, am implemented only the basic scenarios, but we can implement many more positive and negative API test cases as well. 
4. Regarding the Assertions and Code review I should have implemented a lot, but I couln't able to spend much time.
