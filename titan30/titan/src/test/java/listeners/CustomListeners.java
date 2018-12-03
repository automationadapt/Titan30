package listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import utility.TestUtil;

public class CustomListeners implements ITestListener
{

	@Override
	public void onTestStart(ITestResult result)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult result)
	{
//		 System.setProperty("org.uncommons.reportng.escape-output", "false");
		try
		{
			TestUtil.captureScreenshot();
			System.out.println(TestUtil.fileName);
			Reporter.log("<a href="+TestUtil.fileName+">Screenshot</a>");
			Reporter.log("<br>");
			Reporter.log("<a href="+TestUtil.fileName+"><img src="+TestUtil.fileName+" height=200 width=400></a>");
//			Reporter.log("<a href="+TestUtil.fileName+"target=\"_blank\"><img src="+TestUtil.fileName+" height=200 width=200></a>");

		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context)
	{
		// TODO Auto-generated method stub

	}

}
