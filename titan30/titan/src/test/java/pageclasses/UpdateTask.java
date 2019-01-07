package pageclasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BaseClasses.BaseTest;

public class UpdateTask extends BaseTest
{
	public void fn_UpdateTask(){
		
		List projectList= driver.findElements(By.xpath("ProjectNames_XPATH")); 
		System.out.println(projectList);
//		for (WebElement webElement : projectList)
//		{
//			System.out.println(webElement);
//		}
		System.out.println("Test Update task Execution");
	}
	
	

}
