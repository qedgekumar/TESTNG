package dec31;

import javax.security.auth.login.LoginContext;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider1 {
	WebDriver driver;
	@BeforeTest
	public void setUp()
	{
		driver=new ChromeDriver();
		
	}
	@Test(dataProvider = "dp")
	public void AdminLogin(String username,String password)
	{
		driver.get("http://orangehrm.qedgetech.com/");
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
			String Error_message=driver.findElement(By.xpath("//span[@id='spanMessage']")).getText();
			Reporter.log(Error_message+Expected+"  "+Actual,true);
		}
		
	}
	@DataProvider
	public Object[][]dp(){
		Object login[][]=new Object [5][2];
		login[0][0]="Admin";
		login[0][1]="test";
		login[1][0]="Admin";
		login[1][1]="Qedge123!@#";
		login[2][0]="Admin";
		login[2][1]="pavan";
		login[3][0]="Admin1";
		login[3][1]="Admin2";
		login[4][0]="Admin";
		login[4][1]="Admin1";
		return login;
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
	
	

}
