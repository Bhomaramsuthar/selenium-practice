package part3_4.com.demoqa.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import part3_4.com.demoqa.base.LinkPage;

import java.io.IOException;
import java.util.Set;

public class LinksTest {

    WebDriver driver;
    LinkPage linkPage;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/links");
        linkPage = new LinkPage(driver);
    }
    @Test
    public void testNewTab() throws  InterruptedException{
        //org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,300)");

        Thread.sleep(500);

        String originalTab = driver.getWindowHandle();

        linkPage.clickHomeLink();

        Thread.sleep(500);

        Set<String> allTabs = driver.getWindowHandles();

        for(String tab: allTabs){
            if(!tab.equals(originalTab)){
                driver.switchTo().window(tab);
            }
        }

        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL,"https://demoqa.com/","The new tab did not match");
    }

    @AfterClass
    public void tearUp(){
        driver.quit();
    }


}
