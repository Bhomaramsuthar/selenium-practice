package part3_4.com.demoqa.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebTablesPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By searchBox = By.id("searchBox");
    private By editButton = By.cssSelector("span[title='Edit']");
    private By ageInput = By.id("age");
    private By submitButton = By.id("submit");
    private By firstRowData = By.xpath("(//div[@role='row'])[2]");

    // 1. The NEW Locator: Just grab the whole table body!
    private By tableBody = By.cssSelector("rt-table");

    // ... (Keep your other methods exactly the same) ...

    // 2. The NEW Method
    public String getTableText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(tableBody)).getText();
    }

    public WebTablesPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void searchFor(String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox)).clear();
        driver.findElement(searchBox).sendKeys(text);
    }

    public void clickEdit() {
        wait.until(ExpectedConditions.elementToBeClickable(editButton)).click();
    }

    public void updateAge(String newAge){
        WebElement ageField = wait.until(ExpectedConditions.visibilityOfElementLocated(ageInput));
        ageField.clear();
        ageField.sendKeys(newAge);
    }

    public void clickSubmit(){
        driver.findElement(submitButton).click();
    }

    public String getFirstRowText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(firstRowData)).getText();
    }
}
