package org.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utils.Baseclass;

public class PatientAttachmentPOM extends Baseclass{
	
	public WebElement getEndVisit() {
		return endVisit;
	}

	public WebElement getAttachmentTag() {
		return attachmentTag;
	}

	public WebElement getImageName() {
		return imageName;
	}

	public PatientAttachmentPOM() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="ul.float-left.d-none.d-lg-block>li")
	private WebElement endVisit;
	
	@FindBy(css="div.tag.ng-binding.ng-scope")
	private WebElement attachmentTag;
	
	@FindBy(xpath="(//p[@class='ng-binding'])[2]")
	private WebElement imageName;
	
	@FindBy(xpath="//div[@id='end-visit-dialog']//div[@class='dialog-content']//button")
	private WebElement yesButton;

	public WebElement getYesButton() {
		return yesButton;
	}
	

}
