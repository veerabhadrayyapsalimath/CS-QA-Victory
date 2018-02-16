package testcase.org;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Test3 {
	static
	{
		System.setProperty("webdriver.gecko.driver", "driver/geckodriver.exe");
	}
	@Test
	public void sort_AjaxExample() throws InterruptedException
	{

		//create chrome instance
		 WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.moodfabrics.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys("bolt");
		
		driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
	String x= driver.findElement(By.xpath("//lable[@class='sort-title']")).getText();
		System.out.println(x);
		
	
	//	List<WebElement> g=		driver.findElements(By.xpath("//select"));
		
		
	  List<WebElement> g = driver.findElements(By.xpath("//option[contains(@value,'c')]"));
	System.out.println(g.size());
	
	for(WebElement a:g)
	{

		System.out.println(a.getAttribute("unbxdsortfield"));
	}
	driver.findElement(By.xpath("//lable[@class='sort-title']")).click();
	String q=driver.getCurrentUrl();
	System.out.println(q);
	
driver.findElements(By.xpath("//option[contains(@value,'c')]")).get(0).click();
Thread.sleep(2000);
String w=driver.getCurrentUrl();
if(q.equals(w))
{
	System.out.println("PASS");
}
else
{
	System.out.println("FAIL");
}
	
		
		
		
	}
	}
