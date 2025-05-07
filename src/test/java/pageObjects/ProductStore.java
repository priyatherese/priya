package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductStore extends BasePage {

    private static final By Phones = null;

	public ProductStore(WebDriver driver) {
        super(driver);
    }

    public void clickLaptops() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@onclick=\"byCat('notebook')\"]"))).click();
    }

    public void clickPhones() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(Phones)).click();
    }

	
		// TODO Auto-generated method stub
		
	}

	
		// TODO Auto-generated method stub
		
	

   /* public void clickSamsung6() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until the image for Galaxy S6 is present and clickable
        WebElement samsungImage = wait.until(ExpectedConditions
            .elementToBeClickable(By.xpath("//a[text()='Samsung galaxy s6']")));

        samsungImage.click(); // Click the element AFTER ensuring it's fresh
    }*/


   // public void clickSamsung6() {
        
        
    	//driver.findElement(By.xpath("//img[@src='imgs/galaxy_s6.jpg']")).click();
      // driver.findElement(By.xpath("//img[@src='imgs/Nexus_6.jpg']")).click();
    	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='prod.html?idp_=3']"))).click();
        
   // }

    /*public void clickAddToCartAndAcceptAlert() {
    	driver.get("https://www.demoblaze.com/prod.html?idp_=1#");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@onclick='addToCart(1)']")));
        addToCart.click();

        // Wait for alert and accept
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }*/
