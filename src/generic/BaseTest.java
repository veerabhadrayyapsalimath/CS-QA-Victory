package generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
public class BaseTest implements AllPath {

	public WebDriver driver;
	public Logger log = Logger.getLogger(this.getClass());
	public String strUrl;
public long implicit;
	@BeforeSuite
	public void setProperty()
	{
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}
	@Parameters({"browser"})
@BeforeMethod()
public void openSite(@Optional("firefox")String browser)
{
		driver=new ChromeDriver();
		log.info("opening the browser");
		driver.manage().window().maximize();
		log.info("maximize the window");
		strUrl=AutoUtility.getProperty(CONFIG_PROPERTY, "url");
	driver.get(strUrl);
	log.info("entered the url");
String x=AutoUtility.getProperty(CONFIG_PROPERTY, "implicit");	
long implicitw= Long.parseLong(x);
driver.manage().timeouts().implicitlyWait(implicitw, TimeUnit.SECONDS);
}
	
}
