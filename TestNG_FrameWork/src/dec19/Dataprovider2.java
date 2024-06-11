package dec19;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class Dataprovider2 {
  WebDriver driver ;
  @BeforeTest
  public void setup() {
	  driver = new ChromeDriver();
  }
  @Test(dataProvider = "dp")
  public void AdminLogin(String username,String password) {
	  driver.get("http://orangehrm.qedgetech.com/symfony/web/index.php/auth/login");
	  driver.manage().window().maximize();
	  driver.findElement(By.name("txtUsername")).sendKeys(username);
	  driver.findElement(By.name("txtPassword")).sendKeys(password);
	  driver.findElement(By.name("Submit")).click();
	  String Expected="dashboard";
	  String Actual =driver.getCurrentUrl();
	  try {
	  Assert.assertTrue(Actual.contains(Expected), "Login details are not valid");
	  }catch(AssertionError a) {
		  System.out.println(a.getMessage());
	  }
	  
  }
  @DataProvider
  public Object [][]dp(){
	  Object login [][]=new Object [4][2];
	  login[0][0]="Admin";
	  login[0][1]="Qedge123!@#";
	  login[1][0]="pavan";
	  login[1][1]="kumar";
	  login[2][0]="Admin";
	  login[2][1]="ram";
	  login[3][0]="kishore";
	  login[3][1]="Qedge123!@#";
	return login;
	  
  
  
	  
  }
  @AfterTest
  public void tearDown() {
	  driver.quit();
  }

}
