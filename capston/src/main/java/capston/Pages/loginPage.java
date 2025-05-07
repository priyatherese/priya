package capston.Pages;

import org.openqa.selenium.WebDriver;

import capston.Utilities.baseUtil.coreFunctions;

public class loginPage extends coreFunctions {

	// file holds all locatora and functions belongs the login page

	public loginPage(WebDriver driver) {
		super(driver);
	
	}

	public void navigate() {
		navigateURL();
	}

	public void userLoginWithValidCredentails(Object username, Object password) {
		type("username",username);
		type("password", password);
		clickElement("login");

	}
	
	public void checkPagetitle(String pageTitle) {
		validateTitle(pageTitle);
	}

//		
//	}
}
