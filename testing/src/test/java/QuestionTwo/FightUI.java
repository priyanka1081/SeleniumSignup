package QuestionTwo;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FightUI {
	
	public String baseUrl = "http://jt-dev.azurewebsites.net/#/SignUp";
	String driverPath = ".\\chromedriver91.exe";
	public WebDriver driver;
	
	@BeforeTest  
	public void beforeTest() {    
	System.out.println("before test");  
	}     
	@AfterTest  
	public void afterTest() {  
	driver.quit();  
	System.out.println("after test");  
	}
	
	@Test
	public void test() throws Exception {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
		driver.manage().window().maximize();
		driver.get(baseUrl);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='language']")).click();
		assertTrue(driver.findElement(By.xpath("//div[@id='language']//ul//li//div[text()='English']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//div[@id='language']//ul//li//div[text()='Dutch']")).isDisplayed());
		
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("testing name");
		driver.findElement(By.xpath("//input[@id='orgName']")).sendKeys("test organisation");
		driver.findElement(By.xpath("//input[@id='singUpEmail']")).sendKeys("testemail@gmail.com");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label//span[text()='I agree to the']")).click();
		driver.findElement(By.xpath("//button[@type='submit'][text()='Get Started']")).click();
		
		Thread.sleep(5000);
		assertTrue(driver.findElement(By.xpath("//div//span[contains(text(),'A welcome email has been sent. Please check your email. ')]")).isDisplayed());
		
		
	}
	
	

}
