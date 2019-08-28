/*package com.abhyuday.seleniumbddwithreports.scripts;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.abhyuday.seleniumbddwithreports.generators.LogGenerator;
import com.abhyuday.seleniumbddwithreports.generators.ScreenshotGenerator;
import com.abhyuday.seleniumbddwithreports.pages.Google;

public class TestGoogle {

	Google google;
	boolean testPassed = false;
	String currentTest = null;
	
	@BeforeClass
	public void setUp() {
		LogGenerator.openLogSession();
		google = Google.getGoogle();
		ScreenshotGenerator.init();
	}
	
	@AfterClass
	public void tearDown() {
		google.tearDown();
		google = null;
		LogGenerator.closeLogSession();
	}
	
	@AfterMethod
	public void afterTest() {
		log(currentTest);
	}
	
	@Test (priority=1)
	public void searchTest() {
		boolean isSearched = google.search();
		testPassed = isSearched;
		currentTest = "SearchTest";
		takeScreenshot();
		Assert.assertTrue(isSearched);
	}
	
	@Test (priority=2)
	public void selectSearchResult() {
		testPassed = google.selectSearchResult(2);
		currentTest = "SelectSearchResult";
		takeScreenshot();
		Assert.assertTrue(testPassed);
	}
	
	private void log(String data) {
		  
		LogGenerator.log(new String[]{
				new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()),
				data,
				testPassed==true?"PASS":"FALSE"
			});
	}
	
	private void takeScreenshot() {
		ScreenshotGenerator.takeScreenShot();
	}
}
*/