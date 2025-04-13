package org.stepdefinitions;

import org.pom.DashboardPOM;
import org.testng.Assert;
import org.utils.Baseclass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DashboardSteps extends Baseclass {

	DashboardPOM dashboardpage;

	@Given("The user is on the dashboard page")
	public void the_user_is_on_the_dashboard_page() {
		dashboardpage = new DashboardPOM();
		String text = getText(dashboardpage.getLoginName());
		if(text.contains(userName)) {
			Assert.assertTrue(true, "UserName is verfied");
		}else {
			Assert.assertTrue(false, "Mismatched userName");
		}
		Hooks.test.info("Dashboard UserName passed");
	}

	@When("The user click the register a patient button")
	public void the_user_click_the_register_a_patient_button() {
	clickEvent(dashboardpage.getRegisterPatientClick());
	}

	@Then("The user should be taken to the Register Patient page")
	public void the_user_should_be_taken_to_the_register_patient_page() {
		Assert.assertTrue(webdriverWaitURL("registerPatient", 10));
		Hooks.test.info("Verfied the Register Patient page based on url String");
	}
}
