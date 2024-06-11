package dec31;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ThirdTestNGClass extends AppUtil3{
	@Test(priority=2,enabled=false)
	public void branches()
	{
		driver.findElement(By.xpath("(//img)[5]")).click();
		Reporter.log("Executing branches Test",true);
	}
	@Test(priority=0,invocationCount = 5)
	public void roles()
	{
		driver.findElement(By.xpath("(//img)[6]")).click();
		Reporter.log("Executing roles Test",true);
	}
	@Test(priority=1)
	public void users()
	{
		driver.findElement(By.xpath("(//img)[7]")).click();
		Reporter.log("Executing users Test",true);
	}

}
