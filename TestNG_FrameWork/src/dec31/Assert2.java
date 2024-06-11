package dec31;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assert2 {
	WebDriver driver;
	@Test
	public void verify_Title()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://gmail.com");
		String Expected_Title="Google";
		String Actual_Title=driver.getTitle();
		try {
	     Assert.assertTrue(Actual_Title.equalsIgnoreCase(Expected_Title), "Title is not matching");
		}catch(AssertionError a) {
			System.out.println(a.getMessage());
		}
		driver.quit();
		
	}

}
