package Tests.GuestTests;

import Pages.GuestPages.JacobsPage;
import Tests.MainTest;
import org.testng.annotations.Test;

public class JacobsTest extends MainTest {
    @Test
    public void jacobsTesting() {
        JacobsPage jacobsPage = new JacobsPage(driver);
        jacobsPage.jacobsTest();
    }
}
