package org.stepdefinitions;

import org.pom.DeletePOM;
import org.testng.Assert;
import org.utils.Baseclass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeletePage extends Baseclass{
	
	DeletePOM deletePage;
	
	public String getId;
	
	@Given("the user clicks on Delete Patient")
	public void the_user_clicks_on_delete_patient() {
		deletePage = new DeletePOM();
	}
	@Given("the user enters the reason for deletion as {string}")
	public void the_user_enters_the_reason_for_deletion_as(String uesrText) throws InterruptedException {
		getId = getText(deletePage.getGetId());
	    clickEvent(deletePage.getDeleteLink());
	    sendKeys(deletePage.getDeleteText(), uesrText);
	}
	@Given("the user clicks on the Confirm button")
	public void the_user_clicks_on_the_confirm_button() {
	    clickEvent(deletePage.getConfirmButton());
	}
	@Then("a toaster message should appear confirming the deletion")
	public void a_toaster_message_should_appear_confirming_the_deletion() {
		String toastText = waitToastText();
		jsElementHighlighted(waitToastpath());
		String path = captureScreenshot("Toasted Text for deleted");
		Hooks.test.info("Deleted UserName").addScreenCaptureFromPath(path);
		Assert.assertEquals(toastText, "Patient has been deleted successfully", "Invalid texted");
		
	}
	@When("the user is redirected to the Find Patient Record page")
	public void the_user_is_redirected_to_the_find_patient_record_page() {
		waitLoader();
	   
	}
	@When("the user searches for the deleted patient using the patients {string}")
	public void the_user_searches_for_the_deleted_patient_using_the_patients(String userName) {
		sendKeys(deletePage.getSearchText(), userName);
		
	}
	@Then("the patient should not be listed in the search results")
	public void the_patient_should_not_be_listed_in_the_search_results() {
		boolean waitLoader = waitLoader();
		if(waitLoader) {
			boolean elementPresent1 = deletePresent();
			if(elementPresent1) {
				String deleteRecordText = getText(deletePage.getTableText());
				
				Assert.assertEquals(deleteRecordText, "No matching records found", "Invalid Message");
			}
			
		}
		
	}

}
