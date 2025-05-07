package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
@FindBy(xpath="//a[@id='login2']") 
WebElement lnkLogin;

@FindBy(xpath="//input[@id='loginusername']")
WebElement txtUsername;
@FindBy(xpath="//input[@id='loginpassword']") 
WebElement txtPassword;

@FindBy(xpath="//button[@onclick='logIn()']") 
WebElement lnklogin;

@FindBy(xpath="//a[text()='Samsung galaxy s7']")
WebElement lnkPhone;
public void clickLogin()
{
	
	lnkLogin.click();
}

public void setUsername(String username) {
	txtUsername.sendKeys(username);

}
public void setPassword(String pwd) {
	txtPassword.sendKeys(pwd);

}
public void clicklogin()
{
	
	lnklogin.click();
}
public void clickSamsungPhone() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.elementToBeClickable(lnkPhone)).click();
}

}
