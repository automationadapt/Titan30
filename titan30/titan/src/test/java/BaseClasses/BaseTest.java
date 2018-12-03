package BaseClasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import pageclasses.HomePageHeader;
import utility.ExcelReader;
import utility.MailMonitoring;

public class BaseTest
{
	/*
	 * Selenium - locators Log4j - done Excel - done Properties - done JavaMail
	 * - done TestNG - done ReportNG - done Waits - done Keywords - click, type,
	 * isElementPresent, select - done Capturing Screenshot - TimeStamp
	 * Parameterization
	 */

	public static WebDriver driver;
	public static FileInputStream fis;
	public static Properties Config = new Properties();
	public static Properties OR = new Properties();
	public static WebDriverWait wait;
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir")
					+ "\\src\\test\\resources\\excel\\CreateProject.xlsx");
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static WebElement webele;
	MailMonitoring mail = new MailMonitoring();
	public static WebElement dropdown;
	public static Actions actObj;
	public static HomePageHeader homeObj; 

	@BeforeTest
	public static void StartBrowser()
	{
		if (driver == null)
		{
			try
			{
				System.out.println("Now driver is null");
				fis = new FileInputStream(System.getProperty("user.dir")
						+ "\\src\\test\\resources\\properties\\Config.properties");
			} catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
			try
			{
				Config.load(fis);
			} catch (IOException e)
			{
				e.printStackTrace();
			}

			try
			{
				fis = new FileInputStream(System.getProperty("user.dir")
						+ "\\src\\test\\resources\\properties\\OR.Properties");
			} catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
			try
			{
				OR.load(fis);
			} catch (IOException e)
			{
				e.printStackTrace();
			}

			if (Config.getProperty("browser").equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", System
						.getProperty("user.dir")
						+ "\\src\\test\\resources\\executables\\geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (Config.getProperty("browser").equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", System
						.getProperty("user.dir")
						+ "\\src\\test\\resources\\executables\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (Config.getProperty("browser").equalsIgnoreCase("ie"))
			{
				System.setProperty("webdriver.ie.driver", System
						.getProperty("user.dir")
						+ "\\src\\test\\resources\\executables\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			} else if (Config.getProperty("browser").equalsIgnoreCase("edge"))
			{
				System.setProperty("webdriver.edge.driver", System
						.getProperty("user.dir")
						+ "\\src\\test\\resources\\executables\\MicrosoftWebDriver.exe");
				driver = new EdgeDriver();
			} else
			{
				System.out.println(
						"Browser name is incorrorect, Check in the config file");
			}
	

		}

		driver.get(Config.getProperty("testsiteurl"));
		BaseTest.PageLoad();
		actObj =new Actions(driver); 
		HomePageHeader homeObj= new HomePageHeader();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(
				Integer.parseInt(Config.getProperty("implicit.wait")),
				TimeUnit.SECONDS);
		log.debug("vikas kumar tripathi page opened ");

		wait = new WebDriverWait(driver,
				Integer.parseInt(Config.getProperty("explicit.wait")));

	}

	public static void PageLoad()
	{
		ExpectedCondition<Boolean> expected = new ExpectedCondition<Boolean>()
		{
			public Boolean apply(WebDriver driver)
			{
				return ((JavascriptExecutor) driver)
						.executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};

	}

	public void Select(String locator, String Value)
	{
		
		if (locator.endsWith("_XPATH"))
		{
			dropdown = driver.findElement(By.xpath(OR.getProperty(locator)));
		} else if (locator.endsWith("_CSS"))
		{
			dropdown = driver
					.findElement(By.cssSelector(OR.getProperty(locator)));

		} else if (locator.endsWith("_ID"))
		{
			dropdown = driver.findElement(By.id(OR.getProperty(locator)));
		} else
		{
			log.debug("Error in select element" + locator);
		}

		Select selectEle = new Select(dropdown);
		selectEle.selectByVisibleText(Value);
	}

	public void SelectByIndex(String locator, String Value)
	{
		if (locator.endsWith("_XPATH"))
		{
			dropdown = driver.findElement(By.xpath(OR.getProperty(locator)));

		} else if (locator.endsWith("_CSS"))
		{
			dropdown = driver
					.findElement(By.cssSelector(OR.getProperty(locator)));

		} else if (locator.endsWith("_ID"))
		{
			dropdown = driver.findElement(By.id(OR.getProperty(locator)));
		} else
		{
			log.debug("Error in select element" + locator);
		}

		Select selectEle = new Select(dropdown);
		int index= Integer.parseInt(Value); 
		selectEle.selectByIndex(index);
	}

	public static void login(String Role) throws InterruptedException
	{
		if (Role.equalsIgnoreCase("techadmin"))
		{
			type("LoginTextBox_XPATH", Config.getProperty("techadminid"));
			click("NextButton_XPATH");
			type("PassTextBox_XPATH", Config.getProperty("techadminpass"));
			Thread.sleep(3000);
			click("SubmitButton_XPATH");
		} else if (Role.equalsIgnoreCase("pm"))
		{
			type("LoginTextBox_XPATH", Config.getProperty("pmid"));
			click("NextButton_XPATH");
			type("PassTextBox_XPATH", Config.getProperty("pmpass"));
			Thread.sleep(3000);
			click("SubmitButton_XPATH");
		} else if (Role.equalsIgnoreCase("teammember"))
		{
			type("LoginTextBox_XPATH", Config.getProperty("teammemberid"));
			click("NextButton_XPATH");
			type("PassTextBox_XPATH", Config.getProperty("teamemberpass"));
			Thread.sleep(3000);
			click("SubmitButton_XPATH");

		} else
		{
			System.out.println("Check User Role Name and credentials");
		}

		System.out.println(driver +"Driver Value which showing null pointer exceptiption");
		boolean element = driver
				.findElement(By.xpath(OR.getProperty("ConfirButton_XPATH")))
				.isDisplayed();

		if (element == true)
		{
			driver.findElement(By.xpath(OR.getProperty("ConfirButton_XPATH")))
					.click();
		} else
		{
			System.out.println("Confirmation Box doesnt appeared");
		}
		System.out.println("clicking on Workspace Link ");
		actObj.click(driver.findElement(By.xpath(OR.getProperty("WorkplaceLink_XPATH")))).build().perform();
//		click();
		log.debug("Successfully landed to the Homepage");

	}

	public static void type(String locator, String Value)
	{
		try
		{
			if (locator.endsWith("_XPATH"))
			{
				driver.findElement(By.xpath(OR.getProperty(locator)))
						.sendKeys(Value);
			} else if (locator.endsWith("_CSS"))
			{
				driver.findElement(By.cssSelector(OR.getProperty(locator)))
						.sendKeys(Value);
			} else if (locator.endsWith("_ID"))
			{
				driver.findElement(By.id(OR.getProperty(locator)))
						.sendKeys(Value);
			} else
			{
				System.out.println("Check the Locator of WebElement");
			}
		} catch (Throwable t)
		{
			log.debug("Error" + locator);
			log.debug(t.getMessage());
			Reporter.log(t.getMessage());
			
		}
	}

	public static void dateselect(String locator, String value)
	{
		click(locator);
		wait.until(ExpectedConditions.visibilityOf(driver
				.findElement(By.xpath("//div[@id='ui-datepicker-div']"))));
		WebElement datewid = driver
				.findElement(By.xpath("//div[@id='ui-datepicker-div']"));
		List<WebElement> columns = datewid.findElements(By.tagName("td"));

		for (WebElement cell : columns)
		{
			if (cell.getText().equals(value))
			{
				cell.findElement(By.linkText(value)).click();
				break;
			}
		}
		wait.until(ExpectedConditions.invisibilityOf(driver
				.findElement(By.xpath("//div[@id='ui-datepicker-div']"))));
	}

	public static void waitforProgressBar()
	{
		
		try
		{
			wait.until(ExpectedConditions.invisibilityOf(driver
					.findElement(By.xpath("//div[@class='modal fade page-load-outer-div in']"))));
//			wait.until(ExpectedConditions.invisibilityOfElementLocated(driver.findElement(By.xpath(""))))
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Progress bar is not visible");
			log.debug("Progress bar is not visible");
		}

	}

		

	public static String waitForAlertwithText()
	{
//		wait.until(ExpectedConditions.alertIsPresent());
		String alertText = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return alertText;
	}

	public static void click(String locator)
	{
		try
		{
			if (locator.endsWith("_XPATH"))
			{
				driver.findElement(By.xpath(OR.getProperty(locator))).click();
			} else if (locator.endsWith("_CSS"))
			{
				driver.findElement(By.cssSelector(OR.getProperty(locator)))
						.click();
			} else if (locator.endsWith("_ID"))
			{
				driver.findElement(By.id(OR.getProperty(locator))).click();
			} else
			{
				System.out.println("Check the Locator of WebElement");
			}
		} catch (Throwable t)
		{
			log.debug("Error" + locator);
			// log.debug(t.getMessage());
			// Assert.fail(t.getMessage());
		}
	}

	@AfterTest
	public void tearDown() throws AddressException, MessagingException
	{
		// mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to,
		// TestConfig.subject, TestConfig.messageBody,
		// TestConfig.attachmentPath, TestConfig.attachmentName);
		driver.quit();
		driver = null; 
	}
}
