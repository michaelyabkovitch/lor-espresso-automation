package Tests.GuestTests.OrderTests;

import Pages.GuestPages.OrderPages.PlaceOrder;
import Tests.MainTest;
import org.testng.annotations.Test;

public class PlaceOrderTest extends MainTest {
    @Test
    public void placeOrderTesting() throws InterruptedException {
        PlaceOrder placeOrder = new PlaceOrder(driver);
        placeOrder.placeOrder();
    }
}
