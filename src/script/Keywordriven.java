package script;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import generic.AutoUtility;
import generic.BaseTest;
import generic.Excel;
import page.LoginPage;

public class Keywordriven extends BaseTest{
	public String tc22sbXpath;
	public String ppid;
	String prev = null;
	String pop = null;
	
	@Test()
public void getExcel() throws InterruptedException
{
	
		LoginPage login=new LoginPage(driver);
		login.setClear();
		login.setSearchBox(Excel.getCellCalue(EXCEL_DATA, "dickblick", 1, 0));
		log.info("--------------------Testcase 22 is Running-------------------");
		String prev=null;
		String prev2=null;
		
		for(int i=0;i<=login.getAutosuggestionSize()-1;i++)
		{
		Thread.sleep(1000);
		login.selectsuggestion(login.getAllAutoAdress(), i);
		String presentpop=login.selectfirstPopular(login.getAllpopular());
		log.info(presentpop);
		if(prev2==presentpop || prev==presentpop){
			log.info("pop matches");
		}

		else
			prev2=prev;
			prev=presentpop;
		
		log.info("pop doesn't matches");
			
		}
		
		
		
		
		/*
		driver.findElement(By.xpath(AutoUtility.getProperty(CONFIG_PROPERTY2, "popularproductxpath"))).clear();
		String tc22locatorValue = Excel.getCellCalue(EXCEL_DATA, "dickblick", 1, 0);
		tc22sbXpath = AutoUtility.getProperty(CONFIG_PROPERTY2, "tc22kwsXpath");
		driver.findElement(By.xpath(AutoUtility.getProperty(CONFIG_PROPERTY2, "popularproductxpath"))).sendKeys(tc22locatorValue);

		List<WebElement> allkws = driver.findElements(By.xpath(tc22sbXpath));
		List<WebElement> allpop = driver.findElements(By.xpath(AutoUtility.getProperty(CONFIG_PROPERTY2, "pptextXpath1")));
		Actions action = new Actions(driver);
		int count = allkws.size();
		Boolean flag=true;
		for (int i = 0; i <= count; i++) {
			Thread.sleep(1000);

			action.moveToElement(allkws.get(i)).perform();
			Thread.sleep(1000);
			for (int j = 0; j <= 0; j++) {
				Thread.sleep(1000);
				pop = allpop.get(0).getText();
				Thread.sleep(1000);
				if (prev != null && pop == prev){	 
					flag=false;	
					log.info("popular are matching");
						
						if(flag=true){
					
					log.info("not matching");
				}			
			}
			}				
			prev=pop;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
*/		
		
}
	
	
}
