package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {
    private final String BASE_URL = "https://domovita.by/";
    @FindBy(css = "button#accent-cookie-consent-button")
    private WebElement buttonCookieApproval;
    @FindBy(css = "#select2-operation-container")
    private WebElement dropDownOperation;
    @FindBy(css = "[id*='rent']")
    private WebElement operationRent;
    @FindBy(css = "#rooms")
    private WebElement dropDownRooms;
    private String patternNumberOfRoomsLocator = "span[data-val='%s']";
    @FindBy(css = "button[type='submit']")
    private WebElement buttonSearch;

    public HomePage openPage() {
        driver.get(BASE_URL);
        giveCookieApproval();
        return this;
    }

    public void giveCookieApproval() {
        buttonCookieApproval.click();
    }

    public HomePage chooseOperationRent() {
        dropDownOperation.click();
        waitForVisibilityOfElement(operationRent).click();
        return this;
    }

    public HomePage chooseNumberOfRooms(String number) {
        dropDownRooms.click();

        waitForVisibilityOfElement(driver.findElement(By
                .cssSelector(String.format(patternNumberOfRoomsLocator, number)))).click();
        return this;
    }

    public SearchPage clickButtonSearch() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        buttonSearch.click();
        return new SearchPage();
    }
}
