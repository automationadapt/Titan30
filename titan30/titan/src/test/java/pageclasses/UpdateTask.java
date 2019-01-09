package pageclasses;

import java.util.List;

import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import BaseClasses.BaseTest;





public class UpdateTask extends BaseTest
{

	public void fn_UpdateStatus (String projectName,String taskName,String status) throws InterruptedException {
		
		int i =fn_GetRespectiveRow(projectName, taskName); 
		driver.findElement(By.xpath("//*[@id=\"TempTableTasksInbox\"]/tbody/tr["+i+"]/td[10]/a")).click();
		if (status.equalsIgnoreCase("Completed"))
		{
				
		} else if (status.equalsIgnoreCase("Hold") || status.equalsIgnoreCase("Cancelled"))
		{
			
		}
		
	}
	
	
	
	
	public int fn_GetRespectiveRow(String projectName, String taskName
			) throws InterruptedException
	{
		int i = 0;
		wait.until(ExpectedConditions.visibilityOf(driver
				.findElement(By.xpath("//table[@id='TempTableTasksInbox']"))));

		List<WebElement> projectList = driver
				.findElements(By.xpath(OR.getProperty("ProjectNames_XPATH")));
		outerloop:

		for (int j = 0; j < projectList.size(); j++)
		{
			i = 0;
			WebElement projectname = projectList.get(j);
			List<WebElement> taskList = driver
					.findElements(By.xpath(OR.getProperty("TaskName_XPATH")));
			for (int k = 0; k < taskList.size(); k++)
			{
				WebElement taskname = taskList.get(k);
				i = i + 1;
				if (projectname.getText().equals(projectName)
						&& taskname.getText().equals(taskName))
				{
					System.out.println("Outer Loop: " + taskname.getText());
					System.out.println("Inner Loop: " + projectname.getText());
					System.out
							.println("Final Result: " + projectname.getText());

					break outerloop;
				}

			}
		}
		System.out.println("Values of I :" + i);
		return i;
	}
}
