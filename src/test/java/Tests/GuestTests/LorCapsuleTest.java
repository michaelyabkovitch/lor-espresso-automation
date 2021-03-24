package Tests.GuestTests;

import Pages.GuestPages.LorCapsulePage;
import Tests.MainTest;
import org.testng.annotations.Test;

public class LorCapsuleTest extends MainTest {
    @Test
    public void lorTesting() {
        LorCapsulePage lorCapsulePage = new LorCapsulePage(driver);
        lorCapsulePage.lorTest();
    }

}
