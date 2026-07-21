package part3_4.com.demoqa.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NestedFramesPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //locators
    private By parentBodyText = By.tagName("body");
    private By childParaText = By.tagName("p");

    //constructor
    public NestedFramesPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //actions
    public String getParentFrameText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(parentBodyText)).getText();
    }

    public String getChildFrameText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(childParaText)).getText();
    }

}
