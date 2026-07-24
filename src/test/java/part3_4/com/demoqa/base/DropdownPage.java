package part3_4.com.demoqa.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage {
    private WebDriver driver;
    private By oldSelectMenu = By.id("oldSelectMenu");

    public DropdownPage(WebDriver driver){
        this.driver=driver;
    }
    public void selectColorByText(String color){
        Select dropdown = new Select(driver.findElement(oldSelectMenu));
        dropdown.selectByVisibleText(color);
    }

    public String getSelectedColor(){
        Select dropdown = new Select(driver.findElement(oldSelectMenu));
        return dropdown.getFirstSelectedOption().getText();
    }

}
