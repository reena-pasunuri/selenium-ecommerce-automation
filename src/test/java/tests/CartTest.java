package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.SearchPage;

public class CartTest extends BaseTest {
    @Test
    public void testAddProductToCart() {
        SearchPage searchPage = new SearchPage(driver);
        CartPage cartPage = new CartPage(driver);

        String productName = "Cucumber"; // ✅ Fixed variable usage

        // 🔹 Step 1: Search for the product
        searchPage.searchProduct(productName);

        // 🔹 Step 2: Add the first product to the cart
        searchPage.addFirstProductToCart();

        // 🔹 Step 3: Open the cart
        cartPage.openCart();

        // 🔹 Step 4: Verify the correct product is in the cart
        String cartProductName = cartPage.getProductName();
        Assert.assertTrue(cartProductName.contains(productName), "Product not found in cart!");

        // 🔹 Step 5: Proceed to checkout
        cartPage.proceedToCheckout();
    }
}
