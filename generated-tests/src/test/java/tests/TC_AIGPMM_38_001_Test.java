## TestScripts file=src/test/java/tests/TC_AIGPMM_38_001_Test.java type=SCRIPT
package tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;
import java.time.Duration;
public class TC_AIGPMM_38_001_Test {
    private WebDriver driver;
    private WebDriverWait wait;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CartPage cartPage;
    private final String baseUrl = "https://www.saucedemo.com/";
    private final String username = "standard_user";
    private final String password = "secret_sauce";
    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void setupTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(baseUrl);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
    }
    @Test(description = "Verify navigation to Checkout: Your Information page after clicking Checkout on Your Cart page")
    public void testCheckoutNavigation() {
        try {
            // Step 1: Login
            loginPage.login(username, password);
            // Step 2: Select one or multiple products on Products page (add all for simplicity)
            productsPage.addAllProductsToCart();
            // Step 3: Click on Cart icon
            productsPage.clickCartIcon();
            // Step 4: Click on Checkout button
            cartPage.clickCheckout();
            // Verification: Wait for Checkout: Your Information page elements
            By firstNameField = By.id("first-name");
            By lastNameField = By.id("last-name");
            By postalCodeField = By.id("postal-code");
            wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
            wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField));
            wait.until(ExpectedConditions.visibilityOfElementLocated(postalCodeField));
            Assert.assertTrue(driver.findElement(firstNameField).isDisplayed(), "First Name field is not displayed");
            Assert.assertTrue(driver.findElement(lastNameField).isDisplayed(), "Last Name field is not displayed");
            Assert.assertTrue(driver.findElement(postalCodeField).isDisplayed(), "Postal Code field is not displayed");
        } catch (Exception e) {
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}