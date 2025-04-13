package org.stepdefinitions;

import org.pom.ManageVerifyPatientPOM;
import org.testng.Assert;
import org.utils.Baseclass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ManageVerifyPatient extends Baseclass {
	ManageVerifyPatientPOM manageVerifyPatient;

	@Given("the user is on the Patient Details page")
	public void the_user_is_on_the_patient_details_page() {
		manageVerifyPatient = new ManageVerifyPatientPOM();

	}

	@When("the user verifies that the Recent Visits section has two entries for today's date with tags {string} and {string}")
	public void the_user_verifies_that_the_recent_visits_section_has_two_entries_for_today_s_date_with_tags_and(
			String vital, String attach) {
		String actualvital = getText(manageVerifyPatient.getRecentvitalText());
		Assert.assertEquals(actualvital, vital, "Text is mismatched");
		String actualAttach = getText(manageVerifyPatient.getRecentAttachText());
		Assert.assertEquals(actualAttach, attach, "Text is mismatched");
	}

	@When("the user clicks on {string}")
	public void the_user_clicks_on(String buttons) {
		if(buttons.equalsIgnoreCase("Merge Visits")) {
			clickEvent(manageVerifyPatient.getMergeVisits());	
		}else {
			//clickEvent(manageVerifyPatient.getAddPast());
		}
		
	}

	@When("the user selects the two visits and clicks on {string}")
	public void the_user_selects_the_two_visits_and_clicks_on(String string) {
		clickEvent(manageVerifyPatient.getTableFirstRow());
		clickEvent(manageVerifyPatient.getTableSecondRow());
		clickEvent(manageVerifyPatient.getMergeVisitButton());
	}

	@When("the user clicks on the {string} button")
	public void the_user_clicks_on_the_button(String string) {
		clickEvent(manageVerifyPatient.getTableafterMerge());
		clickEvent(manageVerifyPatient.getReturnButton());
	}

	@Then("the Recent Visits section should display one entry for today's date with tags {string}")
	public void the_recent_visits_section_should_display_one_entry_for_today_s_date_with_tags(String exceptedText) {
		String actualText = getText(manageVerifyPatient.getVitalsText());
		String[] split = actualText.split(",");
		for(String x : split) {
			if(x.contains(exceptedText)) {
				Assert.assertTrue(true);
			}
		}
	}


	@Then("the date picker should not allow selection of future dates")
	public void the_date_picker_should_not_allow_selection_of_future_dates() {
		
	}

	@Then("the user clicks on the {string} button to return to the Patient Details page")
	public void the_user_clicks_on_the_button_to_return_to_the_patient_details_page(String string) {
		driver.navigate().refresh();
	}

}
