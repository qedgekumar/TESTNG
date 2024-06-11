package dec31;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Primus_parameters {
	 WebDriver driver;
	 @Parameters({"Url","username","password"})
	 @BeforeTest
	 public void setUp(String url,String user,String pass)
	 {
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.get(url);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.findElement(By.name("txtuId")).sendKeys(user);
		 driver.findElement(By.name("txtPword")).sendKeys(pass);
		 driver.findElement(By.name("login")).click();
		 
	 }
	 @Parameters({"Bname","Address1","Address2","Address3","Area","Zipcode","Country","State","City"})
	 @Test
	 public void startTest(String Branchname,String Address1,String Address2,String Address3,String Area,String zip,String country,String state,String city) throws Throwable
	 {
		 driver.findElement(By.xpath("//a[@href='admin_banker_master.aspx']//img")).click();
		 driver.findElement(By.xpath("//input[@id='BtnNewBR']")).click();
		 driver.findElement(By.xpath("//input[@id='txtbName']")).sendKeys(Branchname);
		 driver.findElement(By.xpath("//input[@id='txtAdd1']")).sendKeys(Address1);
		 driver.findElement(By.xpath("//input[@id='Txtadd2']")).sendKeys(Address2);
		 driver.findElement(By.xpath("//input[@id='txtadd3']")).sendKeys(Address3);
		 driver.findElement(By.xpath("//input[@id='txtArea']")).sendKeys(Area);
		 driver.findElement(By.xpath("//input[@id='txtZip']")).sendKeys(zip);
		 new Select(driver.findElement(By.xpath("//select[@id='lst_counrtyU']"))).selectByVisibleText(country);
		 new Select(driver.findElement(By.xpath("//select[@id='lst_stateI']"))).selectByVisibleText(state);
		 new Select(driver.findElement(By.xpath("//select[@id='lst_cityI']"))).selectByVisibleText(city);
		 driver.findElement(By.xpath("//input[@id='btn_insert']")).click();
		 Thread.sleep(5000);
		 String alerttext=driver.switchTo().alert().getText();
		 System.out.println(alerttext);
		 Thread.sleep(3000);
		 driver.switchTo().alert().accept();
		 Thread.sleep(4000);
	 }
	 @AfterTest
	 public void tearDown()
	 {
		 driver.quit();
	 }
	

}
