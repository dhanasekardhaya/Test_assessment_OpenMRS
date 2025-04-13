package org.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utils.Baseclass;

public class PatientagePOM extends Baseclass{
	
	public PatientagePOM() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//div[contains(@class, 'gender-age')]//span)[2]")
	private WebElement ageCalcualted;

	public WebElement getAgeCalcualted() {
		return ageCalcualted;
	}
	
	
	

}
