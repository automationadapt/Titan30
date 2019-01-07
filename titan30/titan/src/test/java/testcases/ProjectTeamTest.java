package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageclasses.ProjectTeam;
import utility.TestUtil;

public class ProjectTeamTest extends ProjectTeam{
	
	@BeforeClass
	public static void fn_TechAdminLogin() throws InterruptedException {
//		StartBrowser();
		login("techadmin");
	}

	@Test(dataProvider = "getDataOne")
	public void fn_AddTeamMember(String startdate,String releasedate) throws InterruptedException
	{
		homeObj.fn_NavProjectlist().fn_navProjectDetails().fn_NavProjectTeam().fn_AddNewTeamMember(startdate, releasedate);
	}
	
	
	@DataProvider
	public Object[][] getDataOne()
	{
		return TestUtil.getData("ProjectTeam");
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
