package pageclasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BaseClasses.BaseTest;

public class MyDashboard extends BaseTest
{

	public UpdateTask fn_NavToTask() {
		click("TaskTab_XPATH");
		UpdateTask objUpdateTask= new UpdateTask();
		return objUpdateTask; 
	}
	
	
	
	
	
}
