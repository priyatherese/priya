package capston.Utilities.baseUtil;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import capston.Utilities.reports.Extentreporter;


public class ObjectLaunched {

	public WebDriver driver = null;
	public static File file;
	public static FileInputStream fis;
	public static Properties prop;
	public static ExtentReports reports;
	//new
	public static ExtentTest test;

	public void setupMyFramework() {
		startSelenium();
		init();
	}

	public void init() {
		try {
			file = new File("C:\\Users\\Jim\\eclipse-workspace\\SA2411063\\capston\\OB.properties");
			fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
	        ExtentReports extent = new ExtentReports();
	        extent.attachReporter(sparkReporter);

	        // Step 2: Create a test
	        test = extent.createTest("My First Test")
	                                .assignAuthor("QA Tester")
	                                .assignCategory("Regression")
	                                .assignDevice("Chrome");
			reports = Extentreporter.getReports();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void startSelenium() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
	}

	public void stopsSelenium() {
		driver.close();
		driver.quit();
		reports.flush();
		
	}
}
