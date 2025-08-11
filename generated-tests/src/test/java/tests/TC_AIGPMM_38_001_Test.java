=src/test/java/tests/TC_AIGPMM_38_001_Test.java type=SCRIPT
package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.CartPage;
import pages.CheckoutYourInformationPage;
public class TC_AIGPMM_38_001_Test {
    private WebDriver driver;
    private CartPage cartPage;
    private CheckoutYourInformationPage checkoutPage;
    private final String baseUrl = "https://www.saucedemo.com/";
    private final String username = "standard_user";
    private final String password = "secret_sauce";
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        // Login steps
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutYourInformationPage(driver);
    }
    @Test(description = "Verify navigation to Checkout: Your Information page after clicking Checkout on Your Cart page")
    public void testNavigateToCheckoutYourInformationPage() {
        // Select products - placeholder: select first product add to cart
        driver.findElement(By.cssSelector(".inventory_item:first-child button")).click();
        // Click Cart icon
        driver.findElement(By.className("shopping_cart_link")).click();
        // Click Checkout button
        cartPage.clickCheckout();
        // Verify navigation to Checkout Your Information page
        Assert.assertTrue(checkoutPage.isPageLoaded(), "Checkout Your Information page is not loaded.");
        // Verify mandatory fields are displayed
        Assert.assertTrue(checkoutPage.areMandatoryFieldsDisplayed(), "Mandatory fields are not displayed.");
        // Verify page header text
        String headerText = checkoutPage.getPageHeaderText();
        Assert.assertEquals(headerText, "Checkout: Your Information", "Page header text mismatch.");
    }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}