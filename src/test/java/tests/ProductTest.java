package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.ProductPage;
import pages.CheckoutPage;

public class ProductTest extends BaseTest {

    @Test
    public void testAddProductAndCheckout() {
        ProductPage productPage = new ProductPage(driver);
        productPage.searchProduct("Cucumber");
        productPage.addProductToCart();
        productPage.goToCartAndCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterPromoCode("RAHULSHETTYACADEMY");
        checkoutPage.placeOrder();
    }
}
