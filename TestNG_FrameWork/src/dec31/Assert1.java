package dec31;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assert1 {
	WebDriver driver;
	@Test
	public void verify_Title()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rediff.com");
		String Expected_Title="Google";
		String Actual_Title=driver.getTitle();
		try {
		Assert.assertEquals(Actual_Title, Expected_Title, "Title is not matching");
		}catch(AssertionError a)
		{
			System.out.println(a.getMessage());
			
		}
		driver.quit();
		
	}

}
