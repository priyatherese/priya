package stepDef;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import static capston.Utilities.baseUtil.ObjectLaunched.reports;
import static capston.Utilities.baseUtil.ObjectLaunched.test;
import MyHooks.MyHooks;
import capston.Pages.loginPage;
import capston.Utilities.ExcelUtility.ReadDataFromExcelFile;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class LoginSteps {

	WebDriver driver;
	MyHooks hooks;
	loginPage lPage;

	public LoginSteps(MyHooks hook) {
		this.hooks = hook;
		this.driver = hooks.getDriver();
		this.lPage = new loginPage(driver);
		System.out.println("TESTING...");
//		test = reports.createTest("Login test");
	}

	@Given("The user launch the application URL")
	public void userLaunchApplicationURL() {
		lPage.navigateURL();

	}

	@When("The user login with valid credentails")
	public void enterValidCredentials() throws IOException {
		ReadDataFromExcelFile r = new ReadDataFromExcelFile();
		Object[][] username = r.getLoginData();
		
		for(int i=0;i<username.length;i++) {
			lPage.userLoginWithValidCredentails(username[i][0],username[i][1]);			
		}
	}

	@When("The user validate the page title {string}")
	public void userValidatePageTitle(String pageTitle) {
		lPage.checkPagetitle(pageTitle);
	}
	
	public static void main(String[] args) {
		MyHooks myHooks = new MyHooks();
		myHooks.tearUp();
		LoginSteps ls = new LoginSteps(myHooks);
		ls.userLaunchApplicationURL();
		try {
			ls.enterValidCredentials();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
