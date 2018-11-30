package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageclasses.HomePageHeader;
import pageclasses.ProjectTeam;
import utility.TestUtil;

public class ProjectTeamTest extends ProjectTeam{
	
//	@BeforeClass
//	public static void fn_TechAdminLogin() throws InterruptedException {
//		login("techadmin");
//	}

	@Test(dataProvider = "getDataOne")
	public void fn_AddTeamMember(String startdate,String releasedate) throws InterruptedException
	{
		new HomePageHeader().fn_NavProjectlist().fn_navProjectDetails().fn_NavProjectTeam().fn_AddNewTeamMemeber(startdate, releasedate);
	
	}
	
	
	@DataProvider
	public Object[][] getDataOne()
	{
		return TestUtil.getData("ProjectTeam");
	}
	
	
}
