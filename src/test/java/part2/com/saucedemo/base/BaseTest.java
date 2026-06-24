package part2.com.saucedemo.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BaseTest {
    protected WebDriver driver;
    protected BasePage basepage;
    protected LoginPage loginpage;
    private String url = "https://www.saucedemo.com";

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        basepage = new BasePage();
        basepage.setDriver(driver);
        loginpage = new LoginPage(driver);

    }
    @AfterClass
    public void tearUp(){
        driver.quit();
    }

}
