package com.abhyuday.seleniumbddwithreports.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium {

	private WebDriver driver;
	
	private static Selenium selenium = new Selenium();
	
	public static Selenium getSelenium() {
		return selenium;
	}
	
	private Selenium() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	public void tearDown() {
		driver.quit();
		driver = null;
	}
}
