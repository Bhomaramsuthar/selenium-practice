package part2.com.saucedemo.test.login;

import org.testng.Assert;
import org.testng.annotations.Test;
import part2.com.saucedemo.base.BaseTest;
import part2.com.saucedemo.base.LoginPage;

import java.io.StringBufferInputStream;

public class LoginTest extends BaseTest {
    @Test
    public void testLoginErrorMessage(){
        loginpage.enterUsername("standard_user");
        loginpage.enterPassword("secret_sauce");
        loginpage.clickLoginButton();

        String currentURl = driver.getCurrentUrl();
        Assert.assertTrue(currentURl.contains("inventory.html"),"Login failed!");
        //String actualMessage = loginpage.getErrorMessage();
        //Assert.assertTrue(actualMessage.contains("Epic sadface"));
    }
}
