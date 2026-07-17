package part3_4.com.demoqa.base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormsPage {
    private WebDriver driver;

    // Locators
    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By email = By.id("userEmail");
    private By genderMale = By.xpath("//label[text()='Male']");
    private By mobile = By.id("userNumber");
    private By dobInput = By.id("dateOfBirthInput");
    private By subjectsInput = By.id("subjectsInput");
    private By hobbiesSports = By.xpath("//label[text()='Sports']");
    private By uploadPicture = By.id("uploadPicture");
    private By address = By.id("currentAddress");
    private By state = By.id("state");
    private By city = By.id("city");
    private By submit = By.id("submit");
    private By confirmationModal = By.className("modal-content");

    // Constructor
    public FormsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void enterName(String fName, String lName) {
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
    }

    public void enterEmail(String mail) {
        driver.findElement(email).sendKeys(mail);
    }

    public void selectGenderMale() {
        driver.findElement(genderMale).click();
    }

    public void enterMobile(String number) {
        driver.findElement(mobile).sendKeys(number);
    }

    public void selectDOB(String month, String year, String day) {
        driver.findElement(dobInput).click();
        Select monthSelect = new Select(driver.findElement(By.className("react-datepicker__month-select")));
        monthSelect.selectByVisibleText(month);
        Select yearSelect = new Select(driver.findElement(By.className("react-datepicker__year-select")));
        yearSelect.selectByVisibleText(year);
        driver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--0" + day + "']")).click();
    }

    public void enterSubject(String subject) {
        WebElement subjectsInput = driver.findElement(By.id("subjectsInput"));
        subjectsInput.sendKeys(subject);
        subjectsInput.sendKeys(Keys.ENTER); // commit the selection
        // optional: wait until the selected subject chip appears
    }


    public void selectHobbySports() {
        WebElement sportsCheckbox = driver.findElement(By.id("hobbies-checkbox-1"));

        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sportsCheckbox);

        // Use JavaScript click to bypass interception
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sportsCheckbox);
    }


    public void uploadFile(String filePath) {
        driver.findElement(uploadPicture).sendKeys(filePath);
    }

    public void enterAddress(String addr) {
        WebElement address = driver.findElement(By.id("currentAddress"));
        address.clear();
        address.sendKeys(addr);
        address.sendKeys(Keys.TAB); // trigger blur if the app updates on blur
    }


    public void selectStateAndCity(String stateName, String cityName) {
        WebElement stateContainer = driver.findElement(By.id("state"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", stateContainer);
        stateContainer.click();
        WebElement stateInput = driver.findElement(By.id("react-select-3-input"));
        stateInput.sendKeys(stateName);
        stateInput.sendKeys(Keys.ENTER);

        WebElement cityContainer = driver.findElement(By.id("city"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cityContainer);
        cityContainer.click();
        WebElement cityInput = driver.findElement(By.id("react-select-4-input"));
        cityInput.sendKeys(cityName);
        cityInput.sendKeys(Keys.ENTER);
    }

    public void waitForFormStable() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // Example: wait until the Subjects chip is visible or state input shows selected value
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".subjects-auto-complete .css-1rhbuit-multiValue")));
    }




    public void submitForm() {
        driver.findElement(By.id("submit")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-content")));
    }

    public String getConfirmationValue(String label) {
        // modal has table rows like <td>Label</td><td>Value</td>
        String xpath = "//td[text()='" + label + "']/following-sibling::td";
        return driver.findElement(By.xpath(xpath)).getText().trim();
    }

}