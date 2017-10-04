package script;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class KeyboardPopularProduct {
	static
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	@Test
	public void popularProduct() throws InterruptedException
	{
		
		WebDriver driver=new ChromeDriver();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.dickblick.com/");
		driver.findElement(By.id("unbxd_q")).sendKeys("paper");
		List<WebElement> all = driver.findElements(By.className("unbxd-as-keysuggestion"));
int	b=	all.size();
				System.out.println(b);
	
	
			}
	
	
}

