package part3_4.com.demoqa.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckBoxPage {

    private WebDriver driver;
    private WebDriverWait wait; // The new explicit wait tool

    // Our rock-solid locators
    private By expandAllButton = By.cssSelector(".rct-option-expand-all");
    private By desktopCheckBox = By.xpath("//span[text()='Desktop']");
    private By resultText = By.id("result");

    public CheckBoxPage(WebDriver driver){
        this.driver = driver;
        // Initialize the wait: "I will actively hunt for elements for up to 15 seconds"
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void expandAll(){
        // Refuse to click until the specific button is ready
        wait.until(ExpectedConditions.elementToBeClickable(expandAllButton)).click();
    }

    public void checkDesktopBox(){
        wait.until(ExpectedConditions.elementToBeClickable(desktopCheckBox)).click();
    }

    public String getResult(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(resultText)).getText();
    }
}