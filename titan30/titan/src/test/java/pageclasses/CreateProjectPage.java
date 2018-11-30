package pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import BaseClasses.BaseTest;

public class CreateProjectPage extends BaseTest
{

	String actualAlertText;

	public String fn_CreateProject(String ProjectCode, String ProjectName,
			String Departind, String OfficeInd, String Startdate,
			String Enddate, String AStartdate, String ProjectScope, String Type,
			String Industry, String Manager, String StackHolder, String Sponser,
			String Client, String AlertMessage, String DuplicateMSG,
			String DateValidation) throws InterruptedException
	{
	
		type("ProjectCodeTB_ID", ProjectCode);
		driver.findElement(By.id(OR.getProperty("ProjectCodeTB_ID"))).sendKeys(Keys.TAB);
		actualAlertText = meancheck();
		if (actualAlertText.isEmpty())
		{
			type("ProjectNameTB_ID", ProjectName);
			actualAlertText = meancheck();
			if (actualAlertText.isEmpty())
			{
				Select("ConcernDepartSelect_ID", Departind);
				actualAlertText = meancheck();
				if (actualAlertText.isEmpty())
				{
					Select("ConcernOfficeSelect_ID", OfficeInd);
					actualAlertText = meancheck();
					if (actualAlertText.isEmpty())
					{
						dateselect("StartDateTB_XPATH", Startdate);
						actualAlertText = meancheck();
						if (actualAlertText.isEmpty())
						{
							dateselect("EndDateTB_XPATH", Enddate);
							dateselect("ActualStartDateTB_XPATH", AStartdate);
							type("ProjectScopeTB_ID", ProjectScope);
							type("ProjectTypeTB_ID", Type);
							type("ClientIndustryTB_ID", Industry);
							Select("ProjectManagerSelecvt_XPATH", Manager);
							Select("StackHolderSelect_XPATH", StackHolder);
							Select("ProjSponserSelect_XPATH", Sponser);
							type("ClientNameTB_ID", Client);
							click("SubmitBTN_XPATH");
							wait.until(ExpectedConditions.alertIsPresent());
							String actualAlertText = driver.switchTo().alert()
									.getText();
							driver.switchTo().alert().accept();
							waitforProgressBar();
							return actualAlertText;
						}
					}
				}
			}
		}

		else
		{
			// System.out.println(actualAlertText+ " before Within Method");
			return actualAlertText;

		}
		System.out.println(actualAlertText + "Within Method");
		return actualAlertText;
	}

	public String meancheck()
	{
		if (isAlertPresent())
		{
			String msg = driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			// System.out.println(msg);
			return msg;
		} else
		{
			return "";
		}
	}

	public boolean isAlertPresent()
	{
		try
		{
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException Ex)
		{
			return false;
		}
	}

	public String fn_DuplicateIDValidation(String ProjectCode,
			String ProjectName, String Departind, String OfficeInd,
			String Startdate, String Enddate, String AStartdate,
			String ProjectScope, String Type, String Industry, String Manager,
			String StackHolder, String Sponser, String Client,
			String AlertMessage, String DuplicateMSG, String DateValidation)
			throws InterruptedException
	{

		driver.findElement(By.xpath("//button[@id='CreateProject']")).click();
		waitforProgressBar();
		type("ProjectCodeTB_ID", ProjectCode);
		driver.findElement(By.id(OR.getProperty("ProjectCodeTB_ID")))
				.sendKeys(Keys.TAB);
		String text = waitForAlertwithText();
		// System.out.println(text);
		return text;
	}

	public String fn_DuplicateNameValidation(String ProjectCode,
			String ProjectName, String Departind, String OfficeInd,
			String Startdate, String Enddate, String AStartdate,
			String ProjectScope, String Type, String Industry, String Manager,
			String StackHolder, String Sponser, String Client,
			String AlertMessage, String DuplicateMSG, String DateValidation)
			throws InterruptedException
	{

		driver.findElement(By.xpath("//button[@id='CreateProject']")).click();
		waitforProgressBar();
		type("ProjectCodeTB_ID", ProjectCode + "79");
		type("ProjectNameTB_ID", ProjectName);
		driver.findElement(By.id(OR.getProperty("ProjectNameTB_ID")))
				.sendKeys(Keys.TAB);
		String text = waitForAlertwithText();
		// System.out.println(text);
		return text;
	}
}
