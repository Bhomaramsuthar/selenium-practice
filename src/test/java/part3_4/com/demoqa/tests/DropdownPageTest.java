package part3_4.com.demoqa.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import part3_4.com.demoqa.base.DropdownPage;

import static part2.com.saucedemo.base.BasePage.driver;

public class DropdownPageTest {

    WebDriver driver ;

    @BeforeMethod
    public void setUp() {
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");
    }

    @Test
    public void testStandardDropdown() {
        DropdownPage dropdownPage = new DropdownPage(driver);
        dropdownPage.selectColorByText("Purple");
        Assert.assertEquals(dropdownPage.getSelectedColor(), "Purple");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}