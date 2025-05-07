package testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.AdminPage;
import testBase.BaseClass;

public class TC2_AdminStore extends BaseClass {

    @Test
    public void verify_dashboard() throws InterruptedException {
        

            // Interact with dashboard
            AdminPage ap = new AdminPage(driver);

            // Verify and print left menu items
            int count = ap.getMenuItemCount();
            System.out.println("Menu item count: " + count);
            Assert.assertEquals(count, 12, "Menu count mismatch");

            ap.printMenuItems();

            // Click on Admin menu and verify
            ap.clickAdminMenu();
            Assert.assertTrue(ap.isAdminPageDisplayed(), "Admin page not displayed");
            
            
            System.out.println("Searching by User name: Admin");

            // Enter username
            WebElement usernameField = driver.findElement(By.xpath("//label[text()='Username']/following::input[1]"));
            usernameField.clear();
            usernameField.sendKeys("Admin");

            // Click Search button
            WebElement searchBtn = driver.findElement(By.xpath("//button[normalize-space()='Search']"));
            searchBtn.click();

            // Wait and fetch result rows
            Thread.sleep(3000); // Use explicit wait in real framework
            List<WebElement> rows = driver.findElements(By.xpath("//div[@role='rowgroup']/div"));
            System.out.println("Total records found: " + rows.size());

            // Refresh the page
            driver.navigate().refresh();
            
            Thread.sleep(2000); // Wait for refresh

            // --- Search by User Role ---
            System.out.println("Searching by User Role: Admin");

            // Click and select 'Admin' from dropdown
            WebElement userRoleDropdown = driver.findElement(By.xpath("//label[text()='User Role']/following::div[@class='oxd-select-text oxd-select-text--active'][1]"));
            userRoleDropdown.click();

            WebElement adminOption = driver.findElement(By.xpath("//div[@role='option']//span[text()='Admin']"));
            adminOption.click();

            // Click Search
            driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();

            Thread.sleep(2000);
            List<WebElement> roleRows = driver.findElements(By.xpath("//div[@role='rowgroup']/div"));
            System.out.println("Records found by User Role (Admin): " + roleRows.size());
            
            
            

            // Refresh the page
            driver.navigate().refresh();
            //search by userstatus
            System.out.println("Searching by User Status: Enabled");
            WebElement statusDropdown = driver.findElement(By.xpath("//label[text()='Status']/following::div[contains(@class,'oxd-select-text')]"));
            statusDropdown.click();
            WebElement enabledOption = driver.findElement(By.xpath("//div[@role='option']//span[text()='Enabled']"));
            enabledOption.click();

            driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
            Thread.sleep(2000);
            List<WebElement> statusRows = driver.findElements(By.xpath("//div[@role='rowgroup']/div"));
            System.out.println("Records found by Status (Enabled): " + statusRows.size());

            driver.navigate().refresh();
        }
    
        }
    

        
    

