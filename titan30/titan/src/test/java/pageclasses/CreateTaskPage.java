package pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;

import BaseClasses.BaseTest;
import utility.TestUtil;

public class CreateTaskPage extends BaseTest
{

//     public String fn_CreateTask(String TaskName, String Description,
//              String StartDate, String DueDate, String Priority)
//              throws InterruptedException
//     {
//
//    	 wait.until(ExpectedConditions.visibilityOf(driver
//                 .findElement(By.xpath(OR.getProperty("TaskNameTB_XPATH")))));
//          type("TaskNameTB_XPATH", TaskName);
//          click("AssignToSelect_XPATH");
//          wait.until(ExpectedConditions.visibilityOf(driver
//                   .findElement(By.xpath(OR.getProperty("AssignTovalue_XPATH")))));
//          String Member=Config.getProperty("teammembername");
//          System.out.println(Member);
//          String _temp="//*[text()="+"'"+" "+ Member+"'"+"]";
//          driver.findElement(By.xpath(_temp)).click();     
//          click("AssignToSelect_XPATH");
//          wait.until(ExpectedConditions.invisibilityOf(driver
//          .findElement(By.xpath(OR.getProperty("AssignTovalue_XPATH")))));
//          driver.findElement(By.xpath(OR.getProperty("AssignToSelect_XPATH"))).sendKeys(Keys.TAB);
//          type("DescriptionTB_XPATH", Description);
//          dateselect("TaskStartDateTB_XPATH", StartDate);
//          dateselect("TaskDueDateTB_XPATH", DueDate);
//          Select("PrioritySelect_XPATH", Priority);
//          click("IntimationatCompletionSelect_XPATH");
//          click("IntimationatCompletionvalue_XPATH");
//          click("IntimationatCompletionSelect_XPATH");
//          click("ClickSubmitButton_XPATH");
//          System.out.println("wait after task submit click");
//          String actualAlertText = waitForAlertwithText();
//          return actualAlertText;
//     }
	
	 public String fn_CreateTask(String TaskName, String Description,
             String StartDate, String DueDate, String Priority)
             throws InterruptedException
    {
         waitforProgressBar();
         type("TaskNameTB_XPATH", TaskName);
         
         click("AssignToSelect_XPATH");
         wait.until(ExpectedConditions.visibilityOf(driver
                  .findElement(By.xpath(OR.getProperty("AssignTovalue_XPATH")))));
         String Member=Config.getProperty("teammembername");
         System.out.println(Member);
         String _temp="//*[text()="+"'"+" "+ Member+"'"+"]";
         driver.findElement(By.xpath(_temp)).click();     
         click("AssignToSelect_XPATH");
         wait.until(ExpectedConditions.invisibilityOf(driver
         .findElement(By.xpath(OR.getProperty("Assignpopup_XPATH")))));
         driver.findElement(By.xpath(OR.getProperty("AssignToSelect_XPATH"))).sendKeys(Keys.TAB);
         type("DescriptionTB_XPATH", Description);
         dateselect("TaskStartDateTB_XPATH", StartDate);
         dateselect("TaskDueDateTB_XPATH", DueDate);
         Select("PrioritySelect_XPATH", Priority);
         click("IntimationatCompletionSelect_XPATH");
         click("IntimationatCompletionvalue_XPATH");
         click("IntimationatCompletionSelect_XPATH");
         click("ClickSubmitButton_XPATH");
         String actualAlertText = waitForAlertwithText();
         waitforProgressBar();
         return actualAlertText;
    }


}

