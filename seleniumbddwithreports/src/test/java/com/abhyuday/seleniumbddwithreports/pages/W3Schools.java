package com.abhyuday.seleniumbddwithreports.pages;

import java.util.List;

import com.abhyuday.seleniumbddwithreports.automation.Selenium;

public class W3Schools {

	private static String currentPageHandle = null;
	
	private static Selenium selenium;	
	private static W3Schools w3schools = new W3Schools();	
	public static W3Schools getW3Schools() {
		return w3schools;
	}
	
	private W3Schools() {
		selenium = Selenium.getSelenium();
		selenium.startChromeBrowser();
		selenium.goToSite("http://www.w3schools.com"); 
	}

	public void tearDown() {
		selenium.tearDown();
		selenium = null;
	}
	
	public String getCurrentPageTitle() {
		return selenium.getPageTitle();
	}
	
	public void selectMenuItem(String itemName) {
		selenium.click("//div[@class='w3-bar-block' or @class='w3-light-grey']//a[contains(text(), '" + itemName + "')]");
	}
	
	private static void closePage() {
		selenium.closePage(currentPageHandle);
	}
	
	public abstract static class W3SchoolsHomePage {
	
		
	}
	
	public abstract static class W3SchoolsHTMLTutorialPage {
		
		public static void goToTryItForRadioButtons() {
			selenium.click("//h2[contains(text(), 'Input Type Radio')]/following-sibling::div[@class='w3-example']/a");
			currentPageHandle = selenium.goToLatestPage();
		}
		
		public static void goToTryItForCheckBoxes() {
			selenium.click("//h2[contains(text(), 'Input Type Checkbox')]/following-sibling::div[@class='w3-example']/a");
			currentPageHandle = selenium.goToLatestPage();
		}
	}
	
	public abstract static class W3SchoolsHTMLTagPage {

		public static void goToTryItForSelectTag() {
			selenium.click("//*[contains(text(), \"Try it Yourself\")]");
			currentPageHandle = selenium.goToLatestPage();
		}
		
	}
	
	public abstract static class TryItPage {
		
		public static String selectRadioButton(String option) {
			selenium.goToIframe("//iframe[@id='iframeResult']");
			List<String> list = selenium.getAttributeValues("//input[@type='radio'][@name='gender']", "value");
			int indexOfOption = -1;
			for(int i = 0; i < list.size(); i++) {
				if (list.get(i).equals(option)) {
					indexOfOption = i;
					break;
				}
			}
			selenium.click("//input[@type='radio'][@name='gender']", indexOfOption);
			selenium.click("//input[@type='submit']");
			String requestSubmittedText = selenium.getTextValues("//div[@class='w3-container w3-large w3-border']").get(0);
			return requestSubmittedText;
		}
		
		public static String selectCheckBox(String option) {
			selenium.goToIframe("//iframe[@id='iframeResult']");
			selenium.click("//input[@type='checkbox'][@value='" + option + "']");
			selenium.click("//input[@type='submit']");
			String requestSubmittedText = selenium.getTextValues("//div[@class='w3-container w3-large w3-border']").get(0);
			return requestSubmittedText;
		}
		
		public static void selectDropDown(String option) {
			selenium.goToIframe("//iframe[@id='iframeResult']");
			selenium.checkboxSelect("//select", option);
		}
		
		public static void closeTryItPage() {
			closePage();
			selenium.goToLatestPage();
		}
	}
	
}
