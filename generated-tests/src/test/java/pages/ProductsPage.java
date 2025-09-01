## TestScripts file=src/test/java/pages/ProductsPage.java type=POM
package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class ProductsPage {
    private WebDriver driver;
    // Locator for a unique element on Products page to verify successful login
    private By productsTitle = By.className("title");
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isProductsPageDisplayed() {
        return driver.findElement(productsTitle).isDplayed();
    }
}