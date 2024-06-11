package jan1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Cross {
	WebDriver driver;
	@Parameters({"Browser"})
	@BeforeTest
	public void setup(String brw) {
		switch (brw) {
		case "chrome":
			driver=new ChromeDriver();
			
			break;
		case "firefox":
			driver=new FirefoxDriver();
           break;
		default:
			System.out.println("Browser value is not matching");
			break;
		}
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
    	Reporter.log("Login success::"+Actual+"  "+Expected,true);
		
	} else {
		//capture error message
		String Error_message=driver.findElement(By.id("spanMessage")).getText();
		Reporter.log(Error_message+"  "+Expected+"  "+Actual,true);

	}
    
    
}
	@DataProvider
	public Object[][]dp(){
		Object login[][]=new Object[4][2];
		login[0][0]="Admin";
		login[0][1]="Qedge123!@#";
		login[1][0]="Admin1";
		login[1][1]="test";
		login[2][0]="pavan";
		login[2][1]="kumar";
		login[3][0]="Admin";
		login[3][1]="Qedge123!@#";
		return login;
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
