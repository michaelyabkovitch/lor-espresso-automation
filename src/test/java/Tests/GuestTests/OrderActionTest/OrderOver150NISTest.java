package Tests.GuestTests.OrderActionTest;

import Pages.GuestPages.OrderActions.OrderOver150NIS;
import Tests.MainTest;
import org.testng.annotations.Test;

public class OrderOver150NISTest extends MainTest {
    @Test
    public void orderOver150NISTesting() throws InterruptedException {
        OrderOver150NIS orderOver150NIS = new OrderOver150NIS(driver, wait);
        orderOver150NIS.orderOver150NISTest();
    }
}
