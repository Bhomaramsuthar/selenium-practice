package part3_4.com.demoqa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RadioButtonPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By yesRadioLabel = By.id("yesRadio");
    private By impressiveRadioLabel = By.id("impressiveRadio");
    private By successText = By.className("text-success");

    public RadioButtonPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickYes(){
        wait.until(ExpectedConditions.elementToBeClickable(yesRadioLabel)).click();
    }

    public void clickImpressive(){
        wait.until(ExpectedConditions.elementToBeClickable(impressiveRadioLabel)).click();
    }

    public String getResultTest(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successText)).getText();
    }

}
