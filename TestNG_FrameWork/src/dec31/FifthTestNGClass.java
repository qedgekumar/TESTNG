package dec31;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FifthTestNGClass extends AppUtil5 {
	@Test(groups = "orangeHrm")
	public void admin()
	{
		driver.findElement(By.xpath("//b[normalize-space()='Admin']")).click();
	}
	@Test(dependsOnMethods = "admin")
	public void pim()
	{
		driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']")).click();
	}
	@Test(dependsOnMethods = "pim")
	public void leave()
	{
		driver.findElement(By.xpath("//b[normalize-space()='Leave']")).click();
	}
	@Test(dependsOnMethods = "leave")
	public void time()
	{
		driver.findElement(By.xpath("//b[normalize-space()='Time']")).click();
	}

}
