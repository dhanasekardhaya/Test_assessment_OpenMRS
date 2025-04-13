package org.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", 
				dryRun = false, 
				glue = "org.stepdefinitions", 
				plugin = {"pretty", 
						"html:src\\test\\resources\\Reports\\html\\testreport.html",
						"json:src\\test\\resources\\Reports\\JSON\\reports.json",
						"junit:src\\test\\resources\\Reports\\XML\\reports.xml",
						"rerun:src\\test\\resources\\Reports\\failure\\failure.txt" }, 
				monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {

}
