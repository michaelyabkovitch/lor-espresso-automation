package Tests.GuestTests.CoffeeTests;

import Pages.GuestPages.CoffeePages.JacobsPage;
import Tests.MainTest;
import org.testng.annotations.Test;

public class JacobsTest extends MainTest {
    @Test
    public void jacobsTesting() throws InterruptedException {
        JacobsPage jacobsPage = new JacobsPage(driver);
        jacobsPage.jacobsTest();
    }
}
