package org.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utils.Baseclass;

public class LoginPOM extends Baseclass{
	
	public LoginPOM() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	private WebElement userName;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(xpath = "//ul[@id='sessionLocation']/li[contains(text(), 'Isolation Ward')]")
	private WebElement location;
	
	@FindBy(id="loginButton")
	private WebElement loginButton;

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLocation() {
		return location;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	

}
