package utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import BaseClasses.BaseTest;

public class TestUtil extends BaseTest
{

	public static String fileName;

	public static void captureScreenshot() throws IOException
	{
		
		Date date = new Date();
		fileName = date.toString().replace(" ", "_").replace(":", "_") + ".jpg";
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")
				+ "/target/surefire-reports/html/" + fileName));
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")
				+ "/target/surefire-reports/" + fileName));
		
	}

	
	public static Object[][] getData(String sheetName)
	{
		int rowNum = excel.getRowCount(sheetName);
		int colNum = excel.getColumnCount(sheetName);
		Object[][] data = new Object[rowNum - 1][colNum];

		for (int rows = 2; rows <= rowNum; rows++)
		{
			for (int cols = 0; cols < colNum; cols++)
			{
				data[rows - 2][cols] = excel.getCellData(sheetName, cols, rows);
			}
		}

		return data;

	}

}
