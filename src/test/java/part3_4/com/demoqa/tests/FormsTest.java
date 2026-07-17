package part3_4.com.demoqa.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import part3_4.com.demoqa.base.FormsPage;

public class FormsTest {
    private WebDriver driver;
    private FormsPage formsPage;

    @BeforeClass
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "C:\\path\\to\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
        formsPage = new FormsPage(driver);


    }

    @Test
    public void testFormSubmission() {
        formsPage.enterName("John", "Doe");
        formsPage.enterEmail("john.doe@example.com");
        formsPage.selectGenderMale();
        formsPage.enterMobile("9876543210");
        formsPage.selectDOB("May", "1995", "10");
        formsPage.enterSubject("Maths");
        formsPage.selectHobbySports();
        String filePath = "S:\\IntelliJ\\selenium\\src\\test\\java\\part3_4\\com\\demoqa\\tests\\resources\\test.jpg";
        formsPage.uploadFile(filePath);
        formsPage.enterAddress("123 Demo Street, Pune");
        formsPage.selectStateAndCity("NCR", "Delhi");

        formsPage.submitForm();

        Assert.assertEquals(formsPage.getConfirmationValue("Subjects"), "Maths");
        Assert.assertEquals(formsPage.getConfirmationValue("State and City"), "NCR Delhi");
        Assert.assertEquals(formsPage.getConfirmationValue("Address"), "123 Demo Street, Pune");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}