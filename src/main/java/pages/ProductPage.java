package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductPage {
    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    private By searchBox = By.cssSelector("input.search-keyword");
    private By productName = By.cssSelector("h4.product-name");
    private By addToCartButton = By.xpath("//button[text()='ADD TO CART']");

    // Search for a product
    public void searchProduct(String productName) {
        WebElement searchBoxElement = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        searchBoxElement.clear();
        searchBoxElement.sendKeys(productName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.productName)); // Wait for results to appear
    }

    // Click Add to Cart
    public void addProductToCart() {
        WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCart.click();
    }
}
