package com.abhyuday.seleniumbddwithreports.automation;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium {

	private WebDriver driver;
	
	private static Selenium selenium = new Selenium();
	
	public static Selenium getSelenium() {
		return selenium;
	}
	
	private Selenium() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\lib\\chromedriver.exe");
	}
	
	public void startChromeBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public void goToSite(String url) {
		driver.get(url);
	}
	
	public void sendKeys(String xpathExpression, String text) {
		driver.findElement(By.xpath(xpathExpression)).sendKeys(text);
	}
	
	public String getAttributeValue(String xpathExpression, String attributeName) {
		return driver.findElement(By.xpath(xpathExpression)).getAttribute(attributeName);
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
