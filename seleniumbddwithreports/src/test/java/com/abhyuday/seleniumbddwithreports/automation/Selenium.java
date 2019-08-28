package com.abhyuday.seleniumbddwithreports.automation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium {

	private WebDriver driver;
	private TakesScreenshot screenshot;
	private static Selenium selenium = new Selenium();
	private WebDriverWait wait;
	
	public static Selenium getSelenium() {
		return selenium;
	}
	
	private Selenium() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\lib\\chromedriver.exe");
	}
	
	public void startChromeBrowser() {
		driver = new ChromeDriver();
		screenshot = (TakesScreenshot)driver;
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 10);
	}
	
	public void goToSite(String url) {
		driver.get(url);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public String getCurrentWindowHandle() {
		return driver.getWindowHandle();
	}
	
	public String goToLatestPage() {
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			driver.switchTo().window(handle);
			System.out.println(handle + " - " + driver.getTitle());
		}
		return getCurrentWindowHandle();
	}
	
	public void goToIframe(String xpathExpression) {
		driver.switchTo().frame(driver.findElement(By.xpath(xpathExpression)));
	}
	
	public void goToDefaultContent() {
		driver.switchTo().defaultContent();
	}
	
	public void click (String xpathExpression) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
		driver.findElement(By.xpath(xpathExpression)).click();
	}
	
	public void click (String xpathExpression, int indexOfOccurence) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
		driver.findElements(By.xpath(xpathExpression)).get(indexOfOccurence).click();
	}
	
	public void sendKeys(String xpathExpression, String text) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathExpression)));
		driver.findElement(By.xpath(xpathExpression)).sendKeys(text);
	}
	
	public String getAttributeValue(String xpathExpression, String attributeName) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathExpression)));
		return driver.findElement(By.xpath(xpathExpression)).getAttribute(attributeName);
	}
	
	public List<String> getAttributeValues(String xpathExpression, String attributeName) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpathExpression)));
		List<WebElement> webElements = driver.findElements(By.xpath(xpathExpression));
		List<String> listOfAttributes = new ArrayList<String>();
		for (WebElement element : webElements) {
			listOfAttributes.add(element.getAttribute(attributeName));
		}
		return listOfAttributes;
	}
	
	public void getScreenshot(String scrshotPath) throws IOException {
		File scrshotFile = screenshot.getScreenshotAs(OutputType.FILE);
		File file = new File(scrshotPath);
		FileUtils.copyFile(scrshotFile, file);
	}
	
	public ArrayList<String> getTextValues(String xpathExpression) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpathExpression)));
		List<WebElement> listOfWebElements = driver.findElements(By.xpath(xpathExpression));
		ArrayList<String> listOfTexts = new ArrayList<String>();
		for (WebElement elem : listOfWebElements)
			if(!elem.getText().trim().equals(""))
				listOfTexts.add(elem.getText());
		return listOfTexts;
	}
	
	public void closePage(String winHandle) {
		goToDefaultContent();
		driver.switchTo().window(winHandle);
		System.out.println(winHandle);
		driver.close();
	}
	
	public void tearDown() {
		driver.quit();
		driver = null;
	}
}
