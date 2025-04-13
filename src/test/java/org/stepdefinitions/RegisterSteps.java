package org.stepdefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.pom.RegisterPOM;
import org.testng.Assert;
import org.utils.Baseclass;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterSteps extends Baseclass {
	RegisterPOM register;

	@When("The user click on Register a patient")
	public void the_user_click_on_register_a_patient() {
		register = new RegisterPOM();
	}

	@When("The user has fill to following details")
	public void the_user_has_fill_to_following_details(io.cucumber.datatable.DataTable datas) {
		Map<String, String> dataMap = datas.asMap(String.class, String.class);
		for (Map.Entry<String, String> entry : dataMap.entrySet()) {
			String field = entry.getKey().toLowerCase();
			String value = entry.getValue();

			switch (field) {
			case "givenname":
				sendKeys(register.getGivenName(), value);
				break;
			case "middlename":
				sendKeys(register.getMiddleName(), value);
				break;
			case "familyname":
				sendKeys(register.getFamilyName(), value);
				String path = captureScreenshot("Demographics Details");
				Hooks.test.info("Screenshot for Name page").addScreenCaptureFromPath(path);
				clickEvent(register.getNextButton());
				break;
			case "gender":
				selectClass(register.getSelectGender(), value);
				String genderinfo = captureScreenshot("gender Details");
				Hooks.test.info("Screenshot for Gender page").addScreenCaptureFromPath(genderinfo);
				clickEvent(register.getNextButton());
				break;
			case "birthday":
				sendKeys(register.getBirthdateDay(), value);
				break;
			case "birthmonth":
				selectClass(register.getSelectMonth(), value);
				break;
			case "birthyear":
				sendKeys(register.getBirthdateYear(), value);
				String birthdaypath = captureScreenshot("birth Details");
				Hooks.test.info("Screenshot for Birth page").addScreenCaptureFromPath(birthdaypath);
				clickEvent(register.getNextButton());
				break;
			case "address":
				sendKeys(register.getAddress1(), value);
				break;
			case "address2":
				sendKeys(register.getAddress2(), value);
				break;
			case "city":
				sendKeys(register.getCityVillage(), value);
				break;
			case "state":
				sendKeys(register.getStateProvince(), value);
				break;
			case "country":
				sendKeys(register.getCountry(), value);
				break;
			case "post":
				sendKeys(register.getPostalCode(), value);
				String infoPath = captureScreenshot("contact Info");
				Hooks.test.info("Screenshot for contact page").addScreenCaptureFromPath(infoPath);
				clickEvent(register.getNextButton());
				break;
			case "phone":
				sendKeys(register.getPhoneNumber(), value);
				String phonePath = captureScreenshot("phone Info");
				Hooks.test.info("Screenshot for phone page").addScreenCaptureFromPath(phonePath);
				clickEvent(register.getNextButton());
				break;
			case "relationshiptype":
				selectClass(register.getSelectRelationshipType(), value);
				break;
			case "personname":
				sendKeys(register.getPatientName(), value);
				String relationalPath = captureScreenshot("Relational Info");
				Hooks.test.info("Screenshot for Relational page").addScreenCaptureFromPath(relationalPath);
				clickEvent(register.getNextButton());
				break;
			}

		}

	}

	@Then("The user should see the confrim page with the entered patient details")
	public void the_user_should_see_the_confrim_page_with_the_entered_patient_details(
			io.cucumber.datatable.DataTable datas) {
		List<WebElement> confrimResult = register.getConfrimResult();
		Map<String, String> dataMap = datas.asMap(String.class, String.class);
		boolean isFlag = false;
		for (WebElement element : confrimResult) {
			String text = element.getText();
			if (text.startsWith("Gender:")) {
				Assert.assertTrue(text.contains(dataMap.get("gender")), "Valid Data");
				isFlag = true;
			}
		}

		if (isFlag) {
			clickEvent(register.getConfrimButton());
			String alertPath = captureScreenshot("Alert Info");
			Hooks.test.info("Screenshot for Alert page").addScreenCaptureFromPath(alertPath);
		}

	}
}
