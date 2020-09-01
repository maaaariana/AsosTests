package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@data-testid='women-floor']")
    private WebElement shopWomanButton;

    @FindBy(xpath = "//a[@data-testid='savedItemsIcon']")
    private WebElement savedItemsHeaderIcon;

    @FindBy(xpath = "//div[@class='_2jtZkvR']//button[@data-testid='country-selector-btn']")
    private WebElement chooseCountryButtonFromHeader;

    @FindBy(xpath = "//select[@id='country']")
    private WebElement shopInSelectInPopUp;

    @FindBy(xpath = "//option[@value='CA']")
    private WebElement choosenCountryOptionInPopUp;

    @FindBy(xpath = "//button[@data-testid='save-country-button']")
    private WebElement updateReferencesButtonInPopUp;

    @FindBy(xpath = "//div[@id='miniBagDropdown']//span[@class='_1z5n7CN']")
    private WebElement bagIconOnHeader;

    @FindBy(xpath = "//button[@aria-label='Delete this item']")
    private WebElement deleteItemFromBag;

    @FindBy(xpath = "//div[@id='minibag-dropdown']//div[@class='PGkhm53']")
    private WebElement itemDeletedDiv;

    @FindBy(xpath = "//button[@data-testid='accountIcon']")
    private WebElement accountIconOnHeader;

    public void clickShopWomanButton() {
        shopWomanButton.click();
    }

    public void clickSavedItemsHeaderIcon() {
        savedItemsHeaderIcon.click();
    }

    public void clickChooseCountryButtonFromHeader() {
        chooseCountryButtonFromHeader.click();
    }

    public WebElement getChooseCountryButtonFromHeader() {
        return chooseCountryButtonFromHeader;
    }

    public void clickShopInSelectInPopUp() {
        shopInSelectInPopUp.click();
    }

    public WebElement getShopInSelectInPopUp() {
        return shopInSelectInPopUp;
    }

    public void clickChoosenCountryOptionInPopUp() {
        choosenCountryOptionInPopUp.click();
    }

    public WebElement getChoosenCountryOptionInPopUp() {
        return choosenCountryOptionInPopUp;
    }

    public void clickUpdateReferencesButtonInPopUp() {
        updateReferencesButtonInPopUp.click();
    }

    public WebElement getUpdateReferencesButtonInPopUp() {
        return updateReferencesButtonInPopUp;
    }

    public String getAmountOfProductsInBagOnHeader() {
        return bagIconOnHeader.getText();
    }

    public void moveToBagIconOnHeader() {
        action.moveToElement(bagIconOnHeader);
    }

    public WebElement getDeleteItemFromBag() {
        return deleteItemFromBag;
    }

    public void clickDeleteItemFromBag() {
        deleteItemFromBag.click();
    }

    public WebElement getItemDeletedDiv() {
        return itemDeletedDiv;
    }
}
