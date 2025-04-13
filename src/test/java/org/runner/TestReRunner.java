package org.runner;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "@src\\test\\resources\\Reports\\failure\\failure.txt", 
glue = "org.stepdefinitions")
public class TestReRunner {

}
