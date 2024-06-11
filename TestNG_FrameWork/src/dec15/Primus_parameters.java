package dec15;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Primus_parameters {
	WebDriver driver;
	@Parameters({"url","username","password"})
	@BeforeTest
	public void setup(String url,String user,String pass)
	{
		driver = new ChromeDriver();
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
	public void startTest(String Branchname,String Address1,String Address2,String Address3,String Area,String zip,String Country,String State,String City)  
	{
		driver.findElement(By.xpath("(//img)[5]")).click();
		driver.findElement(By.xpath("//input[@id='BtnNewBR']")).click();
		driver.findElement(By.name("txtbName")).sendKeys(Branchname);
		driver.findElement(By.name("txtAdd1")).sendKeys(Address1);
		driver.findElement(By.name("Txtadd2")).sendKeys(Address2);
		driver.findElement(By.name("txtadd3")).sendKeys(Address3);
		driver.findElement(By.name("txtArea")).sendKeys(Area);
		driver.findElement(By.name("txtZip")).sendKeys(zip);
		new Select(driver.findElement(By.name("lst_counrtyU"))).selectByVisibleText(Country);
		new Select(driver.findElement(By.name("lst_stateI"))).selectByVisibleText(State);
		new Select(driver.findElement(By.name("lst_cityI"))).selectByVisibleText(City);
		driver.findElement(By.name("btn_insert")).click();
		WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10) );
		mywait.until(ExpectedConditions.alertIsPresent());
		String alerttext = driver.switchTo().alert().getText();
		System.out.println(alerttext);
		driver.switchTo().alert().accept();
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
		
	}
	
	
	

}
