package script;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import generic.AutoUtility;
import generic.BaseTest;
import generic.Excel;

public class MaPbyKeyboard extends BaseTest{

	//public Logger log = Logger.getLogger(this.getClass());
	/*static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}

*/	
	String endResult3;
	String endResult4;
	@Test
	public void enterPop() throws InterruptedException {
		/*WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.moodfabrics.com/");*/
		driver.findElement(By.name("q")).sendKeys("a");
		List<WebElement> allKeySuggestion = driver.findElements(By.xpath("//li[@class='unbxd-as-keysuggestion']"));
		int count = allKeySuggestion.size();
	
		Actions a = new Actions(driver);
		a.moveToElement(allKeySuggestion.get(0)).perform();
		a.sendKeys(Keys.ARROW_DOWN).perform();
		a.sendKeys(Keys.ARROW_LEFT).perform();
		Thread.sleep(2000);
		String firstPop = driver.findElement(By.xpath("//input[@id='search']")).getAttribute("value");
		log.info(firstPop);
	
		a.moveToElement(allKeySuggestion.get(1)).perform();
		//a.sendKeys(Keys.ARROW_DOWN).perform();
		a.sendKeys(Keys.ARROW_LEFT).perform();
		Thread.sleep(2000);
		String secondPop = driver.findElement(By.xpath("//input[@id='search']")).getAttribute("value");
		log.info(secondPop);
	
		if(firstPop.equals(secondPop))
		{
			log.info("Popular products are matching"+"Tst case FAIL");
			endResult3 = "FAIL";
		}
		else
		{
			log.info("Popular products are not matching"+"Tst case PASS");	
			endResult4 = "PASS";
		}
	
}

}
