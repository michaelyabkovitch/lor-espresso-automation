package Tests.GuestTests.CoffeeTests;

import Pages.GuestPages.CoffeePages.NextToTheCoffeePage;
import Tests.MainTest;
import org.testng.annotations.Test;

public class NextToTheCoffeeTest extends MainTest {
    @Test
    public void nextToTheCoffeeTesting() throws InterruptedException {
        NextToTheCoffeePage nextToTheCoffeePage = new NextToTheCoffeePage(driver);
        nextToTheCoffeePage.nextToCoffeeTest();
    }
}