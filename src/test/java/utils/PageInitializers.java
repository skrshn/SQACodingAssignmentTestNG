package utils;

import pages.CartPage;
import pages.HomePage;
import pages.SearchPage;

public class PageInitializers {
    public static HomePage homePage;
    public static CartPage cartPage;
    public static SearchPage searchPage;

    public static void initializePageObjects() {
        homePage = new HomePage();
        cartPage = new CartPage();
        searchPage = new SearchPage();
    }
}
