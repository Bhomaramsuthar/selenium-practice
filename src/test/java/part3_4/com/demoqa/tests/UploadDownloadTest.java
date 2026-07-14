package part3_4.com.demoqa.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import part3_4.com.demoqa.base.UploadDownloadPage;

public class UploadDownloadTest {
    WebDriver driver;
    UploadDownloadPage uploadPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/upload-download");
        uploadPage = new UploadDownloadPage(driver);
    }

    @Test
    public void testFileUpload() throws InterruptedException {
        // Scroll down to ensure the upload button is visible
        org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
        Thread.sleep(500);

        // 1. Get the absolute path to your pom.xml file dynamically
        // (System.getProperty("user.dir") gets your current project folder path!)
        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + "\\pom.xml";

        // 2. Upload the file
        uploadPage.uploadFile(filePath);

        // 3. Grab the success text that appears on the website
        String resultText = uploadPage.getUploadedFilePath();

        // 4. Verify that the website recognized "pom.xml"
        Assert.assertTrue(resultText.contains("pom.xml"), "The file was not uploaded correctly!");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}