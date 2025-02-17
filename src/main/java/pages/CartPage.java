package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CartPage {
    WebDriver driver;
    WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // ✅ Fixed missing WebDriverWait
    }

    // Open the cart
    public void openCart() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt='Cart']"))).click();
    }

    // Proceed to checkout
    public void proceedToCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]"))).click();
    }

    // Get product name in cart
    public String getProductName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector("div.cart-preview.active li.cart-item p.product-name")
        )).getText();
    }
}
