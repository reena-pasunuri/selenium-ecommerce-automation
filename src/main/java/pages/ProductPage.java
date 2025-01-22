package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
    WebDriver driver;

    By productSearchBox = By.xpath("//input[@type='search']");
    By addToCartButton = By.xpath("//button[contains(text(),'ADD TO CART')]");
    By productName = By.xpath("//h4[@class='product-name']");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchProduct(String productName) {
        try {
            WebElement searchBox = driver.findElement(productSearchBox);
            searchBox.clear();
            searchBox.sendKeys(productName);
        } catch (Exception e) {
            System.out.println("Error searching product: " + e.getMessage());
        }
    }

    public void addProductToCart() {
        try {
            driver.findElement(addToCartButton).click();
        } catch (Exception e) {
            System.out.println("Error adding product to cart: " + e.getMessage());
        }
    }

    public String getProductName() {
        try {
            return driver.findElement(productName).getText();
        } catch (Exception e) {
            System.out.println("Error getting product name: " + e.getMessage());
            return null;
        }
    }

    public void goToCartAndCheckout() {
        throw new UnsupportedOperationException("Unimplemented method 'goToCartAndCheckout'");
    }
}
