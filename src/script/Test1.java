package script;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;

public class Test1 extends BaseTest {

	@Test
	public void m() {

		log.info("reading data from excel");
		String locatorValue = Excel.getCellCalue(EXCEL_DATA, "Sheet1", 1, 0);
		String action= Excel.getCellCalue(EXCEL_DATA, "Sheet1", 1, 1);
		String input= Excel.getCellCalue(EXCEL_DATA, "Sheet1", 1, 2);
		
		if(action.equals("type"))
		{
			
	 driver.findElement(By.name(locatorValue)).sendKeys(input);
	
		}
		else
			
			if(action.equals("click"))
		{
				 driver.findElement(By.name(locatorValue)).click();
					
		}
			else 
				if(action.equals("clear"))
				{
					driver.findElement(By.name(locatorValue)).clear();
				}
		log.info("hi");
		
	}

}
