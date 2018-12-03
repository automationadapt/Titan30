package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseClasses.BaseTest;
import utility.TestUtil;

public class CreateProjectTest extends BaseTest
{

	@BeforeClass
	public static void fn_TechAdminLogin() throws InterruptedException
	{
		login("techadmin");
	}

	@Test(dataProvider = "getData")
	//, groups= {"createproject"}
	public void fn_CreateProjectTest(String ProjectCode, String ProjectName,
			String Departind, String OfficeInd, String Startdate,
			String Enddate, String AStartdate, String ProjectScope, String Type,
			String Industry, String Manager, String StackHolder, String Sponser,
			String Client, String AlertMessage, String DuplicateMSG,String DateValidation) throws InterruptedException
	{
		String msg= homeObj.fn_NavProjectlist().fn_NavCreateProject().
				fn_CreateProject(ProjectCode,
				ProjectName, Departind, OfficeInd, Startdate, Enddate,
				AStartdate, ProjectScope, Type, Industry, Manager, StackHolder,
				Sponser, Client, AlertMessage, DuplicateMSG, DateValidation);
		Assert.assertEquals(msg, AlertMessage);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		return TestUtil.getData("NewProject");
	}
	
//	@AfterClass
//	public void tearDown() 
//	{
//		// mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to,
//		// TestConfig.subject, TestConfig.messageBody,
//		// TestConfig.attachmentPath, TestConfig.attachmentName);
//		 driver.close();
//	}

}
