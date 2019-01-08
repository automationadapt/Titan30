package pageclasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import BaseClasses.BaseTest;

public class UpdateTask extends BaseTest
{
	public void fn_UpdateTask(String projectName, String taskName,
			String status) throws InterruptedException
	{

		System.out.println(projectName+ "Call" );
	
//		wait.until(ExpectedConditions.visibilityOf(driver
//				.findElement(By.xpath("//table[@id='TempTableTasksInbox']"))));
//
//		List<WebElement> projectList = driver
//				.findElements(By.xpath(OR.getProperty("ProjectNames_XPATH")));
//
//		for (WebElement projectname : projectList)
//		{
//
//			if (projectname.getText().equals(projectName))
//			{
//					
//				List<WebElement> taskList = driver.findElements(
//						By.xpath(OR.getProperty("TaskName_XPATH")));
//				for (WebElement taskname : taskList)
//				{
//					if (taskname.getText().equals(taskName))
//					{
//						System.out.println(projectname.getText());}
//					// List<WebElement> ActionLinkList=
//					// driver.findElements(By.xpath(OR.getProperty("Action_XPATH")));
//				}
//
//			}
//		

//		}

	}

}
