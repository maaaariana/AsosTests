package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BagTests extends BaseTest {

    private static final String EXPECTED_RESULT_AFTER_ITEM_DELETING = "Item deleted";
    private static final String EXPECTED_AMOUNT_OF_PRODUCTS = "1";
    private static final String EXPECTED_SELECT_SIZE_ERROR_MESSAGE = "Please select from the available colour and size options";

    @Test
    public void checkAddToBag() {

        getHomePage().clickShopWomanButton();
        getBasePage().waitPageReadyState(30);
        getWomanPage().clickClothesMenuItem();
        getWomanPage().clickCoatsAndJacketMenuItem();

        getBasePage().waitPageReadyState(30);
        getBasePage().scrollDownThePageByNPixels("250");
        getCoatsAndJacketsPage().clickFirstItemInProductJacketList();

        getBasePage().waitPageReadyState(30);
        getCoatsAndJacketsPage().clickSizeSelect();

        getBasePage().waitForElementVisibility(30, getCoatsAndJacketsPage().getFirstAvailableSizeOfClothes());
        getCoatsAndJacketsPage().clickFirstAvailableSizeOfClothes();

        getCoatsAndJacketsPage().clickAddToCartButton();

        getBasePage().implicitWait(30);
        Assert.assertEquals(getHomePage().getAmountOfProductsInBagOnHeader(), EXPECTED_AMOUNT_OF_PRODUCTS);
    }

    @Test
    public void checkAddToBagNegativeTest() {

        getHomePage().clickShopWomanButton();
        getBasePage().waitPageReadyState(30);
        getWomanPage().clickClothesMenuItem();
        getWomanPage().clickCoatsAndJacketMenuItem();

        //getBasePage().waitPageReadyState(30);
        getBasePage().implicitWait(30);
        getBasePage().scrollDownThePageByNPixels("250");
        getCoatsAndJacketsPage().clickFirstItemInProductJacketList();
        getBasePage().waitPageReadyState(30);

        getCoatsAndJacketsPage().clickAddToCartButton();
        getBasePage().waitForElementVisibility(30, getCoatsAndJacketsPage().getPleaseSelectSizeErrorMessageSpan());
        Assert.assertEquals(getCoatsAndJacketsPage().getPleaseSelectSizeErrorMessageSpan().getText(), EXPECTED_SELECT_SIZE_ERROR_MESSAGE);
    }

    @Test
    public void checkDeleteOfProductFromBag() {

        checkAddToBag();
        getHomePage().moveToBagIconOnHeader();
        getBasePage().waitForElementVisibility(10, getHomePage().getDeleteItemFromBag());
        getHomePage().clickDeleteItemFromBag();
        getBasePage().waitForElementVisibility(5, getHomePage().getItemDeletedDiv());
        Assert.assertEquals(getHomePage().getItemDeletedDiv().getText(), EXPECTED_RESULT_AFTER_ITEM_DELETING);
    }
}
