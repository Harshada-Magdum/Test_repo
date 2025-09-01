## TestScripts file=src/test/java/tests/TC_AIGPMM_38_001_Test.java type=SCRIPT
package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
public class TC_AIGPMM_38_001_Test {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }
    @Test(description = "Verify user can login successfully with valid credentials")
    public void testValidLogin() {
        // Verify login form is displayed
        Assert.assertTrue(loginPage.isLoginFormDisplayed(), "Login form is not displayed");
        // Enter username and password
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        // Click login button
        loginPage.clickLogin();
        // Wait and verify user is redirected to Products page
        // Simple implicit wait or explicit wait could be added here for production code
        try {
            Thread.sleep(2000); // Replace with explicit wait in real scenarios
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(productsPage.isProductsPageDisplayed(), "Products page is not displayed after login");
    }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}