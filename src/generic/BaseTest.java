package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseTest implements IAutoConst{
	static 
	{
		System.setProperty(CHROME_KEY, CHROME_VALUE); // value from IautoConst
		System.setProperty(GECKO_KEY, GECKO_VALUE);
		
		/*System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "webdriver.gecko.driver");*/
	}
	
	public WebDriver driver;
	
	@Parameters({"browser"})
	@BeforeSuite(alwaysRun=true)
	public void openApp(String browser)
	{
		if(browser.equals("chrome"))
		{
		driver = new ChromeDriver();
		}
		else
		{
			driver = new FirefoxDriver();
		}
		// driver.get("http://localhost/login.do");
		String url = AL.getProperty(SETTINGS_PATH, "URL"); // user define method to get the property value getProperty() of AL class
		driver.get(url);
		//implicitlyWait(10, TimeUnit.SECONDS); --> take from property file - use userdefined method getProperty()
		String ito_prop = AL.getProperty(SETTINGS_PATH, "ITO");
		long ito = Long.parseLong(ito_prop);
		driver.manage().timeouts().implicitlyWait(ito, TimeUnit.SECONDS); 
	}
	
	@AfterSuite(alwaysRun=true)
	public void closeApp(ITestResult res)  // TestNG use this class to generate result of test - ITestResult res  
	{
		String name = res.getName(); // it returns test method name
		int status = res.getStatus(); // it returns status of test method 1=pass 2=fail
		
		// taking screen shots only in the case of fail
		if(status==2)
		{
			String imgPath = AL.getPhoto(driver, PHOTO_PATH, name); // name is method name 
			Reporter.log("Failed image path"+imgPath,true);
		}
		driver.quit(); 
	}

}
