package part3_4.com.demoqa.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.PrivateKey;
import java.time.Duration;

public class BrowserWindowsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //locator
    private By newTab = By.id("tabButton");
    private By newWindow = By.id("windowButton");
    private By newWindowMessage = By.id("messageWindowButton");
    private By sampleHeading = By.id("sampleHeading");

    //constructor
    public BrowserWindowsPage(WebDriver driver){
            this.driver=driver;
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //actions
    public void clickNewTab(){
        wait.until(ExpectedConditions.elementToBeClickable(newTab)).click();
    }

    public void clickNewWindow(){
        wait.until(ExpectedConditions.elementToBeClickable(newWindow)).click();
    }

    public void clickNewWindowMessage(){
        wait.until(ExpectedConditions.elementToBeClickable(newWindowMessage)).click();
    }

    public String getHeadingText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(sampleHeading)).getText();
    }
}
