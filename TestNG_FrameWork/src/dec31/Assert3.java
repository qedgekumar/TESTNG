package dec31;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assert3 {
	WebDriver driver;
	@Test
	public void verify_Title()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");
		String Expected_Title="Google";
		String Actual_Title=driver.getTitle();
		try {
			Assert.assertFalse(Actual_Title.equalsIgnoreCase(Expected_Title), "Title is matching");
		}catch(AssertionError a)
		{
			System.out.println(a.getMessage());
			
		}
		driver.quit();
	}

}
