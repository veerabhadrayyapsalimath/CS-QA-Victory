package generic;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
public class Excel {
	public static int getRow(String path, String sheet)
	{
		int row=0;
		FileInputStream file;
		try
		{
			file=new FileInputStream(path);
			Workbook wb=WorkbookFactory.create(file);
	row=	wb.getSheet(sheet).getLastRowNum();
		}
		catch(Exception e)
		{
			
		}
		return row;
	}
	
	
	public static String getCellCalue(String path, String sheet, int r, int c)
	{
		String col=" ";
		FileInputStream file;
		try
		{
			file=new FileInputStream(path);
			Workbook wb=WorkbookFactory.create(file);
	col=	wb.getSheet(sheet).getRow(r).getCell(c).toString();
		}
		catch(Exception e)
		{
			
		}
		return col;
	}
	
	
}