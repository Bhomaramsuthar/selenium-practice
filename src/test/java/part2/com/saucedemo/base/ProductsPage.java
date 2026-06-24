package part2.com.saucedemo.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    // 1. Locator for the "Products" title on the next page
    private By productsHeader = By.className("title");

    // 2. Constructor
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    // 3. Action Method (Checks if the header is visible)
    public boolean isProductsHeaderDisplayed() {
        return driver.findElement(productsHeader).isDisplayed();
    }
}