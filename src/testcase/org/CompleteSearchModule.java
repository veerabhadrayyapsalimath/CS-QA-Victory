package testcase.org;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
//import org.apache.log4j.Logger;

import generic.AutoUtility;
import generic.BaseTest;
import generic.Excel;

public class CompleteSearchModule extends BaseTest {

	// Check whether place holder inside search box is displaying or not
	@Test(priority = 12)
	public void TestPlaceHolderIsPresentOrNot() {
		String x = driver.findElement(By.xpath(AutoUtility.getProperty(CONFIG_PROPERTY2, "searchbox")))
				.getAttribute("placeholder");
		System.out.println(x);
		if (x.contains("Search")) {
			log.info("Place holder text is::" + x);
			log.info("Place holder is present::" + "TEST CASE PASS");
			driver.quit();
		} else {
			log.info("Place holder is not present::" + "TEST CASE PASS");
			driver.quit();
		}
	}
	// ---------------------------------------------------------------------------------------------------------------
//---------------------
	// Don't Enter any query and click on search button::Should not work
	@Test(priority = 13)
	public void DontEnterAnyQueryandClickonSearchButton() {
		log.info("Don't Enter any query and click on search  button::Should not work");
		// clickin on search icon
		String beforeURL = driver.getCurrentUrl();
		driver.findElement(By.xpath(AutoUtility.getProperty(CONFIG_PROPERTY2, "searchicon"))).click();
		String afterURL = driver.getCurrentUrl();
		Assert.assertEquals(afterURL, beforeURL);
		driver.quit();
	}

	// ---------------------------------------------------------------------------------------------------------------
	
	// Test for Search term::Entered query should display in search box
	@Test(priority = 14)
	public void EnteredQueryShouldDisplayInSearchBox() {
		String y = Excel.getCellCalue(EXCEL_DATA, "Sheet3", 8, 1);
		log.info(y);
		// taking query from excel and passing inside the search box
		driver.findElement(By.xpath(AutoUtility.getProperty(CONFIG_PROPERTY2, "searchbox"))).sendKeys(y);
		String z = driver.findElement(By.xpath(AutoUtility.getProperty(CONFIG_PROPERTY2, "searchbox")))
				.getAttribute("value");
		Assert.assertEquals(z, y);
		driver.quit();
	}
	// ---------------------------------------------------------------------------------------------------------------
	
	// Test whether search button is working -- should display in SRP or zero
	// result page
	@Test(priority = 15)
	public void TestWhetherSearchButtonIsWorking() throws InterruptedException {
		for (int i = 3; i <= 8; i++) {
			// Thread.sleep(2000);
			String x = driver.getCurrentUrl();
			String y = Excel.getCellCalue(EXCEL_DATA, "Sheet3", i, 1);
			log.info(y);
			// taking query from excel and passing inside the search box
			driver.findElement(By.xpath(AutoUtility.getProperty(CONFIG_PROPERTY2, "searchbox"))).sendKeys(y);
			// driver.findElement(By.xpath("//input[@id='search']")).sendKeys("table");
			driver.findElement(By.xpath("//button[@title='Search']")).click();
			Thread.sleep(2000);
			String z = driver.getCurrentUrl();
			if (z.equals(x)) {
				log.info("Not Showing SRP or zero result page::" + "TEST CASE FAIL");

				driver.findElement(By.xpath(AutoUtility.getProperty(CONFIG_PROPERTY2, "searchbox"))).clear();
			} else {
				log.info("Showing SRP or zero result page::" + "TEST CASE PASS");
				driver.findElement(By.xpath(AutoUtility.getProperty(CONFIG_PROPERTY2, "searchbox"))).clear();
			}
		}
		driver.quit();
	}
	// ---------------------------------------------------------------------------------------------------------------

	// Test wheher invalid data is working as per the expected output::Should
	// display Zero results page
	@Test(priority = 16)
	public void invalidDataIsWorkingAsPerTheExpectedOutput() {
		String y = Excel.getCellCalue(EXCEL_DATA, "Sheet3", 8, 1);
		log.info(y);
		log.info("Test wheher invalid data is working as per the expected output::Should display Zero results page");
		// taking query from excel and passing inside the search box
		driver.findElement(By.xpath(AutoUtility.getProperty(CONFIG_PROPERTY2, "searchbox"))).sendKeys(y);
		// clickin on search icon
		driver.findElement(By.xpath(AutoUtility.getProperty(CONFIG_PROPERTY2, "searchicon"))).click();
		// getting the text of zero result text from zero results page
		String noresult = driver.findElement(By.xpath(AutoUtility.getProperty(CONFIG_PROPERTY2, "zerpResultText")))
				.getText();
		// String
		// noresult=driver.findElement(By.xpath("//h2[@id='unbxd_no_results']")).getText();
		if (noresult.contains("NO RESULT")) {
			log.info("Showing zero result page::" + "TEST CASE PASS");
			driver.quit();
		} else {
			log.info("Not Showing zero result page" + "TEST CASE FAIL");
			driver.quit();
		}
	}
	// -----------------------------------------------------------------------------------------------------------------
	
}