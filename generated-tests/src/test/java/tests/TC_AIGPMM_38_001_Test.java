## TestScripts file=src/test/java/tests/TC_AIGPMM_38_001_Test.java type=SCRIPT
package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.CheckoutYourInformationPage;
import pages.YourCartPage;
import java.time.Duration;

public class TC_AIGPMM_38_001_Test {
    private WebDriver driver;
    private YourCartPage yourCartPage;
    private CheckoutYourInformationPage checkoutYourInformationPage;
    
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        
        // Navigate to the application login page
        driver.get("https://www.saucedemo.com/");
        
        // Perform login
        // Using placeholder login steps since test case assumes user logged in
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        
        // Select one or multiple products - placeholder: select first product by clicking add to cart
        driver.findElement(By.cssSelector(".inventory_item:first-child button")).click();
        
        // Navigate to Cart page
        driver.findElement(By.id("shopping_cart_container")).click();
        
        yourCartPage = new YourCartPage(driver);
        checkoutYourInformationPage = new CheckoutYourInformationPage(driver);
    }
    
    @Test(description = "Verify navigation to Checkout: Your Information page after clicking Checkout on Your Cart page")
    public void testNavigateToCheckoutYourInformationPage() {
        // Click Checkout button
        yourCartPage.clickCheckout();
        
        // Verify navigation to Checkout: Your Information page
        Assert.assertTrue(checkoutYourInformationPage.isPageLoaded(), "Checkout: Your Information page did not load.");
        
        // Verify mandatory fields are displayed
        Assert.assertTrue(checkoutYourInformationPage.areMandatoryFieldsDisplayed(), "Mandatory fields are not displayed on Checkout page.");
    }
    
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}