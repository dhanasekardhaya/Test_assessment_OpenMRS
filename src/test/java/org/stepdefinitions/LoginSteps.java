package org.stepdefinitions;

import org.pom.LoginPOM;
import org.testng.Assert;
import org.utils.Baseclass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends Baseclass{
	
	LoginPOM login;
	
	@Given("The user should be in login page")
	public void the_user_should_be_in_login_page() {
	    login = new LoginPOM();
	    String path = captureScreenshot("Login Home Checked");
		Hooks.test.info("Screenshot for login home page").addScreenCaptureFromPath(path);
	}
	@When("The user has to fill the username {string} and password {string}")
	public void the_user_has_to_fill_the_username_and_password(String userName, String password) {
		sendKeys(login.getUserName(), userName);
		sendKeys(login.getPassword(), password);
	}
	@When("The user select a location and click the login button")
	public void the_user_select_a_location_and_click_the_login_button() {
		clickEvent(login.getLocation());
		clickEvent(login.getLoginButton());
	}
	@Then("The user should be redirected the dashboard page")
	public void the_user_should_be_redirected_the_dashboard_page() {
		Assert.assertTrue(webdriverWaitURL("home", 10));
		Hooks.test.info("Dashboard redirection passed");
	}
}
