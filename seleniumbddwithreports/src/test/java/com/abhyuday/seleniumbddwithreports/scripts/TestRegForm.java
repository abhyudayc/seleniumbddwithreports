package com.abhyuday.seleniumbddwithreports.scripts;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.abhyuday.seleniumbddwithreports.fileio.FileHandler.ExcelFileHandler;
import com.abhyuday.seleniumbddwithreports.generators.ReportGenerator;
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
			ReportGenerator.init();
		} catch (Exception e) {
			System.err.println("Unable to read Excel file");
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public void tearDown() {
		registrationForm.tearDown();
		ReportGenerator.tearDown();
	}
	
	@AfterMethod
	public void reports(ITestResult testResult) {
		switch(testResult.getStatus()) {
		case ITestResult.SUCCESS:
			ReportGenerator.log(testResult.getName(), true);
			break;
		case ITestResult.FAILURE:
			ReportGenerator.log(testResult.getName(), false);
			break;
		case ITestResult.SKIP:
			break;
		}
	}
	
	@Test (priority=1)
	public void testWithPreprodData() {
		boolean testResult = true;
		try {
			List<Map<String, String>> lmaps = ExcelFileHandler.getData();
			for (Map<String, String> map : lmaps) {
				if(map.size()==0)
					continue;
				registrationForm.fillName(map.get("Name"));
				registrationForm.fillFathersName(map.get("Father's Name"));
				registrationForm.fillPostalAddress(map.get("Postal Address"));
				registrationForm.fillPersonalAddress(map.get("Personal Address"));
				registrationForm.selectSex(map.get("Sex"));
				registrationForm.selectCity(map.get("City"));
				registrationForm.selectCourse(map.get("Course"));
				registrationForm.selectDistrict(map.get("District"));
				registrationForm.selectState(map.get("State"));
				registrationForm.fillPINcode(map.get("PINcode"));
				registrationForm.fillEmail(map.get("Email"));
				registrationForm.fillDOB(map.get("DOB"));
				registrationForm.fillMobileNo(map.get("Mobile"));
				
				registrationForm.formSubmit();
				
				ScreenshotGenerator.takeScreenShot();
				
				Map<String, String> map2 = registrationForm.getSubmittedData();
				if(map2.get("Name").equals(map.get("Name")) &&
						map2.get("Father's Name").equalsIgnoreCase(map.get("Father's Name")) &&
						map2.get("Postal Address").equalsIgnoreCase(map.get("Postal Address")) &&
						map2.get("Personal Address").equalsIgnoreCase(map.get("Personal Address")) &&
						map2.get("Sex").equalsIgnoreCase(map.get("Sex")) &&
						map2.get("City").equalsIgnoreCase(map.get("City")) &&
						map2.get("Course").equalsIgnoreCase(map.get("Course")) &&
						map2.get("State").equalsIgnoreCase(map.get("State")) &&
						map2.get("District").equalsIgnoreCase(map.get("District")) &&
						map2.get("Email").equalsIgnoreCase(map.get("Email")) &&
						map2.get("DOB").equalsIgnoreCase(map.get("DOB")) &&
						map2.get("Mobile").equalsIgnoreCase(map.get("Mobile")) &&
						map2.get("PINcode").equalsIgnoreCase(map.get("PINcode"))
					) {
					registrationForm.goBackToFormPage();
				} else { throw new Exception(); }
			}
		} catch (Exception e) {
			e.printStackTrace();
			testResult = false;
		} finally {
			Assert.assertTrue(testResult);
		}
	}
	
	@Test(priority=2)
	public  void test1() {
		Assert.assertTrue(false);
	}
	@Test(priority=2)
	public  void test2() {
		Assert.assertTrue(false);
	}
	@Test(priority=2)
	public  void test3() {
		Assert.assertTrue(false);
	}
	
	@Test(priority=2)
	public  void test4() {
		Assert.assertTrue(false);
	}
	@Test(priority=2)
	public  void test5() {
		Assert.assertTrue(false);
	}
	@Test(priority=2)
	public  void test6() {
		Assert.assertTrue(false);
	}
	@Test(priority=2)
	public  void test7() {
		Assert.assertTrue(false);
	}
	@Test(priority=2)
	public  void test8() {
		Assert.assertTrue(false);
	}
	@Test(priority=2)
	public  void test9() {
		Assert.assertTrue(false);
	}
	@Test(priority=2)
	public  void test10() {
		Assert.assertTrue(false);
	}
	@Test(priority=2)
	public  void test11() {
		Assert.assertTrue(true);
	}
}
