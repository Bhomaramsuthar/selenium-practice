package part3_4.com.demoqa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import part3_4.com.demoqa.tests.RadioButtonPage;

public class RadioButtonTest {

    WebDriver driver;
    RadioButtonPage radioButtonPage;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/radio-button");
        radioButtonPage = new RadioButtonPage(driver);
    }

    @Test
    public void testRadioButton(){
        // -------- Test 1 : YES button
        radioButtonPage.clickYes();
        String yesResult = radioButtonPage.getResultTest();
        Assert.assertEquals(yesResult,"Yes","The Yes button did not work correctly!");

        // -------- Test 2 : IMPRESSIVE button
        radioButtonPage.clickImpressive();
        String impressiveResult = radioButtonPage.getResultTest();
        Assert.assertEquals(impressiveResult,"Impressive","The Impressive button didnt work correctly!");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
