package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SavedItemsTests extends BaseTest {

    private static final String EXPECTED_ATTRIBUTE_VALUE = "active";
    private static final String SAVED_ITEM_COUNT = "1 item";
    private static final String NO_SAVED_ITEM_TITLE = "You have no Saved Items";
    private static final String EXPECTED_AMOUNT_OF_PRODUCTS = "1";

    @Test
    public void checkAddItemToSavedItems() {

        getHomePage().clickShopWomanButton();
        getBasePage().waitPageReadyState(30);
        getWomanPage().clickClothesMenuItem();
        getWomanPage().clickCoatsAndJacketMenuItem();

        getBasePage().waitPageReadyState(30);
        getCoatsAndJacketsPage().clickSaveFirstItemFromListForLaterButton();
        Assert.assertTrue(getCoatsAndJacketsPage().getSaveFirstItemFromListForLaterButton().getAttribute("data-auto-state").contains(EXPECTED_ATTRIBUTE_VALUE));

        getBasePage().implicitWait(30);
        getHomePage().clickSavedItemsHeaderIcon();
        getBasePage().waitPageReadyState(30);

        Assert.assertTrue(getSavedListPage().getItemCountInSavedItems().getText().contains(SAVED_ITEM_COUNT));
    }

    @Test
    public void checkDeleteItemFromSavedList() {
        checkAddItemToSavedItems();
        getBasePage().waitPageReadyState(30);

        getSavedListPage().clickDeleteItemFromSavedList();
        Assert.assertTrue(getSavedListPage().getNoSavedItemTitle().getText().contains(NO_SAVED_ITEM_TITLE));
    }

    @Test
    public void checkMoveToBagSavedItem() {

        checkAddItemToSavedItems();
        getBasePage().waitPageReadyState(30);

        getBasePage().scrollDownThePageByNPixels("3000");
        getSavedListPage().clickSizeSelect();
        getBasePage().waitForElementVisibility(30, getSavedListPage().getFirstAvailableSizeOfClothes());
        getSavedListPage().clickFirstAvailableSizeOfClothes();

        getSavedListPage().clickMoveToBagButton();
        getBasePage().waitForElementVisibility(30, getSavedListPage().getNoSavedItemTitle());
        Assert.assertTrue(getSavedListPage().getNoSavedItemTitle().getText().contains(NO_SAVED_ITEM_TITLE));
        Assert.assertEquals(getHomePage().getAmountOfProductsInBagOnHeader(), EXPECTED_AMOUNT_OF_PRODUCTS);
    }
}
