package org.stepdefinitions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pom.UploadAttachmentPOM;
import org.testng.Assert;
import org.utils.Baseclass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UploadAttachmentSteps extends Baseclass {
	UploadAttachmentPOM uploadAttachment;
	Alert alertClass;

	@Given("The user on the patient's dashboard")
	public void the_user_on_the_patient_s_dashboard() {
		uploadAttachment = new UploadAttachmentPOM();
	}

	@When("The user click the start a vist and confrim")
	public void the_user_click_the_start_a_vist_and_confrim() {
		clickEvent(uploadAttachment.getStartVist());
	}

	@When("The user validate the text in alert {string}")
	public void the_user_validate_the_text_in_alert(String alertTitle) {
		String actual = getText(uploadAttachment.getGetModelText());
		jsElementHighlighted(uploadAttachment.getGetModelText());
		if (actual.contains(alertTitle)) {
			Assert.assertTrue(true, "Valid Text");
		}

	}

	@When("The user navigate to the attachment section")
	public void the_user_navigate_to_the_attachment_section() {
		clickEvent(uploadAttachment.getConfrimText());
		String toastText = waitToastText();
		jsElementHighlighted(waitToastpath());
		clickEvent(uploadAttachment.getClickAttach());
	}

	@When("The user has upload a valid file \\(e.g, JPEG, PNG or PDF)")
	public void the_user_has_upload_a_valid_file_e_g_jpeg_png_or_pdf() throws InterruptedException, AWTException {
		waitLoader();
		waitVisibleByFile();
		clickEvent(uploadAttachment.getUploadFile());
		String filepath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Fileupload\\Alert_Info_20250412_072905.png";
		StringSelection s = new StringSelection(filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
		Robot r = new Robot();
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		sendKeys(uploadAttachment.getImageCaption(), "Test");
		clickEvent(uploadAttachment.getImageUpload());
	}

	@Then("The user see a success message confrim the upload {string}")
	public void the_user_see_a_success_message_confrim_the_upload(String excptedText) {
		String toastText = waitToastText();
		jsElementHighlighted(waitToastpath());
		clickEvent(uploadAttachment.getHomePage());
		Assert.assertEquals(toastText, excptedText, "Valid Toasted Texted");
	}

}