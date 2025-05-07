package capston.Utilities.baseUtil;

import static capston.Utilities.baseUtil.ObjectLaunched.prop;
import static capston.Utilities.baseUtil.ObjectLaunched.test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import capston.Utilities.reports.Extentreporter;

public class coreFunctions {

	protected WebDriver driver;

	public coreFunctions(WebDriver driver) {
		this.driver = driver;
	}

	public void navigateURL() {
		driver.get(prop.getProperty("applicationURL"));
		log("User navigates to " + prop.getProperty("applicationURL"));
	}

	public void type(String locator, Object testData) {
		driver.findElement(By.xpath(prop.getProperty(locator))).sendKeys(String.valueOf(testData));
		log("Enter " + "'"+testData + "'" + "-" + prop.getProperty(locator));
	}

	public void clickElement(String locator) {
		driver.findElement(By.xpath(prop.getProperty(locator))).click();
		log("Click on " + prop.getProperty(locator));
	}

	public void validateTitle(String Expectedtitle) {
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(Expectedtitle, ActualTitle);
	}

	public void takeScreenShot() {
		// fileName of the screenshot
		Date d = new Date();
		String screenshotFile = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		String filePath = Extentreporter.screenshotFolderPath;
		// take screenshot
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			// get the dynamic folder name
			FileUtils.copyFile(srcFile, new File(filePath + "//" + screenshotFile));
			// put screenshot file in reports
			test.log(Status.INFO, "Screenshot-> " + test.addScreenCaptureFromPath(filePath + "//" + screenshotFile));
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
