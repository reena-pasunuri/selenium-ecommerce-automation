package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    WebDriver driver;

    By searchBox = By.xpath("//input[@type='search']");
    By productList = By.xpath("//h4[@class='product-name']");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchProduct(String productName) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(productName);
    }

    public boolean isProductDisplayed() {
        return driver.findElements(productList).size() > 0;
    }
}
