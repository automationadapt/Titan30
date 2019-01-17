package pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import BaseClasses.BaseTest;

public class HomePageHeader extends BaseTest {


	public static ProjectList fn_NavProjectlist(){
		
		wait.until(
				ExpectedConditions.visibilityOf(driver.findElement(By.xpath(OR.getProperty("MenuDirectory_XPATH")))));
		click("MenuDirectory_XPATH");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(OR.getProperty("LinkProject_XPATH")))));
		actObj.click(driver.findElement(By.xpath(OR.getProperty("LinkProject_XPATH")))).build().perform();
		System.out.println("After Project Link Click");
		waitforProgressBar();
		ProjectList ObjProjectList = new ProjectList();
		return ObjProjectList;
	}
	 
	public static MyDashboard fn_NavDashboard () {
		wait.until(
				ExpectedConditions.visibilityOf(driver.findElement(By.xpath(OR.getProperty("MyDashBoard_XPATH")))));
		click("MyDashBoard_XPATH");
//		waitforProgressBar();
		MyDashboard objDashboard= new MyDashboard();
		return objDashboard; 
	}

	
	
}
