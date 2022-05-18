package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ResultPage extends AbstractPage {
    private List<String> addressPriceList;
    private String flatAddressLocator = "[class='mb-5 title title--listing']";
    private String flatPriceLocator = "div[class*='price dropdown']";
    @FindBy(css = "div[class*='row items padding-fix mb-5']")
    private List<WebElement> searchResultCard;


    public List<String> createAddressPriceList() {
              List<String> addressPriceList = searchResultCard.stream()
                .map(s -> s.findElement(By.cssSelector(flatAddressLocator))
                        .getText() + " - " + s.findElement(By.cssSelector(flatPriceLocator)).getText() + "\n")
                .collect(Collectors.toList());
        logger.info(addressPriceList);
        return addressPriceList;
    }
    public int findSmallestPrice(){
        int asInt = driver.findElements(By.cssSelector(flatPriceLocator)).stream().map(s -> s.getText().replaceAll("[а-я\\s]", "")).mapToInt(s -> Integer.parseInt(s)).min().getAsInt();
        logger.info(asInt);
        return asInt;
    }
}