package listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;

import BaseClasses.BaseTest;
import utility.TestUtil;

public class CustomListeners extends BaseTest implements ITestListener
{

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
			// TODO Auto-generated catch block
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
		test.log(LogStatus.SKIP, result.getName().toUpperCase()+" Skipped the test as the Run mode is NO");
		rep.endTest(test);
		rep.flush();

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

}
