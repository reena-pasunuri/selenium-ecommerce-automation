package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutPage;
import pages.ProductPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void testCheckout() {
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        productPage.searchProduct("Cucumber");
        productPage.addProductToCart();
        cartPage.openCart();
        cartPage.proceedToCheckout();
        checkoutPage.placeOrder();

        Assert.assertTrue(checkoutPage.isOrderSuccessful(), "Order should be placed successfully.");
    }
}
