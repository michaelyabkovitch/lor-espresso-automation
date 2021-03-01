package Tests.GuestTests;

import Pages.GuestPages.LorCapsulePage;
import Tests.MainTest;
import org.testng.annotations.Test;

public class LorCapsuleTest extends MainTest {

   // @BeforeClass
    @Test
    public void enterToPage() {
        LorCapsulePage lorCapsulePage = new LorCapsulePage(driver);
        lorCapsulePage.enterToLorPage();
    }
}
