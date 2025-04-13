package org.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class SuiteSetup extends Baseclass {
	@BeforeSuite
	public void beforeSuite() throws IOException {
		Properties propert = new Properties();
		FileReader propertReader = new FileReader(
				System.getProperty("user.dir") + "\\src\\test\\resources\\common\\config.properties");
		propert.load(propertReader);
		openBrowser(propert.getProperty("browserName"));
		urlLaunch(propert.getProperty("url"), 20);
		userName = propert.getProperty("userName");
	}

	@AfterSuite
	public void afterSuite() {
		driver.quit();
	}

}
