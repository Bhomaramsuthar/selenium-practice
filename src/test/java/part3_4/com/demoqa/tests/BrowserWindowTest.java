package part3_4.com.demoqa.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import part3_4.com.demoqa.base.BrowserWindowsPage;

import java.util.Set;

public class BrowserWindowTest {
    WebDriver driver;
    BrowserWindowsPage browserWindowsPage;

    @BeforeClass
    public void SetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/browser-windows");
        browserWindowsPage = new BrowserWindowsPage(driver);
    }

    @Test
    public void testNewTab() {
        String parent = driver.getWindowHandle();
        browserWindowsPage.clickNewTab();

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(parent)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        String text = browserWindowsPage.getHeadingText();
        Assert.assertEquals(text, "This is a sample page", "New Tab text mismatch");

        driver.close();
        driver.switchTo().window(parent);
    }

    @Test
    public void testNewWindow() {
        String parent = driver.getWindowHandle();
        browserWindowsPage.clickNewWindow();

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(parent)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        String text = browserWindowsPage.getHeadingText();
        Assert.assertEquals(text, "This is a sample page", "New Window text mismatch");

        driver.close();
        driver.switchTo().window(parent);
    }

    @Test
    public void testNewWindowMessage() {
        String parent = driver.getWindowHandle();
        browserWindowsPage.clickNewWindowMessage();

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(parent)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        String bodyText = driver.findElement(org.openqa.selenium.By.tagName("body")).getText();
        Assert.assertTrue(bodyText.length() > 0, "Message window should contain text");

        driver.close();
        driver.switchTo().window(parent);
    }

    @AfterClass
    public void tearUp() {
        if (driver != null) {
            driver.quit();
        }
    }
}
