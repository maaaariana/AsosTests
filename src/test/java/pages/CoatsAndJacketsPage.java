package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CoatsAndJacketsPage extends BasePage {

    public CoatsAndJacketsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//li[@data-auto-id='sort']//button[@class='_1om7l06']")
    private WebElement sortDropdown;

    @FindBy(xpath = "//input[@id='plp_web_sort_price_low_to_high']")
    private WebElement priceLowToHightRadioButton;

    @FindBy(xpath = "//span[@class='qU9n4CQ']/span | //span[@data-auto-id='productTileSaleAmount']")
    private List<WebElement> productTitlePricesList;

    @FindBy(xpath = "//div[@data-auto-id='productList']//article[1]//button[@data-auto-id='saveForLater']")
    private WebElement saveFirstItemFromListForLaterButton;

    @FindBy(xpath = "//section[@data-auto-id=1]/article[1]/a")
    private WebElement firstItemInProductJacketList;

    @FindBy(xpath = "//select[@data-id ='sizeSelect']")
    private WebElement sizeSelect;

    @FindBy(xpath = "//div[@id='product-add']//a[@class = 'add-button']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//select[@data-id='sizeSelect']//option[2]")
    private WebElement firstAvailableSizeOfClothes;

    @FindBy(xpath = "//span[@id='selectSizeError']")
    private WebElement pleaseSelectSizeErrorMessageSpan;

    @FindBy(xpath = "//li[@data-dropdown-id='brand']//button")
    private WebElement brandDropdown;

    @FindBy(xpath = "//label[text()='ASOS Maternity']")
    private WebElement asosMaternityBrand;

    @FindBy(xpath = "//div[@data-auto-id='productTileDescription;']//p")
    private List<WebElement> searchBrandResultsProductsListText;

    @FindBy(xpath = "//button[@data-auto-id='clear']")
    private WebElement clearButtonInBrandDropdown;

    @FindBy(xpath = "//p[@data-auto-id='totalSelectedFacetValues']")
    private WebElement totalSelectedBrandValues;

    @FindBy(xpath = "//button[@data-auto-id='all']")
    private WebElement chooseAllBrandButton;

    public void clickSortDropdown() {
        sortDropdown.click();
    }

    public void clickPriceLowToHightRadioButton() {
        priceLowToHightRadioButton.click();
    }

    public List<WebElement> getProductTitlePricesList() {
        return productTitlePricesList;
    }

    public void clickSaveFirstItemFromListForLaterButton() {
        saveFirstItemFromListForLaterButton.click();
    }

    public WebElement getSaveFirstItemFromListForLaterButton() {
        return saveFirstItemFromListForLaterButton;
    }

    public void clickFirstItemInProductJacketList() {
        firstItemInProductJacketList.click();
    }

    public void clickSizeSelect() {
        sizeSelect.click();
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public void clickFirstAvailableSizeOfClothes() {
        firstAvailableSizeOfClothes.click();
    }

    public WebElement getFirstAvailableSizeOfClothes() {
        return firstAvailableSizeOfClothes;
    }

    public WebElement getPleaseSelectSizeErrorMessageSpan() {
        return pleaseSelectSizeErrorMessageSpan;
    }

    public void clickBrandDropdown() {
        brandDropdown.click();
    }

    public WebElement getBrandDropdown() {
        return brandDropdown;
    }

    public void clickAsosMaternityBrand() {
        asosMaternityBrand.click();
    }

    public WebElement getAsosMaternityBrand() {
        return asosMaternityBrand;
    }

    public List<WebElement> getBrandSearchResultsList() {
        return searchBrandResultsProductsListText;
    }

    public void clickClearButtonInBrandDropdown() {
        clearButtonInBrandDropdown.click();
    }

    public WebElement getClearButtonInBrandDropdown() {
        return clearButtonInBrandDropdown;
    }

    public WebElement getTotalSelectedBrandValues() {
        return totalSelectedBrandValues;
    }

    public WebElement getChooseAllBrandButton() {
        return chooseAllBrandButton;
    }
}
