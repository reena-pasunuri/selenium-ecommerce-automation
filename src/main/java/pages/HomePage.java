package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    private By searchBox = By.xpath("//input[@type='search']");
    private By cartIcon = By.cssSelector("img[alt='Cart']");
    private By homePageLogo = By.xpath("//div[@class='brand greenLogo']");

    // Open the GreenKart homepage
    public void openHomePage() {
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageLogo));
    }

    // Verify if homepage is loaded
    public boolean isHomePageLoaded() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(homePageLogo)).isDisplayed();
    }

    // Go to Cart Page
    public void goToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
    }
}
