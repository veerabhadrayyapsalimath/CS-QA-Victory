package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import page.LoginPage;

public class AutoSuggestTest extends BaseTest{

	
	@Test
	public void autoSuggest()
	{

		LoginPage login=new LoginPage(driver);
		
		login.setSearchBox(Excel.getCellCalue(EXCEL_DATA, "Sheet3", 1, 0));
		
		
	}
	
}
