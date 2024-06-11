package dec31;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AppUtil {
	public static WebDriver driver;
	@BeforeTest
	public static void SetUp()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://primusbank.qedgetech.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Reporter.log("Running in BeforeTest",true);
		
	}
	@AfterTest
	public static void tearDown()
	{
		Reporter.log("Running in AfterTest",true);
		driver.quit();
	}

}
