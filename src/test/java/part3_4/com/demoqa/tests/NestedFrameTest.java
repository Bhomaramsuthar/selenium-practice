package part3_4.com.demoqa.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import part3_4.com.demoqa.base.NestedFramesPage;

public class NestedFrameTest {

    WebDriver driver ;
    NestedFramesPage nestedFramesPage;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/nestedframes");
        nestedFramesPage= new NestedFramesPage(driver);
    }

    @Test
    public void testNestedFrame() throws InterruptedException {

        org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
        Thread.sleep(500);

        //switch to parent id
        driver.switchTo().frame("frame1");
        String parentText = nestedFramesPage.getParentFrameText();
        Assert.assertEquals(parentText,"Parent frame","Parent text didnt match");

        //switch to child id
        // We are already inside the Parent. Now we step one level deeper.
        // Since there is no ID, we use index '0' (the first and only iframe inside the parent)
        driver.switchTo().frame(0);
        String childText = nestedFramesPage.getChildFrameText();
        Assert.assertEquals(childText,"Child Iframe","Child text didnt match");

        // --- STEP 3: Escape the Inception ---
        // If we used driver.switchTo().parentFrame(), we'd step back up to the Parent.
        // But defaultContent() safely ejects us all the way back to the main webpage instantly!
        driver.switchTo().defaultContent();
    }


    @AfterTest
    public void tearUp(){
        driver.quit();
    }

}
