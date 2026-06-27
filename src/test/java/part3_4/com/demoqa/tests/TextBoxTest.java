package part3_4.com.demoqa.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import part3_4.com.demoqa.base.TextBoxPage;

public class TextBoxTest  {
    WebDriver driver ;
    TextBoxPage textBoxPage;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");
        textBoxPage = new TextBoxPage(driver);
    }

    @Test
    public void testSubmitForm() throws IllegalArgumentException ,InterruptedException{
        textBoxPage.fillform("Bhoom","bhoom@gmail.com","pune","pune");

        org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");

        Thread.sleep(500);

        textBoxPage.clickSubmit();
        Thread.sleep(1000);

        String actualOutput = textBoxPage.getOutputText();

        Assert.assertTrue(actualOutput.contains("Name:Bhoom"),"Name was not displayed");
        Assert.assertTrue(actualOutput.contains("Email:bhoom@gmail.com"),"Email was not displayed");
    }

    @AfterClass
    public void tearUp(){
        driver.quit();
    }

}
