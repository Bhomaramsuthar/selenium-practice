package part3_4.com.demoqa.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FramePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By sampleHeading = By.id("sampleHeading");

    public FramePage(WebDriver driver){
        this.driver = driver;
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getFrameHeadingText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(sampleHeading)).getText();
    }
}
