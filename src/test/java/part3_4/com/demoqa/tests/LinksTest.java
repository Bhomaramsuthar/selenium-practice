package part3_4.com.demoqa.tests;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
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

        String originalTab = driver.getWindowHandle();
        linkPage.clickHomeLink();

        for(String tab: driver.getWindowHandles()){
            if(!tab.equals(originalTab)){
                driver.switchTo().window(tab);
            }
        }

        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/","The new tab did not match");
        //close the tab
        driver.close();
        //switch back
        driver.switchTo().window(originalTab);
    }

    @Test
    public void testDynamiclinkOpenNewTab(){
        String originalTab = driver.getWindowHandle();
        linkPage.clickDynamicLink();
        for(String tab:driver.getWindowHandles()){
            if(!tab.equals(originalTab)){
                driver.switchTo().window(tab);
            }
        }
        // Close new tab
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/");
        driver.close();

        // Return
        driver.switchTo().window(originalTab);
    }

    @Test
    public void testCreatedLinkResponse(){
        linkPage.clickCreatedLink();
        String response = linkPage.getLinkResponse();
        Assert.assertTrue(response.contains("201"),"Expected 201 created response");
    }

    @BeforeMethod
    public void openPage() {
        driver.get("https://demoqa.com/links");
    }

    @Test
    public void testNotFoundLinkresponse() throws TimeoutException, InterruptedException {
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        linkPage.clickNotFoundLink();

        //Thread.sleep(500);
        System.out.println(linkPage.getLinkResponse());

        String response = linkPage.getLinkResponse();
        System.out.println("Response"+response);
        Assert.assertTrue(response.contains("404"),"Expected 404 not found response");
    }

    @AfterClass
    public void tearUp(){
        driver.quit();
    }


}
