package org.stepdefinitions;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.utils.Baseclass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends Baseclass {

	public static ExtentReports extent;

	public static ExtentTest test;

	@Before
	public void beforeScenario(Scenario scenario) throws IOException {
		startReport();
		test = extent.createTest(scenario.getName());
		
	}

	@After
	public void afterScenario(Scenario scenario) {
		String screenshotPath = captureScreenshot(scenario.getName());

		if (scenario.isFailed()) {
			test.log(Status.FAIL, "Scenario Failed");
			if (screenshotPath != null) {
				test.addScreenCaptureFromPath(screenshotPath);
			}
		} else {
			test.log(Status.PASS, "Scenario Passed");
			if (screenshotPath != null) {
				test.addScreenCaptureFromPath(screenshotPath);
			}
		}
		extent.flush();
	}

	

	public void startReport() {
		if (extent == null) {
			String timestamp = new SimpleDateFormat("dMMMyyyy").format(new Date());
			String reportPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Reports\\Extents\\OpenMRS_ExtentReport_"
					+ timestamp + ".html";
			ExtentSparkReporter htmlReport = new ExtentSparkReporter(reportPath);
			htmlReport.config().setDocumentTitle("OpenMRS Automation Report");
			htmlReport.config().setReportName("Dhanasekar D");
			extent = new ExtentReports();
			extent.attachReporter(htmlReport);
		}
	}

	
	
	

}
