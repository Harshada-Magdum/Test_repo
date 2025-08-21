## TestScripts file=generated-tests/src/test/java/pages/ProductsPage.java type=REFERENCE
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
    private By addToCartButtons = By.cssSelector("button.btn_inventory");
    private By cartIcon = By.id("shopping_cart_container");
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void addAllProductsToCart() {
        List<WebElement> buttons = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(addToCartButtons));
        for (WebElement button : buttons) {
            button.click();
        }
    }
    public void clickCartIcon() {
        WebElement cart = wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
        cart.click();
    }
}