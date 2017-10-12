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
public class AutosuggestAndInfield2 extends BaseTest {
	// SINGLE AND WITHSPACE QUERIES
	@Test(priority = 2)
	public void EachLetter() throws IOException, InterruptedException {
		System.out.println("Testing:"+"SINGLE AND WITHSPACE QUERIES");
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

	// WITHOUT SPACE QUERIES
	@Test(priority = 3)
	public void withoutspace() throws IOException, InterruptedException {
		System.out.println("Testing:"+"WITHOUT SAPCE QUERIES");
		for (int i = 8; i <= 10; i++) {
			String y = Excel.getCellCalue(EXCEL_DATA, "Sheet3", i, 1);
			System.out.println(y);

			driver.findElement(By.xpath("//input[@id='search']")).sendKeys(y);
			Thread.sleep(5000);
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
			Thread.sleep(1000);

			driver.findElement(By.id("search")).clear();
		}
	}

	// AUTO SUGGEST IS COMING OR NOT
	@Test(priority = 1)
	public void autoSuggestIsComingOrNot() {
		System.out.println("Testing:"+"AUTO SUGGEST IS COMING OR NOT");
		String y = Excel.getCellCalue(EXCEL_DATA, "Sheet3", 0, 1);
		System.out.println(y);
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys(y);
		List<WebElement> total = driver.findElements(By.xpath("//div[@class='unbxd-as-popular-product-info']"));
		int totalSize = total.size();

		if (totalSize > 0) {
			System.out.println("Autosuggest Should display");
			System.out.println("Autosuggest coming for " + y + " letter :: PASS");
			System.out.println("------------------------------------------------");
		} else {
			System.out.println("Autosuggest Should not display");
			System.out.println("Autosuggest is not coming for " + y + " word :: FAIL");
			System.out.println("------------------------------------------------");
		}
		driver.quit();
	}

	// KEYWORD SUGGEST IS COMING OR NOT
	@Test(priority = 4)
	public void keywordSuggestionIsCommingorNot() {
		System.out.println("Testing:"+"KEYWORD SUGGEST IS COMING OR NOT");

		String y = Excel.getCellCalue(EXCEL_DATA, "Sheet3", 0, 1);
		System.out.println(y);
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys(y);
		List<WebElement> keywordSuggestion = driver.findElements(By.xpath("//li[@class='unbxd-as-keysuggestion']"));
		int k = keywordSuggestion.size();
		if (k > 0) {
			System.out.println("Keyword suggestion is Displaying");
			System.out.println("For Keyword suggestion Test-Case is PASS:");
		} else

		{
			System.out.println("Test-case is fails");
		}
		driver.quit();
	}

	// TEST WITH SPACE THEN ENTER
	@Test(priority = 5)
	public void spaceandEnter() throws InterruptedException {
System.out.println("Testing:"+"TEST WITH SPACE THEN ENTER");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys("   ");

		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@title='Search']")).click();
		String actualUrl = "https://www.moodfabrics.com/";
		String expectedURL = driver.getCurrentUrl();
		if (actualUrl.equals(expectedURL)) {
			System.out.println("TEST WITH SPACE THEN ENTER: Test case is: PASS");
		} else {
			System.out.println("TEST WITH SPACE THEN ENTER: Test case is: FAIL");
		}

		driver.quit();
	}
}