package dec12;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import config.AppUtil2;

public class ThirdTestNGClass extends AppUtil2{
	@Test(groups="orangehrm")
	public void admin()
	{
		driver.findElement(By.xpath("//b[normalize-space()='Admin']")).click();
	}
	@Test(dependsOnMethods="admin")
	public void pim()
	{
		driver.findElement(By.xpath("//b[normalize-space()='PIM']")).click();
	
		
	}
	@Test(dependsOnMethods="pim")
	public void leave()
	{
		driver.findElement(By.xpath("//b[normalize-space()='Leave']")).click();
		
	}
	@Test(dependsOnMethods="leave")
	public void time()
	{
		driver.findElement(By.xpath("//b[normalize-space()='Time']")).click();
	}

}
