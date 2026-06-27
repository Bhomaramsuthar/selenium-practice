package part3_4.com.demoqa.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariTechPreviewDriverInfo;

public class TextBoxPage {

    private WebDriver driver;

    private By fullNameInput = By.id("userName");
    private By emailInput= By.id("userEmail");
    private By currentAddressInput = By.id("currentAddress");
    private By permanentAddressInput = By.id("permanentAddress");
    private By submitButton = By.id("submit");
    private By outputBox = By.id("output");

    public TextBoxPage(WebDriver driver){
        this.driver = driver;
    }

    public void fillform(String name,String email,String currentAddress,String permanentAddress){
        driver.findElement(fullNameInput).sendKeys(name);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(currentAddressInput).sendKeys(currentAddress);
        driver.findElement(permanentAddressInput).sendKeys(permanentAddress);
    }

    public void clickSubmit(){
        driver.findElement(submitButton).click();
    }

    public String getOutputText(){
        return driver.findElement(outputBox).getText();
    }
}
