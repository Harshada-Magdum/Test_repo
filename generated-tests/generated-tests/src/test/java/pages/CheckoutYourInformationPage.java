## TestScripts file=generated-tests/src/test/java/pages/CheckoutYourInformationPage.java type=REFERENCE
package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class CheckoutYourInformationPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By postalCodeField = By.id("postal-code");
    private By pageHeader = By.className("title");
    public CheckoutYourInformationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public boolean isPageLoaded() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pageHeader)).isDplayed();
    }
    public boolean areMandatoryFieldsDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).isDplayed() &&
               wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField)).isDplayed() &&
               wait.until(ExpectedConditions.visibilityOfElementLocated(postalCodeField)).isDplayed();
    }
    public String getPageHeaderText() {
        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(pageHeader));
        return header.getText();
    }
}