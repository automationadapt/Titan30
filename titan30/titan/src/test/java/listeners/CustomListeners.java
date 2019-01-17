package listeners;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;

import BaseClasses.BaseTest;
import utility.MailMonitoring;
import utility.TestConfig;
import utility.TestUtil;

public class CustomListeners extends BaseTest implements ITestListener, ISuiteListener
{

	public String messageBody; 
	@Override
	public void onTestStart(ITestResult result)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		test.log(LogStatus.PASS, result.getName().toUpperCase()+" PASS");
		rep.endTest(test);
		rep.flush();

	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		try
		{
			TestUtil.captureScreenshot();

		} catch (IOException e)
		{
			e.printStackTrace();
		}
		test.log(LogStatus.FAIL, result.getName().toUpperCase()+" Failed with exception : "+result.getThrowable());
		test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.fileName));
		Reporter.log("Click to see Screenshot");
		Reporter.log("<a target=\"_blank\" href="+TestUtil.fileName+">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href="+TestUtil.fileName+"><img src="+TestUtil.fileName+" height=400 width=800></img></a>");
		rep.endTest(test);
		rep.flush();
		
	}

	@Override
	public void onTestSkipped(ITestResult result)
	{
//		test.log(LogStatus.SKIP, result.getName().toUpperCase()+" Skipped the test as the Run mode is NO");
//		rep.endTest(test);
//		rep.flush();

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context)
	{
		test = rep.startTest(context.getName().toUpperCase()); 

	}

	@Override
	public void onFinish(ITestContext context)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ISuite suite)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ISuite suite)
	{
//		MailMonitoring mail = new MailMonitoring();
//		 
//		try {
//			
//			messageBody = "http://" + InetAddress.getLocalHost().getHostAddress()
//					+ ":8081/job/NewTitan/Test_20Execution_20Report/";
//			messageBody=messageBody+"<br>"+"";
//			messageBody=messageBody+"<br>"+"Kindly click on above link to see the Test Execution ";
//			messageBody=messageBody+"<br>"+"";	
//			messageBody=messageBody+"<br>"+"Below are the credentials ";
//			messageBody=messageBody+"<br>"+"UserName:admin ";
//			messageBody=messageBody+"<br>"+"Password:user@123";
//			messageBody=messageBody+"<br>"+"";
//			messageBody=messageBody+"<br>"+"This is an auto generated e-mail for Selenium Automation";
//			messageBody=messageBody+"<br>"+"";
//			messageBody=messageBody+"<br>"+"Thanks and Regards,";
//			messageBody=messageBody+"<br>"+"QA Team Adapt";
//			
//			
//			
//		} catch (UnknownHostException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	
//		try {
//			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody);
//			System.out.println();
//		} catch (AddressException e) {
//			// TODO Auto-generated catch block
//			
//			e.printStackTrace();
//		} catch (MessagingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
		
	}

}
