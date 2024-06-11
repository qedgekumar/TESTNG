package dec31;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Assert {
	WebDriver driver;
	@Test
	public void StartTest()
	{
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://google.com");
	String Expected_Title="Google";
	String Actual_Title=driver.getTitle();
	try {
    org.testng.Assert.assertEquals(Actual_Title, Expected_Title, "Title is Not matching");
	}catch(AssertionError a)
	{
		System.out.println(a.getMessage());
	}
    driver.quit();
	}

	

	}


