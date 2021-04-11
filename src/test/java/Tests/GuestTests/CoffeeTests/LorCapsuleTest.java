package Tests.GuestTests.CoffeeTests;

import Pages.GuestPages.CoffeePages.LorCapsulePage;
import Tests.MainTest;
import org.testng.annotations.Test;

public class LorCapsuleTest extends MainTest {
    @Test
    public void lorTesting() {
        LorCapsulePage lorCapsulePage = new LorCapsulePage(driver);
        lorCapsulePage.lorTest();
    }
}
