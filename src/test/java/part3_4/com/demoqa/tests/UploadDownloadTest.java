package part3_4.com.demoqa.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import part3_4.com.demoqa.base.UploadDownloadPage;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class UploadDownloadTest {
    WebDriver driver;
    UploadDownloadPage uploadPage;

    @BeforeClass
    public void setUp() {
        //creating a download folder for checking the download functionality
        String downloadPath = System.getProperty("user.dir")+"\\downloads";
        File downloadDir = new File(downloadPath);
        //if doesnt the make one
        if(!downloadDir.exists()) downloadDir.mkdir();

        //using the chrome option to make the browser more controllable
        ChromeOptions options= new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-popup-blocking");

        // Correct way: set prefs
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadDir.getAbsolutePath());
        prefs.put("download.prompt_for_download", false);
        prefs.put("download.directory_upgrade", true);
        prefs.put("safebrowsing.enabled", true);
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
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

    @Test
    public void testDownloadFile() throws InterruptedException {
        uploadPage.downloadFile();

        String downloadPath = System.getProperty("user.dir")+"\\downloads";
        File downloadDir = new File(downloadPath);

        boolean fileDownloaded = false;
        for(int i=0;i<10;i++){
           File[] files = downloadDir.listFiles();
            if(files!=null && files.length>0 && files[0].length()>0){
                fileDownloaded=true ;
                break;
            }
            Thread.sleep(1000);
        }
        Assert.assertTrue(fileDownloaded,"File was not downloaded");
    }

    @AfterClass
    public void tearDown() {
        String downloadPath = System.getProperty("user.dir") + "\\downloads";
        File downloadedFile = new File(downloadPath + "\\sampleFile.jpeg");

        if (downloadedFile.exists()) {
            boolean deleted = downloadedFile.delete();
            System.out.println("Deleted file: " + deleted);
        }

        driver.quit();
    }

}