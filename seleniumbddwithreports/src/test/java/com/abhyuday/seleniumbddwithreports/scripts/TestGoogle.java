package com.abhyuday.seleniumbddwithreports.scripts;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.abhyuday.seleniumbddwithreports.generators.LogGenerator;
import com.abhyuday.seleniumbddwithreports.pages.Google;

public class TestGoogle {

	Google google;
	boolean testPassed = false;
	String currentTest = null;
	
	@BeforeClass
	public void setUp() {
		LogGenerator.openLogSession();
		google = Google.getGoogle();
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
	
	@Test
	public void searchTest() {
		boolean isSearched = google.search();
		List<String> searchResults = google.listSearchResults();
		testPassed = isSearched;
		currentTest = "SearchTest";
		Assert.assertTrue(isSearched);
	}
	
	private void log(String data) {
		  
		LogGenerator.log(new String[]{
				new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()),
				data,
				testPassed==true?"PASS":"FALSE"
			});
	}
}
