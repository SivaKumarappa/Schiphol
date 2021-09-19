package com.flights.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
        glue = {"com/flights/stepdefinitions"},
        plugin = { "pretty", 
        		"html:target/htmlreports/cucumber-reports.html",
        		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        		"json:target/jsonreports/cucumber.json",
        		},
        monochrome = true
)
public class TestRunner {
}
