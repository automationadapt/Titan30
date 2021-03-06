package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseClasses.BaseTest;
import pageclasses.CreateTaskPage;
import pageclasses.HomePageHeader;
import pageclasses.ProjectDetail;
import utility.TestUtil;

public class CreateTaskTest extends CreateTaskPage {
	
	@BeforeClass
	public static void fn_TechAdminLogin() throws InterruptedException {
//		StartBrowser();
		login("techadmin");
	}

	@Test(dataProvider = "getDataOne")
	public void fn_CreateTaskTest(String TaskName, String Description, String StartDate,String DueDate, String Priority, String Msg) throws InterruptedException
	{
		String alertMsg= homeObj.fn_NavProjectlist().fn_navProjectDetails().fn_NavProjectTask().fn_CreateTask(TaskName, Description, StartDate, DueDate, Priority);
		Assert.assertEquals(Msg, alertMsg );
	
	}
	
	@DataProvider
	public Object[][] getDataOne()
	{
		return TestUtil.getData("NewTask");
	}
	

//	@AfterClass
//	public void tearDown() 
//	{
//		// mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to,
//		// TestConfig.subject, TestConfig.messageBody,
//		// TestConfig.attachmentPath, TestConfig.attachmentName);
//		 driver.quit();
//	}

}
