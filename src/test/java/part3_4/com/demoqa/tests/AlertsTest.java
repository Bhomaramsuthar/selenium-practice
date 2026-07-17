package part3_4.com.demoqa.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import part3_4.com.demoqa.base.AlertsPage;

import java.time.Duration;

public class AlertsTest {

    WebDriver driver;
    AlertsPage alertsPage;
    WebDriverWait wait;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/alerts");
        alertsPage = new AlertsPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testAlerts() throws InterruptedException{
        //to avoid the add banner
        //org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,300)");
        //Thread.sleep(500);

        //normal alert with one button
        alertsPage.clickAlert();
        //wait.until(ExpectedConditions.alertIsPresent());
        Alert noramlAlert = driver.switchTo().alert();
        noramlAlert.accept();

        //Timer alert with one button
        alertsPage.clickTimerAlert();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert timerAlert = driver.switchTo().alert();
        timerAlert.accept();

        //alert with confirm and cancel button
        alertsPage.clickconfirmBox();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert confirmAlert = driver.switchTo().alert();
        confirmAlert.dismiss();
        String confirmResult = alertsPage.getConfirmResult();
        Assert.assertTrue(confirmResult.contains("Cancel"),"The alert is not cancelled");

        //alert with prompt box
        alertsPage.clickpromptBox();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys("Hello");
        promptAlert.accept();
        String promptResult = alertsPage.getpromptResult();
        Assert.assertTrue(promptResult.contains("Hello"),"The result doesn't contain the Hello");

    }

    @AfterClass
    public void TearUp(){
        driver.quit();
    }
}
