package pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import BaseClasses.BaseTest;

public class ProjectList extends BaseTest {

	public static ProjectDetail fn_navProjectDetails() throws InterruptedException{

		String value = driver.findElement(By.xpath("//table[@id='myFirstTable']//tbody/tr[1]/td[2]/a")).getText(); 
		System.out.println(value);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//table[@id='myFirstTable']//tbody/tr[1]/td[2]/a"))));
		driver.findElement(By.linkText(value)).click();
		System.out.println("On Project link Click");
		waitforProgressBar();
		ProjectDetail objProjectDetail=new ProjectDetail();
		return objProjectDetail;
	}
	
	
	public CreateProjectPage fn_NavCreateProject() {
//		waitforProgressBar();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@id='CreateProject']"))));
		driver.findElement(By.xpath("//button[@id='CreateProject']")).click();
		waitforProgressBar();
		CreateProjectPage createProjectObj = new CreateProjectPage();
		return createProjectObj;
	}
	
}
