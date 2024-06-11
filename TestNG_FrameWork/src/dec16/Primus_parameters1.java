package dec16;

import java.time.Duration;

import javax.swing.colorchooser.DefaultColorSelectionModel;

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

public class Primus_parameters1 {
	WebDriver driver;
	@Parameters({"url","username","password"})
	@BeforeTest
	public void setUp(String url,String user,String pass)
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
	@Parameters({"Role Name","Role Desc","Role Type"})
	@Test
	public void startTest(String rolename,String roledesc,String roletype)
	{
		driver.findElement(By.xpath("(//img)[6]")).click();
		driver.findElement(By.xpath("//input[@id='btnRoles']")).click();
		driver.findElement(By.name("txtRname")).sendKeys(rolename);
		driver.findElement(By.name("txtRDesc")).sendKeys(roledesc);
		new Select(driver.findElement(By.name("lstRtypeN"))).selectByVisibleText(roletype);
		driver.findElement(By.name("btninsert")).click();
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
