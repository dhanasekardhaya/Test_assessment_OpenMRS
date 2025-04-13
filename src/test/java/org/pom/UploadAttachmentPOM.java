package org.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.utils.Baseclass;

public class UploadAttachmentPOM extends Baseclass{
	
	@FindBy(xpath="//ul[@class='float-left']//li/a//div//div[contains(text(), 'Start')]")
	private WebElement startVist;
	
	@FindBy(xpath="(//div[@id='visit-details']//div[contains(@class, 'visit-actions')]//a)[last()]")
	private WebElement clickAttach;
	
	@FindBy(css="div.dz-default.dz-message.ng-binding")
	private WebElement uploadFile;
	
	@FindBy(css="textarea.ng-pristine.ng-untouched.ng-valid.ng-empty")
	private WebElement imageCaption;
	
	@FindBy(xpath="//button[text()='Upload file']")
	private WebElement imageUpload;
	
	@FindBy(xpath="//div[@id='quick-visit-creation-dialog']//h3")
	private WebElement getModelText;
	
	@FindBy(xpath="//button[@id='start-visit-with-visittype-confirm']")
	private WebElement confrimText;
	
	@FindBy(xpath="//span[@class='PersonName-givenName']")
	private WebElement homePage;
	
	@FindBy(css="div.toast-item.toast-type-success > p")
	private WebElement toastMeassage;
	
	
	public String getToastMeassage() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
	    wait.until(ExpectedConditions.visibilityOf(toastMeassage));
	    return toastMeassage.getText();
	}

	public WebElement getHomePage() {
		return homePage;
	}

	public WebElement getGetModelText() {
		return getModelText;
	}

	public WebElement getConfrimText() {
		return confrimText;
	}

	public UploadAttachmentPOM() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getStartVist() {
		return startVist;
	}

	public WebElement getClickAttach() {
		return clickAttach;
	}

	public WebElement getUploadFile() {
		return uploadFile;
	}

	public WebElement getImageCaption() {
		return imageCaption;
	}

	public WebElement getImageUpload() {
		return imageUpload;
	}

	

}
