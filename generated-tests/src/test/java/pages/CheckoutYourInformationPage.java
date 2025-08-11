## TestScripts file=src/test/java/pages/CheckoutYourInformationPage.java type=POM
package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class CheckoutYourInformationPage {
    private WebDriver driver;
    private WebDriverWait wait;
    // Placeholder locators for mandatory fields
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By postalCodeField = By.id("postal-code");
    // Placeholder locator for page header
    private By pageHeader = By.className("title");
    public CheckoutYourInformationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public boolean isPageLoaded() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pageHeader)).isDplayed();
    }
    public boolean areMandatoryFieldsDisplayed() {
        return driver.findElement(firstNameField).isDplayed() &&
               driver.findElement(lastNameField).isDplayed() &&
               driver.findElement(postalCodeField).isDplayed();
    }
    public String getPageHeaderText() {
        return driver.findElement(pageHeader).getText();
    }
}