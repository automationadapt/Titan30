package pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import BaseClasses.BaseTest;

public class ProjectList extends BaseTest {

	public static ProjectDetail fn_navProjectDetails() throws InterruptedException{

		waitforProgressBar();
		String value = driver.findElement(By.xpath("//table[@id='myFirstTable']//tbody/tr[1]/td[2]/a")).getText(); 
		System.out.println(value);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//table[@id='myFirstTable']//tbody/tr[1]/td[2]/a"))));
		driver.findElement(By.linkText(value)).click();
		ProjectDetail objProjectDetail=new ProjectDetail();
		return objProjectDetail;
	}
	
	
	public CreateProjectPage fn_NavCreateProject() {		
		driver.findElement(By.xpath("//button[@id='CreateProject']")).click();
		waitforProgressBar();
		CreateProjectPage createProjectObj = new CreateProjectPage();
		return createProjectObj;
	}
}
