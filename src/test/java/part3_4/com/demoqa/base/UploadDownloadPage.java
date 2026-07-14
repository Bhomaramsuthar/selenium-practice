package part3_4.com.demoqa.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class UploadDownloadPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // 1. The Locators
    private By uploadInput = By.id("uploadFile");
    private By uploadedFilePathText = By.id("uploadedFilePath");

    // 2. The Constructor
    public UploadDownloadPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // 3. The Actions
    public void uploadFile(String absoluteFilePath) {
        // Notice we do NOT click the button! We just send the text path directly to it.
        driver.findElement(uploadInput).sendKeys(absoluteFilePath);
    }

    public String getUploadedFilePath() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(uploadedFilePathText)).getText();
    }
}