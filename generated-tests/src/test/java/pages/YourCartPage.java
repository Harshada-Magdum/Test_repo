## TestScripts file=src/test/java/pages/YourCartPage.java type=POM
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class YourCartPage {
    private WebDriver driver;
    private WebDriverWait wait;
    
    // Placeholder locator for Checkout button on Your Cart page
    private By checkoutButton = By.id("checkout");
    
    public YourCartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    public void clickCheckout() {
        WebElement checkoutBtn = wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
        checkoutBtn.click();
    }
}