package script;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import generic.AutoUtility;
import generic.BaseTest;
import generic.Excel;

//import org.apache.log4j.Logger;
public class CompleteAutosuggestModule extends BaseTest {
	public String tc22sbXpath;
	public String ppid;
	String prev = null;
	String pop = null;
	String endResult1 = null;
	String endResult2 = null;
	String endResult3 = null;
	String endResult4 = null;
	
	// -----------------------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------

	// AUTOSUGGEST IS COMING OR NOT
	@Test(priority = 1)
	public void autoSuggestIsComingOrNot() throws InterruptedException {
		log.info("TEST-CASE:" + "AUTO SUGGEST IS COMING OR NOT");
		String y = Excel.getCellCalue(EXCEL_DATA, "Sheet3", 0, 1);
		log.info(y);
		driver.findElement(By.xpath(AutoUtility.getProperty(CONFIG_PROPERTY2, "searchbox"))).sendKeys(y);// input[@id='search']
		Thread.sleep(1000);
		List<WebElement> total = driver
				.findElements(By.xpath(AutoUtility.getProperty(CONFIG_PROPERTY2, "popularproductslist")));// div[@class='unbxd-as-popular-product-info']
		int totalSize = total.size();

		if (totalSize > 0) {
			log.info("Autosuggest Should display");
			log.info("Autosuggest coming for " + y + " letter :: PASS");
			log.info("------------------------------------------------");
		} else {
			log.info("Autosuggest Should not display");
			log.info("Autosuggest is not coming for " + y + " word :: FAIL");
			log.info("------------------------------------------------");
		}
		driver.quit();
	}
	// -----------------------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------
	// SINGLE AND WITHSPACE QUERIES for AUTOSUGGEST COMING OR NOT
	@Test(priority = 2)
	public void EachLetter() throws IOException, InterruptedException {
		log.info("TEST-CASES::" + "SINGLE AND WITHSPACE QUERIES");
		for (int i = 0; i <= 7; i++) {
			String y = Excel.getCellCalue(EXCEL_DATA, "Sheet3", i, 1);
			log.info(y);
			driver.findElement(By.xpath(AutoUtility.getProperty(CONFIG_PROPERTY2, "searchbox"))).sendKeys(y);// input[@id='search']
			Thread.sleep(1000);
			List<WebElement> total = driver
					.findElements(By.xpath(AutoUtility.getProperty(CONFIG_PROPERTY2, "popularproductslist")));// div[@class='unbxd-as-popular-product-info']
			int totalSize = total.size();
			Thread.sleep(500);
			if (totalSize > 0) {
				log.info("Autosuggest is displayed");
				log.info("Autosuggest Displaying for " + y + " letter :: PASS");
				log.info("------------------------------------------------");
			} else {
				log.info("Autosuggest is not displayed");
				log.info("Autosuggest is not displaying for " + y + " word :: FAIL");
				log.info("------------------------------------------------");
			}
			Thread.sleep(1000);

			driver.findElement(By.xpath(AutoUtility.getProperty(CONFIG_PROPERTY2, "searchbox"))).clear();
		}
	}
	// -----------------------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------
	// WITHOUT SPACE QUERIES
	@Test(priority = 3)
	public void withoutspace() throws IOException, InterruptedException {
		log.info("TEST-CASES::" + "WITHOUT SAPCE QUERIES");
		for (int i = 8; i <= 10; i++) {
			String y = Excel.getCellCalue(EXCEL_DATA, "Sheet3", i, 1);
			log.info(y);

			driver.findElement(By.xpath(AutoUtility.getProperty(CONFIG_PROPERTY2, "searchbox"))).sendKeys(y);// input[@id='search']
			Thread.sleep(500);
			List<WebElement> total = driver
					.findElements(By.xpath(AutoUtility.getProperty(CONFIG_PROPERTY2, "popularproductslist")));// div[@class='unbxd-as-popular-product-info']
			int totalSize = total.size();
			Thread.sleep(1000);
			if (totalSize > 0) {
				log.info("Autosuggest is displayed");
				log.info("Autosuggest is Displaying for " + y + " letter :: FAIL");
				log.info("------------------------------------------------");
			} else {
				log.info("Autosuggest is not displayed");
				log.info("Autosuggest is not displaying for " + y + " word :: PASS");
				log.info("------------------------------------------------");
			}
			Thread.sleep(1000);

			driver.findElement(By.id("search")).clear();
		}
	}
	// -----------------------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------
	// KEYWORD SUGGEST IS COMING OR NOT
	@Test(priority = 4)
	public void keywordSuggestionIsCommingorNot() throws InterruptedException {
		log.info("TEST-CASE::" + "KEYWORD SUGGEST IS COMING OR NOT");

		String y = Excel.getCellCalue(EXCEL_DATA, "Sheet3", 0, 1);
		log.info(y);
		// input[@id='search']
		driver.findElement(By.xpath(AutoUtility.getProperty(CONFIG_PROPERTY2, "searchbox"))).sendKeys(y);// input[@id='search']
		Thread.sleep(1000);
		// li[@class='unbxd-as-keysuggestion']
		List<WebElement> keywordSuggestion = driver
				.findElements(By.xpath(AutoUtility.getProperty(CONFIG_PROPERTY2, "keywordsuggestionlist")));
		int k = keywordSuggestion.size();
		if (k > 0) {
			log.info("Keyword suggestion is Displaying");
			log.info("For Keyword suggestion Test-Case is PASS:");
		} else

		{
			log.info("Test-case is fails");
		}
		driver.quit();
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------
	// keyword suggestions with enter button
	@Test(priority = 5)
	public void keywordWithEnterButton() throws InterruptedException {
		log.info("TEST-CASE:" + "KEYWORD SUGGESTIONS WITH ENTER BUTTON");
		String oldUrl = driver.getCurrentUrl();

		String y = Excel.getCellCalue(EXCEL_DATA, "Sheet3", 0, 1);
		log.info(y);
		// input[@id='search']
		driver.findElement(By.xpath(AutoUtility.getProperty(CONFIG_PROPERTY2, "searchbox"))).sendKeys(y);// input[@id='search']
		Thread.sleep(1000);
		// li[@class='unbxd-as-keysuggestion']
		List<WebElement> keywordSuggestion = driver
				.findElements(By.xpath(AutoUtility.getProperty(CONFIG_PROPERTY2, "keywordsuggestionlist")));
		Actions a = new Actions(driver);
		a.sendKeys(Keys.ARROW_DOWN).perform();
		driver.findElement(By.xpath(AutoUtility.getProperty(CONFIG_PROPERTY2, "searchbox"))).sendKeys(Keys.ENTER);
		String newUrl = driver.getCurrentUrl();
		if (oldUrl.equals(newUrl)) {
			log.info("keyword suggestions with enter button is not working:" + "TESTCASE FAIL");
		} else {
			log.info("keyword suggestions with enter button is working:" + "TESTCASE PASS");
		}
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------
	// keyword suggestions with search button
	@Test(priority = 6)
	public void keywordWithSearchButton() throws InterruptedException {
		log.info("TEST-CASE::" + "KEYWORD SUGGESTIONS WITH SEARCH BUTTON");
		String oldUrl = driver.getCurrentUrl();
		// searchbox
		String y = Excel.getCellCalue(EXCEL_DATA, "Sheet3", 0, 1);
		log.info(y);
		driver.findElement(By.xpath(AutoUtility.getProperty(CONFIG_PROPERTY2, "searchbox"))).sendKeys(y);// input[@id='search']
		// driver.findElements(By.xpath("//li[@class='unbxd-as-keysuggestion']")).get(0).click();
		Thread.sleep(500);
		driver.findElements(By.xpath(AutoUtility.getProperty(CONFIG_PROPERTY2, "keywordsuggestionlist"))).get(0)
				.click();
		Thread.sleep(500);
		String newUrl = driver.getCurrentUrl();
		if (oldUrl.equals(newUrl)) {
			log.info("keyword suggestions with search button is not working:" + "TESTCASE FAIL");
		} else {
			log.info("keyword suggestions with search button is working:" + "TESTCASE PASS");
		}
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------
	// TEST WITH SPACE THEN click search icon
	@Test(priority = 7)
	public void spaceandEnter() throws InterruptedException {
		log.info("TEST-CASE::" + "TEST WITH SPACE THEN CLICK ON SEARCH ICON");
		Thread.sleep(1000);
		driver.findElement(By.xpath(AutoUtility.getProperty(CONFIG_PROPERTY2, "searchbox"))).sendKeys("   ");
		Thread.sleep(1000);
		// search icon button xpath
		driver.findElement(By.xpath(AutoUtility.getProperty(CONFIG_PROPERTY2, "searchicon"))).click();
		String actualUrl = "https://www.moodfabrics.com/";
		String expectedURL = driver.getCurrentUrl();
		if (actualUrl.equals(expectedURL)) {
			log.info("TEST WITH SPACE THEN ENTER: Test case is: PASS");
		} else {
			log.info("TEST WITH SPACE THEN ENTER: Test case is: FAIL");
		}

		driver.quit();
	}

	// -----------------------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------
	@Test(priority = 8)
	// Test whether Popular products available or not
	public void popularproductavailableornot() {

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.get("https://www.moodfabrics.com/");
		// driver.findElement(By.name("q")).sendKeys("a");
		String y = Excel.getCellCalue(EXCEL_DATA, "Sheet3", 0, 1);
		log.info(y);
		driver.findElement(By.xpath(AutoUtility.getProperty(CONFIG_PROPERTY2, "searchbox"))).sendKeys(y);// input[@id='search']
		// div[@class='unbxd-as-popular-product-name']
		List<WebElement> myValue2 = driver
				.findElements(By.xpath(AutoUtility.getProperty(CONFIG_PROPERTY2, "popularproductsnamelist")));
		int numberofPopularproducts = myValue2.size();
		System.out.println(numberofPopularproducts);

		if (numberofPopularproducts > 0) {
			System.out.println("popular products are present");
		} else {
			System.out.println("popular products are not present");
		}
	}

	// -----------------------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------
	@Test(priority = 9)
	// price is displaying in Auto suggest popular product or not
	public void popualrProductpriceCheck() throws InterruptedException {
		String y = Excel.getCellCalue(EXCEL_DATA, "Sheet3", 0, 1);
		log.info(y);
		// input[@id='search']
		driver.findElement(By.xpath(AutoUtility.getProperty(CONFIG_PROPERTY2, "searchbox"))).sendKeys(y);// input[@id='search']
		Thread.sleep(1000);
		// driver.findElement(By.name("q")).sendKeys("a");
		String baseURL = driver.getCurrentUrl();
		List<WebElement> myValue2 = driver
				.findElements(By.xpath(AutoUtility.getProperty(CONFIG_PROPERTY2, "popularproductsnamelist")));
		int numberofPopularproducts = myValue2.size();
		//// div[@class='unbxd-as-popular-product-price']
		List<WebElement> myValue3 = driver
				.findElements(By.xpath(AutoUtility.getProperty(CONFIG_PROPERTY2, "popularproductspricelist")));
		int popularproductsPrice = myValue3.size();
		System.out.println(numberofPopularproducts);
		String firstPricevalue = myValue3.get(0).getText();
		// checking price is present or not in auto suggest popular products
		if (popularproductsPrice > 0) {
			System.out.println("In Auto suggest popular products price is showing");
		} else {
			System.out.println("In Auto suggest popular products price is not present");
		}
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------
	@Test(priority = 10)
	// checking popular product is clickable or not TESTCASE-3
	// popular product price is same in front end and in pdp TESTCASE-4
	public void popularproductclickandprice() throws InterruptedException {
		String y = Excel.getCellCalue(EXCEL_DATA, "Sheet3", 0, 1);
		log.info(y);
		// input[@id='search']
		driver.findElement(By.xpath(AutoUtility.getProperty(CONFIG_PROPERTY2, "searchbox"))).sendKeys(y);// input[@id='search']
		Thread.sleep(1000);
		// driver.findElement(By.name("q")).sendKeys("a");
		String baseURL = driver.getCurrentUrl();
		List<WebElement> myValue2 = driver
				.findElements(By.xpath(AutoUtility.getProperty(CONFIG_PROPERTY2, "popularproductsnamelist")));
		int numberofPopularproducts = myValue2.size();
		//// div[@class='unbxd-as-popular-product-price']
		List<WebElement> myValue3 = driver
				.findElements(By.xpath(AutoUtility.getProperty(CONFIG_PROPERTY2, "popularproductspricelist")));
		int popularproductsPrice = myValue3.size();
		System.out.println(numberofPopularproducts);
		String firstPricevalue = myValue3.get(0).getText();

		System.out.println("First popular product ptice in Auto suggest" + firstPricevalue);
		// clicking on first Auto suggest popular product to check price in pdp
		myValue2.get(0).click();
		String pdpURL = driver.getCurrentUrl();
		// storing pdp product price
		//// span[@class='price']
		String pdpPrice = driver.findElement(By.xpath(AutoUtility.getProperty(CONFIG_PROPERTY2, "pdpproductprice")))
				.getText();
		// displaying pdp product price
		System.out.println("First popular product ptice in PDP" + pdpPrice);
		// checking popular product is clickable or not
		if (baseURL.equals(pdpURL)) {
			System.out.println("Auto sugegts popular product is not clickable:TEST CASE FAIL");
		} else {
			System.out.println("Auto suggest popular product is clickable:TEST CASE PASS");
		}		
		
		// checking popular product price is same or not

		if (firstPricevalue.equals(pdpPrice)) {
			System.out.println("popular product price is same and Not getting any error page of pdp" + "TEST CASE PASS");
		} else {
			System.out.println("popular product price is not same and  Not getting any error page of pdp" + "TEST CASE FAIL");
		}
	}
	// -----------------------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------
	// POPULAR PRODUCTS ARE SAME OR NOT IN AUTOSUGGEST SUGGESTIONS
	@Test(priority = 11)
	public void popularProductMouse() throws InterruptedException {
		log.info("--------------------Testcase 22 is Running-------------------");
		log.info("TEST-CASE" + "POPULAR PRODUCTS ARE SAME OR NOT IN AUTOSUGGEST SUGGESTIONS");
		// MOUSE with POPUALR PRODUCTS MATCHING
		driver.findElement(By.xpath(AutoUtility.getProperty(CONFIG_PROPERTY2, "popularproductxpath"))).clear();
		String tc22locatorValue = Excel.getCellCalue(EXCEL_DATA, "dickblick", 1, 0);
		tc22sbXpath = AutoUtility.getProperty(CONFIG_PROPERTY2, "tc22kwsXpath");
		driver.findElement(By.xpath(AutoUtility.getProperty(CONFIG_PROPERTY2, "popularproductxpath")))
				.sendKeys(tc22locatorValue);

		List<WebElement> allkws = driver.findElements(By.xpath(tc22sbXpath));
		Actions action = new Actions(driver);
		Thread.sleep(1000);
		action.moveToElement(allkws.get(0)).perform();

		List<WebElement> allpop = driver
				.findElements(By.xpath(AutoUtility.getProperty(CONFIG_PROPERTY2, "pptextXpath1")));
		Thread.sleep(1000);
		String firstpop = allpop.get(0).getText();
		log.info(firstpop);
		Thread.sleep(1000);

		action.moveToElement(allkws.get(1)).perform();
		Thread.sleep(2000);
		List<WebElement> allpop1 = driver
				.findElements(By.xpath(AutoUtility.getProperty(CONFIG_PROPERTY2, "pptextXpath2")));
		String secondpop = allpop1.get(0).getText();
		log.info(secondpop);

		if (secondpop.contentEquals(firstpop)) {

			log.info("-----Testcase 22 Result: popular products are matching::-----FAIL");
			endResult1 = "FAIL";

		} else {
			log.info("-----Testcase 22 Result: Popular products are not matching::-----PASS");
			endResult2 = "PASS";
		}

		driver.findElement(By.name("q")).clear();
		// KEYBOARD WITH POPULAR PRODUCT MATCHING
		driver.findElement(By.name("q")).sendKeys("a");
		List<WebElement> allKeySuggestion = driver
				.findElements(By.xpath("//li[contains(@class,'unbxd-as-keysuggestion')]"));
		int count = allKeySuggestion.size();

		Actions a = new Actions(driver);
		a.moveToElement(allKeySuggestion.get(0)).perform();
		a.sendKeys(Keys.ARROW_DOWN).perform();
		a.sendKeys(Keys.ARROW_LEFT).perform();
		Thread.sleep(2000);
		String firstPop1 = driver.findElement(By.xpath("//input[@id='search']")).getAttribute("value");
		log.info(firstPop1);
		driver.findElement(By.name("q")).clear();
		driver.findElement(By.name("q")).sendKeys("a");
		Thread.sleep(1000);
		List<WebElement> allKeySuggestion1 = driver
				.findElements(By.xpath("//li[contains(@class,'unbxd-as-keysuggestion')]"));
		int count1 = allKeySuggestion.size();

		a.moveToElement(allKeySuggestion1.get(1)).perform();
		Thread.sleep(1000);
		a.sendKeys(Keys.ARROW_DOWN).perform();
		a.sendKeys(Keys.ARROW_LEFT).perform();
		String secondPop1 = driver.findElement(By.xpath("//input[@id='search']")).getAttribute("value");
		log.info(secondPop1);

		if (firstPop1.equals(secondPop1)) {
			log.info("Popular products are matching" + "Test case FAIL");
			endResult3 = "FAIL";
		} else {
			log.info("Popular products are not matching" + "Test case PASS");
			endResult4 = "PASS";
		}

		if (endResult1.equals(endResult3)) {
			log.info("22nd Test case is PASS");
		} else if (endResult2.equals(endResult4)) {
			log.info("22nd Test case is PASS");
		} else {
			log.info("22nd Test case is FAIL");
		}

		{
			log.info("22nd Test case is FAIL");
		}
	}

	// -----------------------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------
	
}