package org.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utils.Baseclass;

public class BMICalculationPOM extends Baseclass {

	public BMICalculationPOM() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//ul[@class='float-left']//li[@class='float-left']/a//div//div)[2]")
	private WebElement startVisit;

	@FindBy(xpath = "//button[@id='start-visit-with-visittype-confirm']")
	private WebElement confrimButton;

	@FindBy(xpath = "((//div[@id='visit-details']//div)[2]/a)[4]")
	private WebElement captureVitalsButton;

	@FindBy(id = "w8")
	private WebElement height;

	@FindBy(id = "next-button")
	private WebElement nextButton;

	@FindBy(id = "w10")
	private WebElement weight;

	@FindBy(xpath = "//a[@id='save-form']")
	private WebElement saveForm;

	@FindBy(css = "button.submitButton.confirm.right.focused")
	private WebElement saveButton;

	@FindBy(xpath = "((//div[@id='visit-details']//div)[2]/a)[1]")
	private WebElement endVisit;

	@FindBy(xpath = "//div[@id='end-visit-dialog']//div[@class='dialog-content']//button")
	private WebElement yesButton;

	@FindBy(xpath = "//span[@class='PersonName-givenName']")
	private WebElement homePage;

	@FindBy(xpath = "(//strong[@class='ng-binding'])[1]")
	private WebElement weightVerifiy;

	@FindBy(xpath = "(//strong[@class='ng-binding'])[2]")
	private WebElement heightVerify;

	public WebElement getStartVisit() {
		return startVisit;
	}

	public WebElement getConfrimButton() {
		return confrimButton;
	}

	public WebElement getCaptureVitalsButton() {
		return captureVitalsButton;
	}

	public WebElement getHeight() {
		return height;
	}

	public WebElement getNextButton() {
		return nextButton;
	}

	public WebElement getWeight() {
		return weight;
	}

	public WebElement getSaveForm() {
		return saveForm;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getEndVisit() {
		return endVisit;
	}

	public WebElement getYesButton() {
		return yesButton;
	}

	public WebElement getHomePage() {
		return homePage;
	}

	public WebElement getWeightVerifiy() {
		return weightVerifiy;
	}

	public WebElement getHeightVerify() {
		return heightVerify;
	}

}
