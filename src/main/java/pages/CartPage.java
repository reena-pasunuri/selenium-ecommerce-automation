package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CartPage {
    WebDriver driver;

    By cartIcon = By.xpath("//img[@alt='Cart']");
    By cartItems = By.xpath("//div[@class='cart-preview']//ul//li");
    By checkoutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
    
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openCart() {
        try {
            driver.findElement(cartIcon).click();
        } catch (Exception e) {
            System.out.println("Error opening cart: " + e.getMessage());
        }
    }

    public boolean isCartEmpty() {
        try {
            List<WebElement> items = driver.findElements(cartItems);
            return items.isEmpty();
        } catch (Exception e) {
            System.out.println("Error checking cart: " + e.getMessage());
            return false;
        }
    }

    public void proceedToCheckout() {
        try {
            driver.findElement(checkoutButton).click();
        } catch (Exception e) {
            System.out.println("Error proceeding to checkout: " + e.getMessage());
        }
    }
}
