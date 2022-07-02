package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserFactory;

public class HomePage {
    @FindBy(xpath = "//input[@class='search-field__input']")
    public WebElement searchField;

    @FindBy(xpath = "//button[@id='search-box__searchbutton']")
    public WebElement searchButton;


    public HomePage() {
        PageFactory.initElements(BrowserFactory.getDriver(), this);
    }
}


