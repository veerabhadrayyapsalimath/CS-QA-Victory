package page;

import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.AllPath;
import generic.BaseTest;
import generic.Excel;

public class LoginPage implements AllPath{
	public WebDriver driver;
	@FindBy(name="unbxd_q")
	private WebElement usernameTX;

	@FindBy(id="unbxdSubmit")
	private WebElement clickBT;
	
	
	//final String excelXpath1=Excel.getCellCalue(EXCEL_DATA, "Sheet1", 1, 0);
	@FindBy(xpath="//li[@class='unbxd-as-keysuggestion']")
	private List<WebElement> allAutoAdress;
	
	@FindBy(xpath="//div[@class='unbxd-as-popular-product-name']")
	private List<WebElement> allpopular;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	PageFactory.initElements(driver, this);	
	}
	
	
	public void setSearchBox(String searchText)
	{
		usernameTX.sendKeys(searchText);
	}
	
	public void setClick()
	{
		clickBT.click();
	}
	
	public void selectsuggestion(List<WebElement> allAutoAdress, int i)
	{
	
		Actions action=new Actions(driver);	
		
		action.moveToElement(allAutoAdress.get(i)).perform();

	}
	
	public int getAutosuggestionSize()
	{
	return	getAllAutoAdress().size();
	}

public void setClear()
{
	usernameTX.clear();
}


public String selectfirstPopular(List<WebElement> allpopular)
{
	
return	allpopular.get(0).getText();
	
	
}


public List<WebElement> getAllAutoAdress() {
	return allAutoAdress;
}


public void setAllAutoAdress(List<WebElement> allAutoAdress) {
	this.allAutoAdress = allAutoAdress;
}


public List<WebElement> getAllpopular() {
	return allpopular;
}


public void setAllpopular(List<WebElement> allpopular) {
	this.allpopular = allpopular;
}
}
