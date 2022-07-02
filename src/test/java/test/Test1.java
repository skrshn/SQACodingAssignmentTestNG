package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.SearchPage;
import testBase.TestBase;
import utils.CommonMethods;
import utils.ConfigReader;

public class Test1 extends TestBase {
    @Test
    public static void test1() {
        CommonMethods.sendText(homePage.searchField, ConfigReader.getPropertyValue("searchProduct1"));
        CommonMethods.click(homePage.searchButton);
        CommonMethods.jsScrollDown();
        String productTitle1 = SearchPage.getTheTitleIndexing(ConfigReader.getPropertyValue("productIndex1")).getText();
        CommonMethods.click(SearchPage.addToCartIndexing(ConfigReader.getPropertyValue("productIndex1")));

        CommonMethods.jsScrollUp();
        CommonMethods.click(searchPage.newSearchFieldClear);
        CommonMethods.sendText(homePage.searchField, ConfigReader.getPropertyValue("searchProduct2"));
        CommonMethods.click(homePage.searchButton);

        CommonMethods.jsScrollDown();
        String productTitle2 = SearchPage.getTheTitleIndexing(ConfigReader.getPropertyValue("productIndex2")).getText();
        CommonMethods.click(SearchPage.addToCartIndexing(ConfigReader.getPropertyValue("productIndex2")));

        CommonMethods.jsScrollUp();
        CommonMethods.click(searchPage.shoppingBag);
        Assert.assertEquals(CommonMethods.getText(CartPage.getCartPageTitleAssert("1")), productTitle1);
        Assert.assertEquals(CommonMethods.getText(CartPage.getCartPageTitleAssert("2")), productTitle2);

        CommonMethods.jsScrollDown();
        CommonMethods.click(cartPage.discountCodeButton);

        CommonMethods.sendText(cartPage.discountCodeField, "123123123123123");
        //String.valueOf(CommonMethods.getRandomLongNumber())

        CommonMethods.click(cartPage.applyDiscountCodeButton);
        CommonMethods.highlightText(cartPage.discountErrorMessage);
        Assert.assertEquals(CommonMethods.getText(cartPage.discountErrorMessage), ConfigReader.getPropertyValue("errorMessage"));
        System.out.println("SELENIUM TEST DONE!!!");
    }
}
