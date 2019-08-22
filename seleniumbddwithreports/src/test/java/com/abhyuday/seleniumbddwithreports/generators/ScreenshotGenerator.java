package com.abhyuday.seleniumbddwithreports.generators;

import com.abhyuday.seleniumbddwithreports.automation.Selenium;

public class ScreenshotGenerator {
	
	private static Selenium selenium;
	private static String scrshotPath; 
	private static String[] imgFormat = {"PNG", "JPG"};
	
	public static void init() {
		selenium = Selenium.getSelenium();
		scrshotPath = System.getProperty("user.dir") + "\\output\\screenshots";
		System.out.println(scrshotPath);
	}
	
	public static void takeScreenShot() {
		try {
			selenium.getScreenshot(scrshotPath + "\\" + System.currentTimeMillis() + "." + imgFormat[0]);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Unable to get Screenshot");
		}
	}
}
