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

import generic.Excel;

//import org.apache.log4j.Logger;
public class AutosuggestAndInfield {
	WebDriver driver=new ChromeDriver();
	//public Logger log = Logger.getLogger(this.getClass());
	//Logger log = Logger.getLogger(this.getClass());
	static{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe" );
	}
	//9 Autosuggest test-cases
	@Test(priority=1)
  public void EachLetter() throws IOException, InterruptedException {
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.manage().window().maximize();
		 driver.get("https://www.moodfabrics.com/");
	
	//	driver.findElement(By.xpath("//a[contains(.,'Thanks')]")).click();

	/*FileInputStream fi=new FileInputStream("D:\\bbb1.xls");
		Workbook wb=Workbook.getWorkbook(fi);
		Sheet sh=wb.getSheet("Sheet1");*/

		/*for(int i=1;i<=11;i++)
		{*/
			

		 //x=sh.getCell(0,i).getContents();
			//System.out.println("Searched query is:"+x);
		 Thread.sleep(1000);
		//String y= Excel.getCellCalue("EXCEL_DATA", "Sheet3", 0, 0);
		// Thread.sleep(1000);
		 driver.findElement(By.xpath("//input[@id='search']")).sendKeys("sh");
		 Thread.sleep(5000);
		try
		{
		String actul = driver.findElements(By.xpath("//li[contains(@class,'header')]")).get(1).getText();
		System.out.println(actul);
		String exp="Suggestions";
		String exp1="Popular";
			
		if(actul.contains(exp)|actul.contains(exp1))
		{
			System.out.println("Autosuggest Should display");
			System.out.println("Autosuggest Displaying for "+"y"+" letter :: PASS");
			System.out.println("------------------------------------------------");
		}
		else
		    {
			System.out.println("Autosuggest Should display");
			System.out.println("Autosuggest is not displaying for "+"y"+" word :: FAIL");
			System.out.println("------------------------------------------------");
		    }
		}
		catch(Exception e)
		{
			System.out.println("Autosuggest Should not display");
		System.out.println("Autosuggest is not displaying for "+"y"+" word :: PASS");
		System.out.println("------------------------------------------------");
		}
		Thread.sleep(1000);
		
//		driver.findElement(By.id("search")).clear();
	
		/*}*/
	
  }


}
