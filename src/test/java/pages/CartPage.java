package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserFactory;

public class CartPage {
    //cart page title assert
    @FindBy(xpath = "//following::li[@itemprop='name']")   //[1]
    public WebElement cartPageTitle;

    //discount code button
    @FindBy(xpath = "//span[@class='cart-ingka-accordion-item-header__title']")
    public WebElement discountCodeButton;



    //discount code field
    @FindBy(xpath = "//input[@id='discountCode']")
    public WebElement discountCodeField;

    //apply discount button
    @FindBy(xpath = "//button[@class='cart-ingka-btn cart-ingka-btn--secondary']")
    public WebElement applyDiscountCodeButton;

    //discount error message
    @FindBy(xpath = "//span[@class='cart-ingka-form-field__message']")
    public WebElement discountErrorMessage;

    public CartPage() {
        PageFactory.initElements(BrowserFactory.getDriver(), this);
    }

    public static WebElement getCartPageTitleAssert(String indexing) {
        return BrowserFactory.getDriver().findElement(By.xpath("//following::li[@itemprop='name'][" + indexing + "]"));
    }
}
