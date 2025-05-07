package testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pageObjects.ProductStore;
import testBase.BaseClass;

public class TC2_ProductStore extends BaseClass {
	public static ExtentTest test;
    public static ExtentTest getTEST() {
    	if(test!=null) {
    		
    		return test;
    	}
    	ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
       // private static final CharSequence Priya = null;
           test = extent.createTest("My First Test")
                .assignAuthor("QA Tester")
                .assignCategory("Regression")
                .assignDevice("Chrome");
          return test;
    }
	@Test
    public void verify_categories() throws InterruptedException {

    	ProductStore ps = new ProductStore(driver);

        // Add a hard wait if needed
        Thread.sleep(3000); // Wait for 3 seconds before clicking (not recommended for final code)

        // Better: use explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement nexus6Image = wait.until(ExpectedConditions
            .elementToBeClickable(By.xpath("//a[@href='prod.html?idp_=3']/img")));

        nexus6Image.click();
        WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[text()='Add to cart']")));
        System.out.println("Nexus6phone is added into the cart");
            addToCartBtn.click();
            takeScreenShot();
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
            driver.navigate().to("https://www.demoblaze.com/");
            takeScreenShot();
            WebElement SamsunggalaxyS6 = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("//a[text()='Samsung galaxy s6']")));
            SamsunggalaxyS6.click();
            WebElement addToCartBtngalaxy = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[text()='Add to cart']")));
            System.out.println("Samsunggalaxyphone is added into the cart");
            addToCartBtngalaxy.click();
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
            driver.findElement(By.xpath("//a[text()='Cart']")).click();
           // takeScreenShot();
            
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[td[contains(text(),'Nexus 6')]]")));

            // Click the "Delete" button next to Nexus 6
            driver.findElement(By.xpath("//tr[td[contains(text(),'Nexus 6')]]//a[contains(text(),'Delete')]")).click();
            System.out.println("Nexus6phone is deleted from cart");
            driver.findElement(By.xpath("//button[text()='Place Order']")).click();
            System.out.println("Order is placed");
            takeScreenShot();
            // 8. Wait for the order form to appear
           
            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));

         // Wait for the form to be visible
        // WebElement form = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orderForm")));
         
         
      // Wait until the name field is populated (non-empty)
      
            // 9. Fill the Order Form
         driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Priya");;
            
            driver.findElement(By.xpath("//input[@id='country']")).sendKeys("INDIA");
            
            driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Bangalore");
            
            driver.findElement(By.xpath("//input[@id='card']")).sendKeys("1515 1515 1515 1515");
            
            driver.findElement(By.xpath("//input[@id='month']")).sendKeys("05");
            
            driver.findElement(By.xpath("//input[@id='year']")).sendKeys("2025");
            Thread.sleep(10000);
          //  WebElement Purchase = wait1.until(ExpectedConditions
          //          .elementToBeClickable(By.xpath("//button[text()='Purchase']")));
            //Purchase.click();
            
           // WebElement category = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Purchase']")));
           // category.click();
            Thread.sleep(1000);
            try {
                WebElement purchaseBtn = driver.findElement(By.xpath("//button[@type='button' and @onclick='purchaseOrder()' and @class='btn btn-primary']"));
                purchaseBtn.click();
            } catch (NoSuchSessionException e) {
                System.out.println("Session expired. Skipping action.");
            }
           // driver.findElement(By.xpath("//button[text()='Purchase']")).click();

            // 11. Handle the confirmation alert
           // wait.until(ExpectedConditions.alertIsPresent());
          //  wait.until(ExpectedConditions.alertIsPresent());
           // driver.switchTo().alert().accept();
            //System.out.println("Order Confirmation: " + alertText); // Print confirmation alert text
           // alert.accept(); 

}
	public void takeScreenShot() {
		ExtentTest test=getTEST();
		// fileName of the screenshot
		Date d = new Date();
		String screenshotFile = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		String filePath = "C:\\Users\\Jim\\eclipse-workspace";
		System.out.println(screenshotFile+"-"+filePath);		// take screenshot
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			// get the dynamic folder name
			FileUtils.copyFile(srcFile, new File(filePath + "\\" + screenshotFile));
			// put screenshot file in reports
			test.log(Status.INFO, "Screenshot-> " + test.addScreenCaptureFromPath(filePath + "\\" + screenshotFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

	}

	public void log(String msg) {
		try {
			System.out.println(msg);
			takeScreenShot();
			test.log(Status.INFO, msg);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			test.log(Status.FAIL, "Please verify");
		}

	}
}

        
      