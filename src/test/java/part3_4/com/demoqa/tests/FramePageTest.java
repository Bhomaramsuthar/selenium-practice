package part3_4.com.demoqa.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import part3_4.com.demoqa.base.FramePage;

public class FramePageTest {

    WebDriver driver;
    FramePage framePage;

    @BeforeMethod
    public void setUp() {
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/frames");
        framePage =new FramePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testGetFrameHeadingText() throws InterruptedException {

        org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
        Thread.sleep(500);

        //switch to the frame
        driver.switchTo().frame("frame1");

        //get the frame text
        String heading = framePage.getFrameHeadingText();

        Assert.assertEquals(heading,"This is a sample page","Didnt match the heading");
        System.out.println("Success:Found the text inside the frame");

        //switch back
        driver.switchTo().defaultContent();

    }
}