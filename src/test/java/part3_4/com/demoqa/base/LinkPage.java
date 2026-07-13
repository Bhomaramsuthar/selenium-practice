package part3_4.com.demoqa.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LinkPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By homelink = By.id("simpleLink");

    public LinkPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickHomeLink(){

        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(homelink));
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", link);

        try {
            link.click();
        }catch(org.openqa.selenium.ElementClickInterceptedException e){
            ((org.openqa.selenium.JavascriptExecutor)driver).executeScript("argument[0].click();",link);
        }
    }



}
