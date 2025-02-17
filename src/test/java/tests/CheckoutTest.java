package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.CheckoutPage;

public class CheckoutTest extends BaseTest {
    @Test
    public void testPlaceOrder() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        // 🔹 Proceed with placing the order
        checkoutPage.placeOrder();
    }
}
