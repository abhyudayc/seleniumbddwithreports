package com.abhyuday.seleniumbddwithreports.pages;

import java.util.List;

import com.abhyuday.seleniumbddwithreports.automation.Selenium;
import com.abhyuday.seleniumbddwithreports.generators.DummyTextGenerator;

public class Google {

	private Selenium selenium;
	
	private static Google google = new Google();
	
	public static Google getGoogle() {
		return google;
	}
	
	private Google() {
		selenium = Selenium.getSelenium();
		selenium.startChromeBrowser();
		selenium.goToSite("http://www.google.com");
	}
	
	public boolean search() {
		String text = DummyTextGenerator.generateRandomWords();
		selenium.sendKeys("//input[@name=\"q\"]", text + "\n");
		String attrValue = selenium.getAttributeValue("//input[@name=\"q\"]", "value");
		return attrValue.equals(text);
	}
	
	public boolean search(String text) {
		selenium.sendKeys("//input[@name=\"q\"]", text + "\n");
		String attrValue = selenium.getAttributeValue("//input[@name=\"q\"]", "value");
		return attrValue.equals(text);
	}
	
	public List<String> listSearchResults() {
		return selenium.getTextValues("//h3[@class=\"LC20lb\"]/div[@class=\"ellip\"]");
		
	}
	
	public void tearDown() {
		selenium.tearDown();
		selenium = null;
	}
}
