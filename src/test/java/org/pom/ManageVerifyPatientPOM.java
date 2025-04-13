package org.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utils.Baseclass;

public class ManageVerifyPatientPOM extends Baseclass{
	
	public ManageVerifyPatientPOM() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//ul[@class='float-left']//li/a)[3]")
	private WebElement mergeVisits;
	
	@FindBy(xpath="(//table[@id='active-visits']/tbody/tr/td)[1]//input")
	private WebElement tableFirstRow;
	
	@FindBy(xpath="((//table[@id='active-visits']/tbody/tr)[2]/td)[1]//input")
	private WebElement tableSecondRow;
	
	@FindBy(xpath="//input[@id='mergeVisitsBtn']")
	private WebElement mergeVisitButton;
	
	@FindBy(xpath="(//table[@id='active-visits']/tbody/tr/td)[1]//input")
	private WebElement tableafterMerge;
	
	@FindBy(xpath="//input[@class='cancel']")
	private WebElement returnButton;
	
	@FindBy(css="div.tag.ng-binding.ng-scope")
	private WebElement vitalsText;
	
	@FindBy(xpath="(//ul[@class='float-left']//li/a)[2]")
	private WebElement addPast;
	
	@FindBy(xpath="//div[@class='simplemodal-wrap']//div[@id='retrospective-visit-creation-dialog']")
	private WebElement checkDate;
	
	@FindBy(xpath="//div[@class='simplemodal-wrap']//div[@id='retrospective-visit-creation-dialog']//div[contains(@class, 'form')]//button[@class='cancel']")
	private WebElement calenderClose;
	
	@FindBy(xpath="//div[contains(@class, 'tag') and normalize-space(text())='Vitals']")
	private WebElement recentvitalText;
	
	@FindBy(xpath="//div[contains(@class, 'tag') and normalize-space(text())='Attachment Upload']")
	private WebElement recentAttachText;

	public WebElement getRecentvitalText() {
		return recentvitalText;
	}

	public WebElement getRecentAttachText() {
		return recentAttachText;
	}

	public WebElement getCalenderClose() {
		return calenderClose;
	}

	public WebElement getMergeVisits() {
		return mergeVisits;
	}

	public WebElement getTableFirstRow() {
		return tableFirstRow;
	}

	public WebElement getTableSecondRow() {
		return tableSecondRow;
	}

	public WebElement getMergeVisitButton() {
		return mergeVisitButton;
	}

	public WebElement getTableafterMerge() {
		return tableafterMerge;
	}

	public WebElement getReturnButton() {
		return returnButton;
	}

	public WebElement getVitalsText() {
		return vitalsText;
	}

	public WebElement getAddPast() {
		return addPast;
	}

	public WebElement getCheckDate() {
		return checkDate;
	}
	
	
	

}
