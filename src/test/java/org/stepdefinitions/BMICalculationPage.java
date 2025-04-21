package org.stepdefinitions;

import org.pom.BMICalculationPOM;
import org.testng.Assert;
import org.utils.Baseclass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BMICalculationPage extends Baseclass {

	BMICalculationPOM BMICalculation;

	@Given("The user starts a new visit")
	public void the_user_starts_a_new_visit() {
		BMICalculation = new BMICalculationPOM();
	}

	@Given("The user navigates to the Capture Vitals section")
	public void the_user_navigates_to_the_capture_vitals_section() throws InterruptedException {
		clickEvent(BMICalculation.getStartVisit());
		waitVisibleByDialog();
		clickEvent(BMICalculation.getConfrimButton());
		elementPresent();
		clickEvent(BMICalculation.getCaptureVitalsButton());
	}

	@Given("The user enters height as {string} cm and weight as {string} kg")
	public void the_user_enters_height_as_cm_and_weight_as_kg(String height, String weight) {
		sendKeys(BMICalculation.getHeight(), height);
		clickEvent(BMICalculation.getNextButton());
		sendKeys(BMICalculation.getWeight(), weight);
		clickEvent(BMICalculation.getNextButton());
	}

	@Then("The system should display the calculated BMI")
	public void the_system_should_display_the_calculated_bmi() {
		clickEvent(BMICalculation.getSaveForm());
	}

	@When("The user saves the vitals form")
	public void the_user_saves_the_vitals_form() {
		clickEvent(BMICalculation.getSaveButton());
	}

	@When("The user ends the visit")
	public void the_user_ends_the_visit() {
		clickEvent(BMICalculation.getEndVisit());
		clickEvent(BMICalculation.getYesButton());
	}

	@Then("The user should be redirected to the patient details page")
	public void the_user_should_be_redirected_to_the_patient_details_page() throws InterruptedException {
		driver.navigate().refresh();
		clickEvent(BMICalculation.getHomePage());
	}

	@Then("The patient details should display height as {string} cm, weight as {string} kg, and the correct BMI")
	public void the_patient_details_should_display_height_as_cm_weight_as_kg_and_the_correct_bmi(String exceptedHeight,
			String exceptedWeight) {
		String actualHeight = getText(BMICalculation.getHeightVerify());
		Assert.assertEquals(actualHeight, exceptedHeight, "Invalid height Data");
		String actualWeight = getText(BMICalculation.getWeightVerifiy());
		Assert.assertEquals(actualWeight, exceptedWeight, "Invalid Weight Data");
	}

}
