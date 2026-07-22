package part3_4.com.demoqa.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import part3_4.com.demoqa.base.ModalDialogsPage;

public class ModalDialogsTest {
    WebDriver driver;
    ModalDialogsPage modalPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/modal-dialogs");
        modalPage = new ModalDialogsPage(driver);
    }

    @Test
    public void testSmallModal() throws InterruptedException {

        // 1. Click the button to launch the popup
        modalPage.clickSmallModalButton();

        // 2. Grab the text from inside the popup
        String modalText = modalPage.getModalText();

        // 3. Verify it contains the expected text
        Assert.assertTrue(modalText.contains("This is a small modal"), "Modal text did not match!");
        System.out.println("Success: Successfully read the text from the modal!");

        // 4. Close the popup to return the page to normal
        modalPage.clickCloseModal();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}