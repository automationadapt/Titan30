package pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import BaseClasses.BaseTest;

public class ProjectDetail extends BaseTest {
	
	public static CreateTaskPage fn_NavProjectTask() throws InterruptedException{
		actObj.moveToElement(driver.findElement(By.xpath(OR.getProperty("TaskTab_XPATH")))).click().build().perform();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(OR.getProperty("NewTaskButton_XPATH"))))); 
		click("NewTaskButton_XPATH");
		System.out.println("wait after create task click");
		waitforProgressBar();
		CreateTaskPage objCreateTaskPage= new CreateTaskPage();
		return objCreateTaskPage; 
	}

	public static ProjectTeam fn_NavProjectTeam() {
//		waitforProgressBar();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(OR.getProperty("TeamTab_XPATH")))));
		actObj.moveToElement(driver.findElement(By.xpath(OR.getProperty("TeamTab_XPATH")))).click().build().perform();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(OR.getProperty("AddMoreBTN_XPATH")))));
		ProjectTeam proObj= new ProjectTeam();
		return proObj; 
	}

}
