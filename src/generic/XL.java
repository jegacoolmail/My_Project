package generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class XL {
	
	public static String getCellValue(String path,String sheet, int r, int c)
	{
		String v="";
		try
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			v = wb.getSheet(sheet).getRow(r).getCell(c).toString();
		}
		catch(Exception e)
		{
			
		}
		return v;
	}
	
	public static int getRowCount(String path, String sheet)
	{
		int rc=0;
		try
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			rc = wb.getSheet(sheet).getLastRowNum();
		}
		catch(Exception e)
		{
			
		}
		return rc;
	}
	
	public static int getCellCount(String path, String sheet, int rc)
	{
		int cc=0;
		try
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			cc = wb.getSheet(sheet).getRow(rc).getLastCellNum();
		}
		catch(Exception e)
		{
			
		}
		return cc;
	}
	
	public static void setCellData(String path,String sheet, int r,int c,String data)
	{
		try
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			wb.getSheet(sheet).getRow(r).getCell(c).setCellValue(data);
			wb.write(new FileOutputStream(path));
		}
		catch(Exception e)
		{
			
		}
	}
}