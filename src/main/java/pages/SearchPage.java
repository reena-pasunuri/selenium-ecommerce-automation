package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class SearchPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    private By searchBox = By.cssSelector("input.search-keyword"); // Search box
    private By productResults = By.cssSelector("div.product h4.product-name"); // Product name
    private By addToCartButtons = By.xpath("//div[@class='product']//button[text()='ADD TO CART']"); // Add to Cart button
    private By productContainer = By.cssSelector("div.products"); // Ensure product section loads

    // 🔹 Search for a product
    public void searchProduct(String productName) {
        WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(searchBox));
        searchField.clear();
        searchField.sendKeys(productName);
        waitForResults();
    }

    // 🔹 Verify if search results contain the expected product
    public boolean isProductDisplayed(String productName) {
        List<WebElement> results = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productResults));
        for (WebElement result : results) {
            if (result.getText().toLowerCase().contains(productName.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    // 🔹 Add the first found product to the cart
    public void addFirstProductToCart() {
        List<WebElement> buttons = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(addToCartButtons));
        if (!buttons.isEmpty()) {
            buttons.get(0).click();
        } else {
            throw new RuntimeException("No 'ADD TO CART' buttons found.");
        }
    }

    // 🔹 Get total number of search results
    public int getSearchResultsCount() {
        List<WebElement> results = driver.findElements(productResults);
        return results.size();
    }

    // 🔹 Wait for search results to appear
    private void waitForResults() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productContainer));
    }
}
