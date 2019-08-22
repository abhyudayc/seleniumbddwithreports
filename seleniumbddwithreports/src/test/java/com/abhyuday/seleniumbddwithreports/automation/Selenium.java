package com.abhyuday.seleniumbddwithreports.automation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium {

	private WebDriver driver;
	private TakesScreenshot screenshot;
	private static Selenium selenium = new Selenium();
	
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
	}
	
	public void goToSite(String url) {
		driver.get(url);
	}
	
	public void click (String xpathExpression) {
		driver.findElement(By.xpath(xpathExpression)).click();
	}
	
	public void sendKeys(String xpathExpression, String text) {
		driver.findElement(By.xpath(xpathExpression)).sendKeys(text);
	}
	
	public String getAttributeValue(String xpathExpression, String attributeName) {
		return driver.findElement(By.xpath(xpathExpression)).getAttribute(attributeName);
	}
	
	public void getScreenshot(String scrshotPath) throws IOException {
		File scrshotFile = screenshot.getScreenshotAs(OutputType.FILE);
		File file = new File(scrshotPath);
		FileUtils.copyFile(scrshotFile, file);
	}
	
	public ArrayList<String> getTextValues(String xpathExpression) {
		List<WebElement> listOfWebElements = driver.findElements(By.xpath(xpathExpression));
		ArrayList<String> listOfTexts = new ArrayList<String>();
		for (WebElement elem : listOfWebElements)
			if(!elem.getText().trim().equals(""))
				listOfTexts.add(elem.getText());
		return listOfTexts;
	}
	
	public void tearDown() {
		driver.quit();
		driver = null;
	}
}
