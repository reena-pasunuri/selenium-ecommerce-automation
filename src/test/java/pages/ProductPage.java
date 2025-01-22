package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By searchBox = By.xpath("//input[@type='search']");
    private By productNames = By.cssSelector("h4.product-name");
    private By addToCartButtons = By.xpath("//button[contains(text(),'ADD TO CART')]");
    private By cartIcon = By.xpath("//img[@alt='Cart']");
    private By proceedToCheckout = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void searchForProduct(String productName) {
        driver.findElement(searchBox).sendKeys(productName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(productNames));
    }

    public void addFirstProductToCart() {
        List<WebElement> products = driver.findElements(productNames);
        if (!products.isEmpty()) {
            List<WebElement> buttons = driver.findElements(addToCartButtons);
            buttons.get(0).click();  // Clicking "Add to Cart" for first product
        }
    }

    public void goToCartAndCheckout() {
        driver.findElement(cartIcon).click();
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckout)).click();
    }
}
