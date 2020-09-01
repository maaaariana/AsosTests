package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class SavedListPage extends BasePage {

    public SavedListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='itemCount_1ZeG5']")
    private WebElement itemCountInSavedItems;

    @FindBy(xpath = "//button[@class='deleteButton_Za13- deleteButton_2VxuB']")
    private WebElement deleteItemFromSavedList;

    @FindBy(xpath = "//h2[@class='noSavedItemsPrompt_1vznK']")
    private WebElement noSavedItemTitle;

    @FindBy(xpath = "//button[@class='toBagButton_OatoQ toBagButton_3wcKB']")
    private WebElement moveToBagButton;

    @FindBy(xpath = "//div[@class='productTile_3HEk2']//select[@aria-label='Size']")
    private WebElement sizeSelect;

    @FindBy(xpath = "//div[@class='productTile_3HEk2']//select[@aria-label='Size']/option[2]")
    private WebElement firstAvailableSizeOfClothes;

    public WebElement getItemCountInSavedItems() {
        return itemCountInSavedItems;
    }

    public void clickDeleteItemFromSavedList() { deleteItemFromSavedList.click(); }

    public WebElement getNoSavedItemTitle() {
        return noSavedItemTitle;
    }

    public void clickSizeSelect() {
        sizeSelect.click();
    }

    public void clickFirstAvailableSizeOfClothes() {
        firstAvailableSizeOfClothes.click();
    }

    public WebElement getFirstAvailableSizeOfClothes() {
        return firstAvailableSizeOfClothes;
    }

    public void clickMoveToBagButton() {
        moveToBagButton.click();
    }
}
