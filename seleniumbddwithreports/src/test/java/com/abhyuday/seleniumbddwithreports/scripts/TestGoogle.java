package com.abhyuday.seleniumbddwithreports.scripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.abhyuday.seleniumbddwithreports.pages.Google;

public class TestGoogle {

	Google google;
	
	@BeforeClass
	public void setUp() {
		google = Google.getGoogle();
	}
	
	@AfterClass
	public void tearDown() {
		google.tearDown();
		google = null;
	}
	
	@Test
	public void dummyTest() throws InterruptedException {
		Thread.sleep(5000);
	}
}
