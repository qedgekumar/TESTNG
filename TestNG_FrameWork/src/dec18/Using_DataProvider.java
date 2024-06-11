package dec18;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class Using_DataProvider {
	WebDriver driver;
	@BeforeTest
	public void setup() {
		driver=new ChromeDriver();
	}
	@Test(dataProvider ="dp")
	public void AdminLogin(String username,String password) {
		driver.get("http://orangehrm.qedgetech.com/symfony/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.findElement(By.name("txtUsername")).sendKeys(username);
		driver.findElement(By.name("txtPassword")).sendKeys(password);
		driver.findElement(By.name("Submit")).click();
		String Expected="dashboard";
		String Actual=driver.getCurrentUrl();
		if (Actual.contains(Expected)) {
			Reporter.log("Login success::"+Expected+"  "+Actual,true);
			
		} else {
			//capture error message
			String Error_Message=driver.findElement(By.id("spanMessage")).getText();
			Reporter.log(Error_Message+"  "+Expected+"  "+Actual,true);
			
          
		}
	}
	@DataProvider
	public Object[][]dp(){
		Object login[][]=new Object[5][2];
		login[0][0]="Admin";
		login[0][1]="Qedge123!@#";
		login[1][0]="test";
		login[1][1]="Qedge123!@#";
		login[2][0]="Admin";
		login[2][1]="qedge";
		login[3][0]="Admin";
		login[3][1]="Qedge123!@#";
		login[4][0]="Admin";
		login[4][1]="Qedge123!@#";
		return login;
		
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
	  
  
  

}
