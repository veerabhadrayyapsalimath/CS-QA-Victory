package script;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.AutoUtility;
import generic.BaseTest;
import generic.Excel;

public class MaPbyMouseandKeyboard extends BaseTest {
	public String tc22sbXpath;
	public String ppid;
	String prev = null;
	String pop = null;
	String endResult1 = null;
	String endResult2 = null;
	String endResult3 = null;
	String endResult4 = null;

	@Test(priority = 1)
	public void popularProductMouse() throws InterruptedException {
		log.info("--------------------Testcase 22 is Running-------------------");
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

		/*
		 * action.moveToElement(allkws.get(2)).perform(); Thread.sleep(2000);
		 * List<WebElement> allpop2 =
		 * driver.findElements(By.xpath(AutoUtility.getProperty(
		 * CONFIG_PROPERTY2, "pptextXpath2"))); String thirdPop =
		 * allpop1.get(0).getText(); log.info(thirdPop);
		 */

		if (secondpop.contentEquals(firstpop)) {

			log.info("-----Testcase 22 Result: popular products are matching::-----FAIL");
			endResult1 = "FAIL";

		} else {
			log.info("-----Testcase 22 Result: Popular products are not matching::-----PASS");
			endResult2 = "PASS";
		}

		driver.findElement(By.name("q")).clear();
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
		} else /*if (endResult2.equals(endResult4))
		{
			log.info("22nd Test case is PASS");
		} else {
			log.info("22nd Test case is FAIL");
		}*/
		{
			log.info("22nd Test case is FAIL");
		}
	}

}
