package testBase;

import java.time.Duration;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import pageObjects.HomePage;

public class BaseClass {

	public WebDriver driver;

	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.demoblaze.com/");
		driver.manage().window().maximize();
	}

	//@AfterClass
	//public void tearDown() 
		//driver.quit();
	

	@Test
	public void verify_homepage()
	{
		HomePage hp = new HomePage(driver);
		hp.clickLogin();

		hp.setUsername("priyajohn");
		hp.setPassword("tetelestai");
		hp.clicklogin();
	}

	
	
}
	
