package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageclasses.MyDashboard;
import pageclasses.UpdateTask;
import utility.TestUtil;

public class UpdateTaskTest extends UpdateTask
{
	@BeforeClass
	public static void fn_TechAdminLogin() throws InterruptedException {
		login("pm");
	}
	
	@Test
	public void fn_UpdateTaskTest() throws InterruptedException
	{
		homeObj.fn_NavDashboard().fn_NavToTask().fn_UpdateTask();
	
	}
	
	
//	@DataProvider
//	public Object[][] getDataOne()
//	{
//		return TestUtil.getData("TaskStatus");
//	}

}
