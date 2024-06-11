package dec12;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import config.AppUtilb;

public class SecondTestNGClassb extends AppUtilb{
	@Test(priority=2)
	public void branches()
	{
		driver.findElement(By.xpath("(//img)[5]")).click();
		Reporter.log("Executing Branches test",true);
	}
	@Test(priority=0)
	public void roles()
	{
		driver.findElement(By.xpath("(//img)[6]")).click();
		Reporter.log("Executing Roles test",true);
	}
	@Test(priority=1)
	public void users()
	{
		driver.findElement(By.xpath("(//img)[7]")).click();
		Reporter.log("Executing Users test",true);
	}
	

}
