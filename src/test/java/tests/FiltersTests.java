package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FiltersTests extends BaseTest {

    private static final String PIXELS_FOR_SCROLLING_DOWN_TO_BOTTOM_OF_PAGE = "8000";
    private static final String ASOS_DESIGN_Maternity_BRAND = "ASOS DESIGN Maternity";
    private static final String EXPECTED_ZERO_OF_SELECTED_BRAND = "0 selected";

    @Test
    public void checkSortByPriceAscending() {

        getHomePage().clickShopWomanButton();
        getBasePage().waitPageReadyState(30);
        getWomanPage().clickClothesMenuItem();
        getWomanPage().clickCoatsAndJacketMenuItem();

        getBasePage().waitPageReadyState(30);
        getBasePage().scrollDownThePageByNPixels("450");
        getCoatsAndJacketsPage().clickSortDropdown();
        getCoatsAndJacketsPage().clickPriceLowToHightRadioButton();

        getBasePage().implicitWait(30);
        getBasePage().waitPageReadyState(30);
        getBasePage().scrollDownThePageByNPixels("400");
        getBasePage().waitForElementVisibility(30, getCoatsAndJacketsPage().getProductTitlePricesList().get(1));
        getBasePage().scrollDownThePageByNPixels(PIXELS_FOR_SCROLLING_DOWN_TO_BOTTOM_OF_PAGE);
        Double prices = 0.0;
        boolean SortByPriceAscending = true;
        for (WebElement elements : getCoatsAndJacketsPage().getProductTitlePricesList()) {
            if (Double.parseDouble(elements.getText().substring(1, 5).trim()) >= prices) {
                SortByPriceAscending = true;
                prices = Double.parseDouble(elements.getText().substring(1, 5).trim());
            } else {
                SortByPriceAscending = false;
                break;
            }
        }
        assertEquals(SortByPriceAscending, true);
    }

    @Test
    public void checkBrandFilter() {
        getHomePage().clickShopWomanButton();
        getBasePage().waitPageReadyState(30);
        getWomanPage().clickClothesMenuItem();
        getWomanPage().clickCoatsAndJacketMenuItem();
        getBasePage().waitPageReadyState(30);
        getBasePage().scrollDownThePageByNPixels("300");


        getCoatsAndJacketsPage().clickBrandDropdown();
        getBasePage().waitForElementVisibility(30, getCoatsAndJacketsPage().getAsosMaternityBrand());
        getCoatsAndJacketsPage().clickAsosMaternityBrand();
        getBasePage().waitForElementVisibility(30, getCoatsAndJacketsPage().getAsosMaternityBrand());
        getCoatsAndJacketsPage().clickBrandDropdown();

        getBasePage().waitPageReadyState(30);
        getBasePage().scrollDownThePageByNPixels("4000");

        for (WebElement webElement : getCoatsAndJacketsPage().getBrandSearchResultsList()) {
            assertTrue(webElement.getText().contains(ASOS_DESIGN_Maternity_BRAND));
        }
    }

    @Test
    public void checkClearBrandFilter() {
        checkBrandFilter();
        getBasePage().scrollDownThePageByNPixels("-4000");
        getBasePage().waitForElementVisibility(30, getCoatsAndJacketsPage().getBrandDropdown());
        getCoatsAndJacketsPage().clickBrandDropdown();
        getBasePage().waitForElementVisibility(30, getCoatsAndJacketsPage().getClearButtonInBrandDropdown());
        getCoatsAndJacketsPage().clickClearButtonInBrandDropdown();

        getBasePage().waitForElementVisibility(30, getCoatsAndJacketsPage().getChooseAllBrandButton());
        Assert.assertEquals(getCoatsAndJacketsPage().getTotalSelectedBrandValues().getText(), EXPECTED_ZERO_OF_SELECTED_BRAND);
    }
}
