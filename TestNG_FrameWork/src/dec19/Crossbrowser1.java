package dec19;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class Crossbrowser1 {
  WebDriver driver;
  @Parameters({"Browser"})
  @BeforeTest
  public void setup(String brw)
  {
	  switch (brw) {
	case "Chrome":
		driver=new ChromeDriver();
		break;
	case "Firefox":
		driver=new FirefoxDriver();
		break;

	default:
		System.out.println("Browser value is not matching");
		break;
	}
	  
  }
@Test(dataProvider = "dp")
public void Adminlogin(String username,String password) {
	driver.get("http://orangehrm.qedgetech.com/symfony/web/index.php/auth/login");
	driver.manage().window().maximize();
	driver.findElement(By.name("txtUsername")).sendKeys(username);
	driver.findElement(By.name("txtPassword")).sendKeys(password);
	driver.findElement(By.name("Submit")).click();
	String Expected ="dashboard";
	String Actual =driver.getCurrentUrl();
	if(Actual.contains(Expected))
	{
		Reporter.log("Login success"+Expected+"  "+Actual,true);
	}
	else
	{
		String errormsg = driver.findElement(By.id("spanMessage")).getText();
		Reporter.log(errormsg+" "+Expected+"  "+Actual,true);
	}
		
	
	
}
@DataProvider
public Object[][]dp(){
	Object login[][]=new Object[4][2];
	login[0][0]="Admin";
	login[0][1]="Qedge123!@#";
	login[1][0]="test";
	login[1][1]="Qedge123!@#";
	login[2][0]="Admin";
	login[2][1]="pavan";
	login[3][0]="Admin1";
	login[3][1]="admin";
	return login;
}
@AfterTest
public void tearDown()
{
	driver.quit();
}
}
