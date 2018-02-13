package script;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.multiset.SynchronizedMultiSet;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;

public class Test1 {
	static {
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
	}

	// Test whether Sort is working when we are copying the same URL in the new
	// tab
	@Test
	public void m() throws InterruptedException {
		System.out.println("Test whether Sort is working when we are copying the same URL in the new tab");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.moodfabrics.com/");	
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys("shirt");
		driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
		
		
		System.out.println("Selecting SORTBY");
		//collecting all SortBy options
		List<WebElement> highToLow = driver.findElements(By.xpath("//lable//select//option"));
		int allSortByOptions=highToLow.size();
		System.out.println(allSortByOptions);
		for(WebElement sortBy:highToLow)
		{
			System.out.println(sortBy.getText());
		}
		
		
		//Selecting HightoLow option from SortBy
			System.out.println("selecting the SortBy:high to low");
			driver.findElements(By.xpath("//lable//select//option")).get(1).click();
String currentURLdesc=driver.getCurrentUrl();
if(currentURLdesc.contains("desc"))
{
	System.out.println("High-Low is selected");
}
else
{
	System.out.println("High-Low is not selected");
}
Thread.sleep(2000);
List<WebElement> lowToHighselectedPrice1 = driver.findElements(By.xpath("//span[@class='price']"));
		int hl = lowToHighselectedPrice1.size();//hl=hightolow
		System.out.println(hl);
		for(WebElement ebb:lowToHighselectedPrice1)
		{
			System.out.println(ebb.getText());
		}

	System.out.println("---------------------------------------------");


	
	//Selecting LowtoHigh option from SortBy
		System.out.println("selecting the SortBy:low to high");
		driver.findElements(By.xpath("//lable//select//option")).get(2).click();
		Thread.sleep(2000);
String currentURLasc=driver.getCurrentUrl();
if(currentURLasc.contains("asc"))
{
System.out.println("Low-High is selected");
}
else
{
System.out.println("Low-High is not selected");
}
Thread.sleep(2000);
List<WebElement> lowToHighselectedPrice2 = driver.findElements(By.xpath("//span[@class='price']"));
	int lh = lowToHighselectedPrice2.size();
	System.out.println(lh);
	for(WebElement ebb:lowToHighselectedPrice2)
	{
		System.out.println(ebb.getText());
	}

	System.out.println("---------------------------------------------");

		
	//Selecting A-Z option from SortBy
	System.out.println("selecting the SortBy:A-Z");
	driver.findElements(By.xpath("//lable//select//option")).get(3).click();
	Thread.sleep(2000);
String currentURLascAZ=driver.getCurrentUrl();
if(currentURLascAZ.contains("asc"))
{
System.out.println("A-Z is selected");
}
else
{
System.out.println("A-Z is not selected");
}
Thread.sleep(2000);
List<WebElement> azSelected = driver.findElements(By.xpath("//h2[@class='product-name']"));
int az = azSelected.size();
System.out.println(az);
for(WebElement ebb:azSelected)
{
	System.out.println(ebb.getText());
}

System.out.println("---------------------------------------------");

//		NOT YET DONE
//Selecting Z-A option from SortBy
System.out.println("selecting the SortBy:A-Z");
driver.findElements(By.xpath("//lable//select//option")).get(4).click();
Thread.sleep(2000);
String currentURLascZA=driver.getCurrentUrl();
if(currentURLascZA.contains("desc"))
{
System.out.println("Z-A is selected");
}
else
{
System.out.println("Z-A is not selected");
}
Thread.sleep(2000);
List<WebElement> zaSelected = driver.findElements(By.xpath("//h2[@class='product-name']"));
int za = zaSelected.size();
System.out.println(za);
for(WebElement ebb:zaSelected)
{
System.out.println(ebb.getText());
}

System.out.println("---------------------------------------------");

	}
}