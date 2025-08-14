## TestScripts file=src/test/java/pages/ProductsPage.java type=POM
package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
public class ProductsPage {
    private WebDriver driver;
    private WebDriverWait wait;
    // Locator for all "Add to cart" buttons
    private By addToCartButtons = By.cssSelector("button.btn_inventory");
    // Locator for cart icon
    private By cartIcon = By.id("shopping_cart_container");
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void addAllProductsToCart() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(addToCartButtons));
        List<WebElement> buttons = driver.findElements(addToCartButtons);
        for (WebElement button : buttons) {
            if (button.isDisplayed() && button.isEnabled()) {
                button.click();
            }
        }
    }
    public void clickCartIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
    }
}