package script;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import generic.BaseTest;
import generic.Excel;

//import org.apache.log4j.Logger;
public class AutosuggestAndInfield extends BaseTest {
//SINGLE AND WITHSPACE QUERIES
	@Test(priority = 1)
	public void EachLetter() throws IOException, InterruptedException {

		for (int i = 0; i <= 7; i++) {
			String y = Excel.getCellCalue(EXCEL_DATA, "Sheet3", i, 1);
			System.out.println(y);

			driver.findElement(By.xpath("//input[@id='search']")).sendKeys(y);
			Thread.sleep(5000);
			try {
				List<WebElement> total = driver.findElements(By.xpath("//div[@class='unbxd-as-popular-product-info']"));

				int totalSize = total.size();

				if (totalSize > 0) {
					System.out.println("Autosuggest is displayed");
					System.out.println("Autosuggest Displaying for " + "y" + " letter :: PASS");
					System.out.println("------------------------------------------------");
				} else {
					System.out.println("Autosuggest is displayed");
					System.out.println("Autosuggest is not displaying for " + "y" + " word :: FAIL");
					System.out.println("------------------------------------------------");
				}

			} catch (Exception e) {
				System.out.println("Autosuggest is not displayed");
				System.out.println("Autosuggest is not displaying for " + "y" + " word :: PASS");
				System.out.println("------------------------------------------------");
			}
			Thread.sleep(1000);

			driver.findElement(By.id("search")).clear();
		}
	}
//WITHOUT SPACE QUERIES
	@Test(priority = 2)
	public void withoutspace() throws IOException, InterruptedException {

		for (int i = 8; i <= 10; i++) {
			String y = Excel.getCellCalue(EXCEL_DATA, "Sheet3", i, 1);
			System.out.println(y);

			driver.findElement(By.xpath("//input[@id='search']")).sendKeys(y);
			Thread.sleep(5000);
			/*
			 * try {
			 */
			List<WebElement> total = driver.findElements(By.xpath("//div[@class='unbxd-as-popular-product-info']"));

			int totalSize = total.size();

			if (totalSize > 0) {
				System.out.println("Autosuggest is displayed");
				System.out.println("Autosuggest is Displaying for " + y + " letter :: FAIL");
				System.out.println("------------------------------------------------");
			} else {
				System.out.println("Autosuggest is displayed");
				System.out.println("Autosuggest is not displaying for " + y + " word :: PASS");
				System.out.println("------------------------------------------------");
			}

			/*
			 * } catch (Exception e) { System.out.println(
			 * "Autosuggest is not displayed"); System.out.println(
			 * "Autosuggest is not displaying for " + "y" + " word :: PASS");
			 * System.out.println(
			 * "------------------------------------------------"); }
			 */
			Thread.sleep(1000);

			driver.findElement(By.id("search")).clear();
		}
	}

}
