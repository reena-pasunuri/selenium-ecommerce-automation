package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.SearchPage;

public class SearchTest extends BaseTest {

    @Test
    public void testSearchProduct() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.searchProduct("Cucumber");

        Assert.assertTrue(searchPage.isProductDisplayed(), "Product should be displayed.");
    }
}
