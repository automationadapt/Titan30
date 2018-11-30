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

     public String fn_CreateTask(String TaskName, String Description,
              String StartDate, String DueDate, String Priority)
              throws InterruptedException
     {
          waitforProgressBar();
          type("TaskNameTB_XPATH", TaskName);
          click("AssignToSelect_XPATH");
          wait.until(ExpectedConditions.visibilityOf(driver
                   .findElement(By.xpath(OR.getProperty("AssignTovalue_XPATH")))));
          click("AssignTovalue_XPATH");
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

