package org.stepdefinitions;

import org.pom.PatientAttachmentPOM;
import org.testng.Assert;
import org.utils.Baseclass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class PatientAttachmentPage extends Baseclass{
	PatientAttachmentPOM patientAttach;
	@Given("The user navigates back to the patient details page")
	public void the_user_navigates_back_to_the_patient_details_page() {
		patientAttach = new PatientAttachmentPOM();
		clickEvent(patientAttach.getEndVisit());
		clickEvent(patientAttach.getYesButton());
	}

	@Then("The uploaded attachment should be visible in the attachment section")
	public void the_uploaded_attachment_should_be_visible_in_the_attachment_section() {
		getText(patientAttach.getImageName());
		String path = captureScreenshot("Patient Home Checked");
		Hooks.test.info("Screenshot for Patient home page").addScreenCaptureFromPath(path);
	}

	@Then("A recent visit with today's date and tag {string} should be listed")
	public void a_recent_visit_with_today_s_date_and_tag_should_be_listed(String attachedContent) {
		String actualText = getText(patientAttach.getAttachmentTag());
		Assert.assertEquals(actualText, attachedContent, "verfied content");
	}
}