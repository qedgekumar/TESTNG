package dec31;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AppUtil2 {
	public static WebDriver driver;
	@BeforeTest
	public static void setUp()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://primusbank.qedgetech.com/");
		Reporter.log("Running in BeforeTest",true);
	}
	@AfterTest
	public void tearDown()
	{
		Reporter.log("Running in AfterTest",true);
		driver.quit();
	}

}
