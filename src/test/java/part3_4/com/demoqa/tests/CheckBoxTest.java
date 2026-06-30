package part3_4.com.demoqa.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import part3_4.com.demoqa.base.CheckBoxPage;

public class CheckBoxTest {
    WebDriver driver;
    CheckBoxPage checkBoxPage;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // --- NEW CODE: The Global Wait ---
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
        // ---------------------------------

        driver.get("https://demoqa.com/checkbox");
        checkBoxPage = new CheckBoxPage(driver);
    }

    @Test
    public void testDesktopCheckboxResult() throws InterruptedException {
        // 1. Scroll safely using JavaScript (No driver.findElement in the test!)
        //org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,300)");
        Thread.sleep(500);

        // 2. Expand and wait
        checkBoxPage.expandAll();
        Thread.sleep(500);

        // 3. Click Desktop
        checkBoxPage.checkDesktopBox();

        // 4. Validate
        String actualResult = checkBoxPage.getResult();
        Assert.assertTrue(actualResult.contains("desktop"),"Desktop was not Selected");
        Assert.assertTrue(actualResult.contains("notes"),"Notes was not Selected");
        Assert.assertTrue(actualResult.contains("commands"),"Commands was not Selected");
    }

    @AfterClass
    public void tearUp(){
        driver.quit();
    }
}