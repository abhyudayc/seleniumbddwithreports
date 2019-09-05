package com.abhyuday.seleniumbddwithreports.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.abhyuday.seleniumbddwithreports.automation.Selenium;

public class RegistrationForm {

private Selenium selenium;
	
	private static RegistrationForm registrationForm = new RegistrationForm();
	
	public static RegistrationForm getRegistrationForm() {
		return registrationForm;
	}
	
	private RegistrationForm () {
		selenium = Selenium.getSelenium();
		selenium.startChromeBrowser();
		selenium.goToSite("http://localhost:8080/SampleRegistrationForm/");
	}
	
	public void fillName(String name) {
		selenium.sendKeys("//*[@name='textnames']", name);
	}

	public void fillFathersName(String fathername) {
		selenium.sendKeys("//*[@name='fathername']", fathername);
	}

	public void fillPostalAddress(String postaladd) {
		selenium.sendKeys("//*[@name='paddress']", postaladd);
	}

	public void fillPersonalAddress(String personaladd) {
		selenium.sendKeys("//*[@name='personaladdress']", personaladd);
	}
	
	public void selectSex(String option) {
		selenium.click("//*[@name='sex'][@value='" + option.toLowerCase() + "' or @value='" + option + "']");
	}
	
	public void selectCity(String option) {
		selenium.checkboxSelect("//select[@name='City']", option);
	}
	
	public void selectCourse(String option) {
		selenium.checkboxSelect("//select[@name='Course']", option);
	}
	
	public void selectDistrict(String option) {
		selenium.checkboxSelect("//select[@name='District']", option);
	}
	
	public void selectState(String option) {
		selenium.checkboxSelect("//select[@name='State']", option);
	}

	public void fillPINcode(String pincode) {
		selenium.sendKeys("//*[@name='pincode']", pincode);
	}

	public void fillEmail(String emailid) {
		selenium.sendKeys("//*[@name='emailid']", emailid);
	}

	public void fillDOB(String dob) {
		selenium.sendKeys("//*[@name='dob']", dob);
	}

	public void fillMobileNo(String mobileno) {
		selenium.sendKeys("//*[@name='mobileno']", mobileno);
	}
	
	public void formSubmit() {
		selenium.click("//input[@type='submit']");
	}
	
	public Map<String, String> getSubmittedData() {
		ArrayList<String> entireText = selenium.getTextValues("//pre");
		String[] splittedString = entireText.get(0).split("\n");
		Map<String, String> map = new HashMap<String, String>();
		for (String s: splittedString) {
			map.put(s.split(":")[0].trim(), s.split(":")[1].trim());
		}
		return map;
	}
	
	public void goBackToFormPage() {
		selenium.goBack();
	}
	
	public void tearDown() {
		selenium.tearDown();
		selenium = null;
	}
}

