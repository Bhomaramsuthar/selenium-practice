package part3_4.com.demoqa.base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LinkPage {
    private WebDriver driver;
    private WebDriverWait wait;

    //locators
    private By homelink = By.id("simpleLink");
    private By dynamicLink = By.id("dynamicLink");

    //API links
    private By createdLink = By.id("created");
    private By noContentLink = By.id("no-content");
    private By MovedLink = By.id("moved");
    private By badRequestLink = By.id("bad-request");
    private By unauthorizedLink = By.id("unauthorized");
    private By forbiddenLink = By.id("forbidden");
    private By notFoundLink = By.id("invalid-url");

    //response
    private By response = By.id("linkResponse");


    //Constructor
    public LinkPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    //Helper function to make a safe click on the links
    public void safeClick(By locater){
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(locater));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                element);

        try{
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor)driver).executeScript("arguments[0].click()",element);
        }
    }

    //Actions
    public void clickHomeLink(){safeClick(homelink);}
    public void clickDynamicLink(){safeClick(dynamicLink);}
    public void clickCreatedLink(){safeClick(createdLink);}
    public void clickNoContentLink(){safeClick(noContentLink);}
    public void clickMovedLink(){safeClick(MovedLink);}
    public void clickBadRequestLink(){safeClick(badRequestLink);}
    public void clickNotFoundLink(){

        safeClick(notFoundLink);
    }

    //response
    public String getLinkResponse(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(response)).getText();
    }

}
