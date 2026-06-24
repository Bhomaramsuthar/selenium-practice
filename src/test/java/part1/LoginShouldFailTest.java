package part1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginShouldFailTest {

    WebDriver driver ;

    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
    }
    @AfterClass
    public void tearUp(){

    }
    @Test
    public void testLoggingIntoApplication() throws InterruptedException{
        Thread.sleep(2000);
        WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        username.sendKeys("Admin");
        var password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("admin123");
        driver.findElement(By.tagName("button")).click();
        Thread.sleep(2000);

        //String actualResult = driver.findElement(By.tagName("h6")).getText();
        //String expectedResult = "Dashboard";
        //Assert.assertNotEquals(actualResult,expectedResult);

        WebElement errorMessage= driver.findElement(By.className("oxd-alert-content-text"));
        String actualErrorText = errorMessage.getText();
        String expectedErrortext = "Invalid credentials";

        Assert.assertEquals(actualErrorText,expectedErrortext);
    }
}
