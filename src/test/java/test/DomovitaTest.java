package test;

import org.testng.annotations.Test;
import pageobjects.HomePage;

public class DomovitaTest extends AbstractTest {
    @Test
    public void testMinFlatRent() {

        new HomePage().openPage().chooseOperationRent().chooseNumberOfRooms("1").clickButtonSearch()
                .clickButtonParameters().chooseDistrict().clickButtonSelect().clickButtonCloseParameters().createAddressPriceList();
    }
}
