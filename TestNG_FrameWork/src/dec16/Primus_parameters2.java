package dec16;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Primus_parameters2 {
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
	@Parameters({"Employer Name","Login Password","Role","Branch"})
	@Test
    public void startTest(String empname,String logpass,String role,String branch)
    {
		driver.findElement(By.xpath("(//img)[8]")).click();
		driver.findElement(By.xpath("//input[@id='BtnNew']")).click();
		driver.findElement(By.name("txtUname")).sendKeys(empname);
		driver.findElement(By.name("txtLpwd")).sendKeys(logpass);
		driver.findElement(By.name("lst_Roles")).sendKeys(role);
		driver.findElement(By.name("lst_Branch")).sendKeys(branch);
		driver.findElement(By.name("BtnSubmit")).click();
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
