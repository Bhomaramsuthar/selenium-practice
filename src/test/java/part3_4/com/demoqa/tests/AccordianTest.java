package part3_4.com.demoqa.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import part3_4.com.demoqa.base.AccordianPage;

public class AccordianTest {
    WebDriver driver;
    AccordianPage accordianPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Notice DemoQA's spelling of "accordian" here!
        driver.get("https://demoqa.com/accordian");
        accordianPage = new AccordianPage(driver);
    }

    @Test
    public void testAccordianExpanding() throws InterruptedException {
        // Scroll down slightly for a better view
        org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
        Thread.sleep(500);

        // --- STEP 1: Verify Section 1 (Open by default) ---
        String section1Text = accordianPage.getSection1Text();
        Assert.assertTrue(section1Text.contains("Lorem Ipsum is simply dummy text"), "Section 1 text did not match!");
        System.out.println("Success: Section 1 is open and readable.");

        // --- STEP 2: Open Section 2 ---
        accordianPage.clickSection2();

        // --- STEP 3: Verify Section 2 ---
        // Selenium will automatically wait for the animation to finish because of our Page Class logic!
        String section2Text = accordianPage.getSection2Text();
        Assert.assertTrue(section2Text.contains("Contrary to popular belief"), "Section 2 text did not match!");
        System.out.println("Success: Section 2 expanded and is readable.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}