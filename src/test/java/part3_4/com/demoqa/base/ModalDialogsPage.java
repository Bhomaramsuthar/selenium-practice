package part3_4.com.demoqa.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ModalDialogsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // 1. The Locators
    private By smallModalButton = By.id("showSmallModal");
    private By modalBodyText = By.className("modal-body");
    private By closeSmallModalButton = By.id("closeSmallModal");

    // 2. The Constructor
    public ModalDialogsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // 3. The Actions
    public void clickSmallModalButton() {
        wait.until(ExpectedConditions.elementToBeClickable(smallModalButton)).click();
    }

    public String getModalText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(modalBodyText)).getText();
    }

    public void clickCloseModal() {
        wait.until(ExpectedConditions.elementToBeClickable(closeSmallModalButton)).click();
    }
}