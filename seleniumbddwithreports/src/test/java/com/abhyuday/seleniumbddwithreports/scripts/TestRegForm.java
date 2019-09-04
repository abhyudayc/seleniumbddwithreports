package com.abhyuday.seleniumbddwithreports.scripts;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.abhyuday.seleniumbddwithreports.fileio.FileHandler.ExcelFileHandler;
import com.abhyuday.seleniumbddwithreports.generators.ScreenshotGenerator;
import com.abhyuday.seleniumbddwithreports.pages.RegistrationForm;

public class TestRegForm {

	RegistrationForm registrationForm;
	
	@BeforeClass
	public void setup() {
		registrationForm = RegistrationForm.getRegistrationForm();
		ScreenshotGenerator.init();
		try {
			ExcelFileHandler.init();
		} catch (IOException e) {
			System.err.println("Unable to read Excel file");
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public void tearDown() {
		registrationForm.tearDown();
	}
	
	@Test
	public void testWithPreprodData() {
		List<Map<String, String>> lmaps = ExcelFileHandler.getData();
		for (Map<String, String> map : lmaps) {
			if(map.size()==0)
				continue;
			registrationForm.fillName(map.get("Name"));
			registrationForm.fillFathersName(map.get("Father"));
			registrationForm.fillPostalAddress(map.get("Address"));
			registrationForm.fillPersonalAddress(map.get("Personal Address"));
			registrationForm.selectSex(map.get("Sex"));
			registrationForm.selectCity(map.get("City"));
			registrationForm.selectCourse(map.get("Course"));
			registrationForm.selectDistrict(map.get("District"));
			registrationForm.selectState(map.get("State"));
			registrationForm.fillPINcode(map.get("Pin code"));
			registrationForm.fillEmail(map.get("Email"));
			registrationForm.fillDOB(map.get("DOB"));
			registrationForm.fillMobileNo(map.get("Mobile"));
		}
	}
}
