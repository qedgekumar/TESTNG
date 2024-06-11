package dec31;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Completeassert {
	WebDriver driver;
	@BeforeTest
	public void StartTest()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}
	@Test
	public void assertTest()
	{
		driver.get("https://myntra.com");
		String Expected="Google";
		String Actual=driver.getTitle();
		try {
		Assert.assertEquals(Actual, Expected, "Title is not matching");
		}catch(AssertionError a) {
			System.out.println(a.getMessage());
			
		}
		
		
		
			
		
		
	}
	@Test
	public void assertTrue()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rediff.com");
		String Expected="Google";
		String Actual=driver.getTitle();
		try {
		Assert.assertTrue(Actual.equalsIgnoreCase(Expected), "Title is not matching");
		}catch(AssertionError a) {
			System.out.println(a.getMessage());
		}
		
	}
	@Test
	public void assertFalse()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");
		String Expected="Google";
		String Actual=driver.getTitle();
		try {
			Assert.assertFalse(Actual.equalsIgnoreCase(Expected), "Title is matching");
		}catch(AssertionError a) {
			System.out.println(a.getMessage());
			
		}
		
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
