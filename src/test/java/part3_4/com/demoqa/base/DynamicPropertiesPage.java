package part3_4.com.demoqa.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DynamicPropertiesPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // 1. The Locators
    private By enableAfterButton = By.id("enableAfter");
    private By colorChangeButton = By.id("colorChange");
    private By visibleAfterButton = By.id("visibleAfter");

    // 2. The Constructor
    public DynamicPropertiesPage(WebDriver driver) {
        this.driver = driver;
        // The website takes 5 seconds, so we set our max wait to 10 seconds to be safe!
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // 3. The Actions
    public boolean isButtonEnabledEventually() {
        // Waits until the button is no longer "disabled" and can actually be clicked
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(enableAfterButton));
        return button.isEnabled();
    }

    public boolean isColorChangedEventually() {
        // Waits until the HTML attribute "class" contains the word "text-danger" (which is red)
        return wait.until(ExpectedConditions.attributeContains(colorChangeButton, "class", "text-danger"));
    }

    public boolean isButtonVisibleEventually() {
        // Waits until the element physically appears on the screen
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(visibleAfterButton));
        return button.isDisplayed();
    }
}