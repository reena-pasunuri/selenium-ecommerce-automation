package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By promoCodeInput = By.xpath("//input[@placeholder='Enter promo code']");
    private By applyButton = By.xpath("//button[contains(text(),'Apply')]");
    private By placeOrderButton = By.xpath("//button[contains(text(),'Place Order')]");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterPromoCode(String promoCode) {
        driver.findElement(promoCodeInput).sendKeys(promoCode);
        driver.findElement(applyButton).click();
    }

    public void placeOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton)).click();
    }
}
