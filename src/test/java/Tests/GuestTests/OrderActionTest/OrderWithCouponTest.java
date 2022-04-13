package Tests.GuestTests.OrderActionTest;

import Pages.GuestPages.OrderActions.OrderOver150NIS;
import Pages.GuestPages.OrderActions.OrderWithCoupons;
import Tests.MainTest;
import org.testng.annotations.Test;

public class OrderWithCouponTest extends MainTest {
    @Test
    public void orderWithCouponsTesting() throws InterruptedException {
        OrderWithCoupons orderWithCoupons = new OrderWithCoupons(driver, wait);
        orderWithCoupons.OrderWithCouponTest();
    }
}
