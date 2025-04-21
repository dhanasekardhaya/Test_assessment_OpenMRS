package org.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * Baseclass for seleninum common methods
 * Created By : Dhanasekar D [12-Apr-2025]
 * */

public class Baseclass {

	public static WebDriver driver;

	public static String userName;

	public static WebDriverWait wait;

	public static void openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			prefs.put("autofill.profile_enabled", false);
			prefs.put("profile.default_content_setting_values.notifications", 2);
			options.setExperimentalOption("prefs", prefs);
			System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			wait = new WebDriverWait(driver, 20); 

		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.chrome.driver", ".\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
	}

	public static void urlLaunch(String urlContent, long timesWait) {
		driver.manage().timeouts().implicitlyWait(timesWait, TimeUnit.SECONDS);
		driver.get(urlContent);
	}

	public static void sendKeys(WebElement element, String inputValue) {
		element.sendKeys(inputValue);
	}

	public static void clickEvent(WebElement element) {
		element.click();
	}

	public static Boolean webdriverWaitURL(String urlText, long timesWait) {
		wait = new WebDriverWait(driver, timesWait);
		return wait.until(ExpectedConditions.urlContains(urlText));
	}

	public static String getText(WebElement element) {
		String elementText = element.getText();
		return elementText;
	}

	public static String captureScreenshot(String scenarioName) {
		try {
			String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			String screenshotDir = System.getProperty("user.dir") + "\\src\\test\\resources\\screenshots\\";
			new File(screenshotDir).mkdirs();

			String filePath = screenshotDir + scenarioName.replaceAll(" ", "_") + "_" + timestamp + ".png";
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File destFile = new File(filePath);

			FileHandler.copy(srcFile, destFile);
			return filePath;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void selectClass(WebElement element, String inputValue) {
		Select select = new Select(element);
		select.selectByVisibleText(inputValue);

	}

	public static Boolean webdriverWaitAttribute(WebElement element, String urlText, long timesWait) {
		WebDriverWait wait = new WebDriverWait(driver, timesWait);
		return wait.until(ExpectedConditions.attributeToBe(element, "class", urlText));
	}

	public static void elementClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("elementId")));
		elementClick.click();

	}

	public static Alert alertClass() {
		Alert a = driver.switchTo().alert();
		return a;
	}
	
	public static WebElement waitToastpath() {
		return driver.findElement(By.cssSelector("div.toast-item.toast-type-success>p"));

	}

	public static String waitToastText() {
		By toastLocator = By.cssSelector("div.toast-item.toast-type-success>p");
		WebElement toastElement = wait.until(ExpectedConditions.visibilityOfElementLocated(toastLocator));
		return toastElement.getText();

	}
	
	public static boolean waitToastTextInvisible() {
		return wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.toast-item.toast-type-success>p")));

	}

	public static boolean waitLoader() {
		return wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath("//img[contains(@src, 'spinner.gif')]")));

	}

	public static void waitVisibleByFile() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(@class, 'dz-default') and contains(text(), 'Click or')]")));
	}

	public static void waitVisibleByDialog() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@id='quick-visit-creation-dialog' and contains(@class, 'dialog')]")));

	}
	
	public static void elementPresent() {
		wait.until(ExpectedConditions.textToBePresentInElementLocated(
			    By.xpath("//div[@id='visit-details']//div[contains(@class,'status-container')]"),
			    "Active Visit"));

	}
	
	public static boolean deletePresent() {
		return wait.until(ExpectedConditions.textToBePresentInElementLocated(
			    By.xpath("//table[@id='patient-search-results-table']/tbody/tr/td[@class='dataTables_empty']"),
			    "No matching records found"));

	}
	
	public static void jsElementHighlighted(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='2px solid green'", element);
	}

}
