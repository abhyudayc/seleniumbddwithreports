package com.abhyuday.seleniumbddwithreports.scripts;

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
import com.abhyuday.seleniumbddwithreports.pages.W3Schools;
import com.abhyuday.seleniumbddwithreports.pages.W3Schools.TryItPage;
import com.abhyuday.seleniumbddwithreports.pages.W3Schools.W3SchoolsHTMLTutorialPage;
import com.abhyuday.seleniumbddwithreports.pages.W3Schools.W3SchoolsHomePage;

public class TestW3Schools {

	W3Schools w3Schools;
	boolean testPassed = false;
	String currentTest = null;
	
	@BeforeClass
	public void setUp() {
		LogGenerator.openLogSession();
		w3Schools = W3Schools.getW3Schools();
		ScreenshotGenerator.init();
	}
	
	@AfterClass
	public void tearDown() {
		w3Schools.tearDown();
		w3Schools = null;
		LogGenerator.closeLogSession();
	}
	
	@AfterMethod
	public void afterTest() {
		log(currentTest);
	}
	
	@Test (priority=1)
	public void goToLearnHTML() {
		w3Schools.selectMenuItem("Learn HTML");
		takeScreenshot();
		Assert.assertEquals(w3Schools.getCurrentPageTitle(), "HTML Tutorial");
	}
	
	@Test (priority=2)
	public void goToHTMLInputTypes() {
		w3Schools.selectMenuItem("HTML Input Types");
		takeScreenshot();
		Assert.assertEquals(w3Schools.getCurrentPageTitle(), "HTML Input Types");
	}
	
	@Test (priority=3)
	public void openTryItForRadioButton() {
		W3SchoolsHTMLTutorialPage.goToTryItForRadioButtons();
		takeScreenshot();
		Assert.assertEquals(w3Schools.getCurrentPageTitle(), "Tryit Editor v3.6");
	}
	
	@Test (priority=4)
	public void operateOnRadioButtons() {
		String requestSubmitted = TryItPage.selectRadioButton("female");
		takeScreenshot();
		TryItPage.closeTryItPage();
		Assert.assertTrue(requestSubmitted.contains("gender=female"));
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
