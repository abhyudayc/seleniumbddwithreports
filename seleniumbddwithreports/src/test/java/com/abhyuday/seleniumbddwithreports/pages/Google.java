package com.abhyuday.seleniumbddwithreports.pages;

import com.abhyuday.seleniumbddwithreports.automation.Selenium;

public class Google {

	private Selenium selenium;
	
	private static Google google = new Google();
	
	public static Google getGoogle() {
		return google;
	}
	
	private Google() {
		selenium = Selenium.getSelenium();
	}
	
	public void tearDown() {
		selenium.tearDown();
		selenium = null;
	}
}
