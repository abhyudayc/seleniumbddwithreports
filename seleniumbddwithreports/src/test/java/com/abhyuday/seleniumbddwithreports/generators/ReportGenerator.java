package com.abhyuday.seleniumbddwithreports.generators;

import java.net.InetAddress;
import java.net.UnknownHostException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportGenerator {

	private static ExtentHtmlReporter extentHtmlReporter;
	private static ExtentReports extentReport;
	private static ExtentTest test;
	
	public static void init() throws UnknownHostException {
		extentHtmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/output/reports/extentReport.html");
		extentReport = new ExtentReports();
		extentReport.attachReporter(extentHtmlReporter);
		
		extentReport.setSystemInfo("Host Name", InetAddress.getLocalHost().getHostName());
		extentReport.setSystemInfo("Environment", "PreProd");
		extentReport.setSystemInfo("User Name", "Test User");
		
		extentHtmlReporter.config().setDocumentTitle("Preprod Report");
		extentHtmlReporter.config().setReportName("PREPROD Reports for Registration Form");
		extentHtmlReporter.config().setTheme(Theme.STANDARD);
	}
	
	public static void log(String testName, boolean hasPassed) {
		test = extentReport.createTest(testName);
		if (hasPassed)
			test.log(Status.PASS, MarkupHelper.createLabel(testName, ExtentColor.GREEN));
		else
			test.log(Status.FAIL, MarkupHelper.createLabel(testName, ExtentColor.RED));
	}
	
	public static void tearDown() {
		extentReport.flush();
	}
}
