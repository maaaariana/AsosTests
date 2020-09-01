package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeCountryTest extends BaseTest {

    private static final String ATTRIBUTE_VALUE_SHOPPING_FROM = "Shopping from: Canada. Choose Country";

    @Test
    public void checkChangeCountryForShopping() {
        if (!getHomePage().getChooseCountryButtonFromHeader().getAttribute("aria-label").contains(ATTRIBUTE_VALUE_SHOPPING_FROM)) {
            getHomePage().clickChooseCountryButtonFromHeader();
            getBasePage().waitForElementVisibility(30, getHomePage().getShopInSelectInPopUp());
            getHomePage().clickShopInSelectInPopUp();
            getBasePage().waitForElementVisibility(30, getHomePage().getChoosenCountryOptionInPopUp());
            getHomePage().clickChoosenCountryOptionInPopUp();
            getBasePage().waitForElementVisibility(30, getHomePage().getUpdateReferencesButtonInPopUp());
            getHomePage().clickUpdateReferencesButtonInPopUp();
        }
        getHomePage().implicitWait(30);
        Assert.assertTrue(getHomePage().getChooseCountryButtonFromHeader().getAttribute("aria-label").contains(ATTRIBUTE_VALUE_SHOPPING_FROM));
    }
}
