package org.pom;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utils.Baseclass;

public class RegisterPOM extends Baseclass {

	public RegisterPOM() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "givenName")
	private WebElement givenName;

	@FindBy(name = "middleName")
	private WebElement middleName;

	@FindBy(name = "familyName")
	private WebElement familyName;

	@FindBy(id = "next-button")
	private WebElement nextButton;

	@FindBy(name = "gender")
	private WebElement selectGender;

	@FindBy(name = "birthdateDay")
	private WebElement birthdateDay;

	@FindBy(name = "birthdateMonth")
	private WebElement selectMonth;

	@FindBy(name = "birthdateYear")
	private WebElement birthdateYear;

	@FindBy(id = "address1")
	private WebElement address1;

	@FindBy(id = "address2")
	private WebElement address2;

	@FindBy(id = "cityVillage")
	private WebElement cityVillage;

	@FindBy(id = "stateProvince")
	private WebElement stateProvince;

	@FindBy(id = "country")
	private WebElement country;

	@FindBy(id = "postalCode")
	private WebElement postalCode;

	@FindBy(name = "phoneNumber")
	private WebElement phoneNumber;
	
	@FindBy(name = "relationship_type")
	private WebElement selectRelationshipType;
	
	@FindBy(xpath="//p[@class='left']//input[contains(@placeholder, 'Person')]")
	private WebElement patientName;
	
	@FindBy(xpath="//ul[@id='formBreadcrumb']//li[contains(@class, 'focused')]")
	private WebElement waitText;
	
	@FindBy(xpath="//div[@id='dataCanvas']//p")
	private List<WebElement> confrimResult;

	public List<WebElement> getConfrimResult() {
		return confrimResult;
	}
	
	@FindBy(id="submit")
	private WebElement confrimButton;

	public WebElement getConfrimButton() {
		return confrimButton;
	}

	public WebElement getWaitText() {
		return waitText;
	}

	public WebElement getSelectGender() {
		return selectGender;
	}

	public WebElement getBirthdateDay() {
		return birthdateDay;
	}

	public WebElement getSelectMonth() {
		return selectMonth;
	}

	public WebElement getBirthdateYear() {
		return birthdateYear;
	}

	public WebElement getAddress1() {
		return address1;
	}

	public WebElement getAddress2() {
		return address2;
	}

	public WebElement getCityVillage() {
		return cityVillage;
	}

	public WebElement getStateProvince() {
		return stateProvince;
	}

	public WebElement getCountry() {
		return country;
	}

	public WebElement getPostalCode() {
		return postalCode;
	}

	public WebElement getPhoneNumber() {
		return phoneNumber;
	}

	public WebElement getSelectRelationshipType() {
		return selectRelationshipType;
	}

	public WebElement getPatientName() {
		return patientName;
	}

	public WebElement getGivenName() {
		return givenName;
	}

	public WebElement getMiddleName() {
		return middleName;
	}

	public WebElement getFamilyName() {
		return familyName;
	}

	public WebElement getNextButton() {
		return nextButton;
	}

}
