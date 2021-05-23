package Tests.GuestTests.OrderTests;

import Pages.GuestPages.OrderPages.CardPaymentPage;
import Pages.GuestPages.OrderPages.DeliveryDetailsPage;
import Pages.GuestPages.OrderPages.PlaceOrder;
import Tests.MainTest;
import org.testng.annotations.Test;

public class CardPaymentTest extends MainTest {
    @Test
    public void cardPaymentTesting() throws InterruptedException {
        CardPaymentPage cardPaymentPage = new CardPaymentPage(driver, wait);
        cardPaymentPage.startPaymentTest();
    }
}
