package dec12;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import config.AppUtila;

public class FirstTestNGClassa extends AppUtila {
	@Test
	public void pBanking() {
		driver.findElement(By.xpath("(//img)[4]")).click();
		Reporter.log("Executing pBanking test",true);
		
		
	}
	@Test
	public void cBanking() {
		driver.findElement(By.xpath("(//img)[5]")).click();
		Reporter.log("Executing cBanking",true);
	}
	@Test
	public void iBanking() {
		driver.findElement(By.xpath("(//img)[6]")).click();
		Reporter.log("Executing iBanking",true);
		
	}

}
