## TestScripts file=src/test/java/pages/LoginPage.java type=POM
package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class LoginPage {
    private WebDriver driver;
    // Locators (placeholders)
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void enterUsername(String username) {
        WebElement userInput = driver.findElement(usernameField);
        userInput.clear();
        userInput.sendKeys(username);
    }
    public void enterPassword(String password) {
        WebElement passInput = driver.findElement(passwordField);
        passInput.clear();
        passInput.sendKeys(password);
    }
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
    public boolean isLoginFormDisplayed() {
        return driver.findElement(usernameField).isDplayed() && driver.findElement(passwordField).isDplayed();
    }
}