package org.stepdefinitions;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import org.pom.PatientagePOM;
import org.testng.Assert;
import org.utils.Baseclass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PatientageSteps extends Baseclass{
	
	PatientagePOM patientAgePage;
	int actualAge, exceptAge = 0;
	@Given("The user should be in Patient details page")
	public void the_user_should_be_in_patient_details_page() {
		patientAgePage = new PatientagePOM();
		
	}

	@When("The user should be correctly calculated based on data of birth {string}")
	public void the_user_should_be_correctly_calculated_based_on_data_of_birth(String ageFormated) {
		String waitToastText = waitToastText();
		jsElementHighlighted(waitToastpath());
		Assert.assertEquals(waitToastText, "Created Patient Record: Dhana Sekar Honey", "Toast Text is invalid");
		
		boolean waitToastTextInvisible = waitToastTextInvisible();
		if(waitToastTextInvisible) {
			String ageText = getText(patientAgePage.getAgeCalcualted());
			String[] split = ageText.split(" ");
			actualAge = Integer.parseInt(split[0]);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy");
			LocalDate dob = LocalDate.parse(ageFormated, formatter);
			LocalDate currentDate = LocalDate.now();
			exceptAge = Period.between(dob, currentDate).getYears();
		}
		
	}

	@Then("validate the given input and output are matches")
	public void validate_the_given_input_and_output_are_matches() {
		jsElementHighlighted(patientAgePage.getAgeCalcualted());
		Hooks.test.info("Verified Age Checked");
		Assert.assertEquals(actualAge, exceptAge, "Age is not correctly calculate");
	}
}
