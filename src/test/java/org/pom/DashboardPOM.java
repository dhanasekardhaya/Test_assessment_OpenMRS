package org.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utils.Baseclass;

public class DashboardPOM extends Baseclass{
	
	public DashboardPOM() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(tagName = "h4")
	private WebElement loginName;
	
	@FindBy(xpath = "//a[contains(@href, 'registerPatient.page')]")
	private WebElement registerPatientClick;

	public WebElement getLoginName() {
		return loginName;
	}

	public WebElement getRegisterPatientClick() {
		return registerPatientClick;
	}
	

}