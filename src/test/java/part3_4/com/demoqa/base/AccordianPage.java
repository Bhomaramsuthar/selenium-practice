package part3_4.com.demoqa.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AccordianPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // 1. The Locators
    private By section1Heading = By.id("section1Heading");
    private By section1Content = By.id("section1Content");

    private By section2Heading = By.id("section2Heading");
    private By section2Content = By.id("section2Content");

    // 2. The Constructor
    public AccordianPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // 3. The Actions
    public String getSection1Text() {
        // Wait for it to be fully visible before reading
        return wait.until(ExpectedConditions.visibilityOfElementLocated(section1Content)).getText();
    }

    public void clickSection2() {
        // Wait for the header to be clickable, then click it
        wait.until(ExpectedConditions.elementToBeClickable(section2Heading)).click();
    }

    public String getSection2Text() {
        // Wait for the slide-down animation to finish and the text to be visible
        return wait.until(ExpectedConditions.visibilityOfElementLocated(section2Content)).getText();
    }
}