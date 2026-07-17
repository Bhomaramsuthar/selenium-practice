package part3_4.com.demoqa.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v146.network.model.AlternateProtocolUsage;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //locator
    private By alertButton = By.id("alertButton");
    private By timerAlertButton = By.id("timerAlertButton");
    private By confirmButton = By.id("confirmButton");
    private By confirmResult = By.id("confirmResult");
    private By promptButton = By.id("promtButton");
    private By promptResult = By.id("promptResult");

    //constructor
    public AlertsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //actions
    public void clickAlert(){
        driver.findElement(alertButton).click();
    }

    public void clickTimerAlert(){
        driver.findElement(timerAlertButton).click();
    }

    public void clickconfirmBox(){
        driver.findElement(confirmButton).click();
    }

    public String getConfirmResult(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(confirmResult)).getText();
    }

    public void clickpromptBox(){
        driver.findElement(promptButton).click();
    }

    public String getpromptResult(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(promptResult)).getText();
    }

}
