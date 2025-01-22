package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    By searchBox = By.xpath("//input[@type='search']");
    By searchButton = By.xpath("//button[@type='submit']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchProduct(String productName) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(productName);
        driver.findElement(searchButton).click();
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
