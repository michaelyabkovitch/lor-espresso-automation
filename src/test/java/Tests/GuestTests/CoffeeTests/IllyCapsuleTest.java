package Tests.GuestTests.CoffeeTests;

import Pages.GuestPages.CoffeePages.IllyCapsulePage;
import Tests.MainTest;
import org.testng.annotations.Test;

public class IllyCapsuleTest extends MainTest {
    @Test
    public void illyTesting() {
        IllyCapsulePage illyCapsulePage = new IllyCapsulePage(driver);
        illyCapsulePage.illyTest();
    }
}
