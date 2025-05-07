package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminPage extends BasePage {

    public AdminPage(WebDriver driver) {
		super(driver);
	}
 // Locator for left menu items
    By menuItemsLocator = By.xpath("//ul[@class='oxd-main-menu']/li");

    // Locator for Admin page 
    By adminHeader = By.xpath("//h6[text()='Admin']");

    public List<WebElement> getLeftMenuItems() {
        return driver.findElements(menuItemsLocator);
    }

    public int getMenuItemCount() {
        return getLeftMenuItems().size();
    }

    public void printMenuItems() {
        System.out.println("Left Menu Options:");
        for (WebElement item : getLeftMenuItems()) {
            System.out.println(item.getText());
        }
    }

    public void clickAdminMenu() {
        for (WebElement item : getLeftMenuItems()) {
            if (item.getText().contains("Admin")) {
                item.click();
                break;
            }
        }
    }

    public boolean isAdminPageDisplayed() {
        return driver.findElement(adminHeader).isDisplayed();
    }
}
