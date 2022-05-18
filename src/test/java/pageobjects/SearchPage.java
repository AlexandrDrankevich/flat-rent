package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class SearchPage extends AbstractPage {
    @FindBy(css = "[class='btn btn-bord more-par-btn']")
    private WebElement buttonParameters;
    @FindBy(css = "[data-title]")
    private WebElement dropDownSelectDistrict;
    @FindBy(xpath = "//*[text()='Центральный район']")
    private WebElement district;
    @FindBy(css="[class='btn btn-primary btn-multi select-modal-filter']")
    private WebElement buttonSelect;
    @FindBy(css="[class='ext-filter_close-btn']")
    private  WebElement buttonCloseParameters;


    public SearchPage clickButtonParameters() {
        buttonParameters.click();
        return this;
    }

    public SearchPage chooseDistrict() {
        waitForVisibilityOfElement(dropDownSelectDistrict).click();
        Actions action = new Actions(driver);
        action.pause(Duration.ofSeconds(1)).moveToElement(district).click().build().perform();
        return this;
    }
    public SearchPage clickButtonSelect(){
        buttonSelect.click();
        return this;
    }
    public SearchPage clickButtonCloseParameters(){
        waitForElementToBeClickable(buttonCloseParameters).click();
        return this;
    }
}

