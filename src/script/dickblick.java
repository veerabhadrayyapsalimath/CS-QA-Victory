package script;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import generic.AutoUtility;
import generic.BaseTest;
import generic.Excel;

public class dickblick extends BaseTest {
	public String tc22sbXpath;
	public String ppid;

	@Test
	public void mm() throws InterruptedException {
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

		if (secondpop.contentEquals(firstpop)) {
			log.info("-----Testcase 22 Result: popular products are matching::-----FAIL");

		} else {
			log.info("-----Testcase 22 Result: Popular products are not matching::-----PASS");
		}

	}

}
