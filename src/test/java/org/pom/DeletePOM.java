package org.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utils.Baseclass;

public class DeletePOM extends Baseclass{
	
	public DeletePOM() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//ul[@class='float-left']//li/a)[last()-1]")
	private WebElement deleteLink;
	
	@FindBy(xpath="//div[@id='delete-patient-creation-dialog']//div[@class='dialog-content']//input")
	private WebElement deleteText;
	
	@FindBy(xpath="//div[@id='delete-patient-creation-dialog']//div[@class='dialog-content']//button[contains(@class, 'confirm')]")
	private WebElement confirmButton;
	
	@FindBy(xpath="//table[@id='patient-search-results-table']/tbody/tr/td[@class='dataTables_empty']")
	private WebElement tableText;
	
	public WebElement getTableText() {
		return tableText;
	}

	@FindBy(id="patient-search")
	private WebElement searchText;
	
	@FindBy(xpath="//div[@class='float-sm-right']/span")
	private WebElement getId;

	public WebElement getGetId() {
		return getId;
	}

	public WebElement getDeleteLink() {
		return deleteLink;
	}

	public WebElement getDeleteText() {
		return deleteText;
	}

	public WebElement getConfirmButton() {
		return confirmButton;
	}

	public WebElement getSearchText() {
		return searchText;
	}

}
