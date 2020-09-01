package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WomanPage extends BasePage {

    public WomanPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@data-id='96b432e3-d374-4293-8145-b00772447cde']")
    private WebElement clothesMenuItem;

    @FindBy(xpath = "//div[@data-testid='secondarynav-container']//a[contains(text(), 'Coats & Jacket')]")
    private WebElement coatsAndJacketMenuItem;

    public void clickCoatsAndJacketMenuItem() { coatsAndJacketMenuItem.click(); }

    public void clickClothesMenuItem() {
        clothesMenuItem.click();
    }
}
