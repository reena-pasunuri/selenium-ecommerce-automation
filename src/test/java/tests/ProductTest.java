package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.SearchPage;

public class ProductTest extends BaseTest {
    @Test
    public void testAddProductToCart() {
        SearchPage searchPage = new SearchPage(driver);
        CartPage cartPage = new CartPage(driver);

        String productName = "Cucumber";  // ✅ Provide product name

        // 🔹 Step 1: Search for product
        searchPage.searchProduct(productName);

        // 🔹 Step 2: Add the first found product to the cart
        searchPage.addFirstProductToCart();

        // 🔹 Step 3: Open cart
        cartPage.openCart();

        // 🔹 Step 4: Verify product is in cart
        Assert.assertTrue(cartPage.getProductName().contains(productName), "Product not found in cart!");
    }
}
