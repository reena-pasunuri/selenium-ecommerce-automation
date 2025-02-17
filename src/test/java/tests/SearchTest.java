package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchPage;

public class SearchTest extends BaseTest {
    @Test
    public void testSearchProduct() {
        SearchPage searchPage = new SearchPage(driver);
        String productName = "Cucumber";

        // 🔹 Step 1: Search for product
        searchPage.searchProduct(productName);

        // 🔹 Step 2: Verify product is displayed
        Assert.assertTrue(searchPage.isProductDisplayed(productName), "Product not found!");

        // 🔹 Step 3: Verify at least 1 search result appears
        Assert.assertTrue(searchPage.getSearchResultsCount() > 0, "No products found!");
    }
}
