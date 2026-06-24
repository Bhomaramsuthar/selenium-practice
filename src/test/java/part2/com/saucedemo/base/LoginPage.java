package part2.com.saucedemo.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    // ------------------------------------
    // 1. LOCATORS (Private)
    // ------------------------------------
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessageText = By.cssSelector("[data-test='error']");

    // ------------------------------------
    // 2. CONSTRUCTOR
    // ------------------------------------
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // ------------------------------------
    // 3. ACTION METHODS (Public)
    // ------------------------------------
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessageText).getText();
    }

    // Optional: A "Helper" method that combines actions for faster testing
    public void loginAs(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    // This clears your "Cannot resolve method 'logIntoApplication'" error!
    public ProductsPage logIntoApplication(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();

        // Because clicking "Login" takes us to the Products page,
        // we return a brand new ProductsPage object back to the test script!
        return new ProductsPage(driver);
    }
}