package part3_4.com.demoqa.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import part3_4.com.demoqa.base.DynamicPropertiesPage;

public class DynamicPropertiesTest {
    WebDriver driver;
    DynamicPropertiesPage dynamicPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/dynamic-properties");
        dynamicPage = new DynamicPropertiesPage(driver);
    }

    @Test
    public void testDynamicElements() throws InterruptedException {
        // Scroll down slightly to avoid the footer ad
        org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");

        // 1. Test the button that starts disabled
        boolean isEnabled = dynamicPage.isButtonEnabledEventually();
        Assert.assertTrue(isEnabled, "The button never became clickable!");
        System.out.println("Success: Button is now enabled!");

        // 2. Test the button that changes color
        boolean isColorChanged = dynamicPage.isColorChangedEventually();
        Assert.assertTrue(isColorChanged, "The button never changed color!");
        System.out.println("Success: Button color changed to red!");

        // 3. Test the button that appears out of nowhere
        boolean isVisible = dynamicPage.isButtonVisibleEventually();
        Assert.assertTrue(isVisible, "The hidden button never appeared!");
        System.out.println("Success: Hidden button is now visible!");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}