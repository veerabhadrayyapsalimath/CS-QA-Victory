package script;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import generic.BaseTest;

public class KeyboardPopularProduct extends BaseTest {
	@Test
	public void popularProduct()
	{
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.moodfabrics.com/");
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("");
	}
	
	
}
