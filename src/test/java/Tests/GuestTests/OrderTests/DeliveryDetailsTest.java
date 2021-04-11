package Tests.GuestTests.OrderTests;

import Pages.GuestPages.OrderPages.DeliveryDetailsPage;
import Tests.MainTest;
import org.testng.annotations.Test;

public class DeliveryDetailsTest extends MainTest {
    @Test
    public void DeliveryDetailsTesting(){
        DeliveryDetailsPage deliveryDetailsPage = new DeliveryDetailsPage(driver);
        deliveryDetailsPage.startOrderDetails();
    }

}
