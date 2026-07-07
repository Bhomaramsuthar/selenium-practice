package part3_4.com.demoqa.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import part3_4.com.demoqa.base.WebTablesPage;

public class WebTablesTest {
    WebDriver driver;
    WebTablesPage webTablesPage;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/webtables");
        webTablesPage = new WebTablesPage(driver);
    }

    @Test
    public void testUpdateEmployeeAge() throws InterruptedException{
        org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
        Thread.sleep(500);

        webTablesPage.searchFor("Alden");

        Thread.sleep(500);

        webTablesPage.clickEdit();

        String newAge = "50";
        webTablesPage.updateAge(newAge);

        webTablesPage.clickSubmit();

        Thread.sleep(500);

        // 5. Grab all the text from the entire table body and verify the new age is there
        String tableText = webTablesPage.getTableText();
        Assert.assertTrue(tableText.contains(newAge), "The age was not updated in the table!");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
