package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserFactory;

import java.util.List;

public class SearchPage {
    //shopping bag
    @FindBy(xpath = "//button[@class='hnf-btn hnf-btn--small hnf-btn--plain hnf-toast__action-message']")
    public WebElement shoppingBag;

    //title to assert
    @FindBy(xpath = "//following::span[@class='header-section__title notranslate']")  //[3]
    public WebElement cartTitleAssert;


    @FindBy(id = "clear-input")
    public WebElement newSearchFieldClear;

    @FindBy(xpath = "//input[@class='search-field__input search-field__input--has-input']")
    public WebElement newSearchField;

    @FindBy(xpath = "//input[@class='search-field__input search-field__input--has-input focus-visible']")
    public WebElement newSearchField2;






//    //add to cart button
//    @FindBy(xpath = "//button[@class='search-btn button__add-to-cart product-fragment__action-button'][1]") //[3]
//    public WebElement addToCartButton;

    //add to cart button
    @FindBy(xpath = "//button[@class='pip-btn pip-btn--emphasised']")
    public WebElement addToCartButton;


    public SearchPage() {
        PageFactory.initElements(BrowserFactory.getDriver(), this);
    }

    public static WebElement addToCartIndexing(String indexing) {
        return BrowserFactory.getDriver().findElement(By.xpath("//following::button[@class='search-btn button__add-to-cart product-fragment__action-button'][" + indexing + "]"));
    }

    public static WebElement getTheTitleIndexing(String indexing) {
        return BrowserFactory.getDriver().findElement(By.xpath("//following::span[@class='header-section__title notranslate'][" + indexing + "]"));
    }
}
