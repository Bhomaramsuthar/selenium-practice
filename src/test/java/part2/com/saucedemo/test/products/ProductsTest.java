package part2.com.saucedemo.test.products;

import org.testng.Assert;
import org.testng.annotations.Test;
import part2.com.saucedemo.base.BaseTest;
import part2.com.saucedemo.base.ProductsPage;

public class ProductsTest extends BaseTest {
    @Test
    public void testProductsHeaderIsDisplayed(){
        ProductsPage productsPage =loginpage.logIntoApplication("standard_user","secret_sauce");
        Assert.assertFalse(productsPage.isProductsHeaderDisplayed(),
                "\n Products Header Is Not Displayed \n");
    }

}
