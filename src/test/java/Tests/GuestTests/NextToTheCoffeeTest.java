package Tests.GuestTests;

import Pages.GuestPages.NextToTheCoffeePage;
import Tests.MainTest;
import com.aventstack.extentreports.service.ExtentTestManager;
import net.bsmch.Screenshot;
import org.testng.annotations.Test;

public class NextToTheCoffeeTest extends MainTest {
    @Test
    public void enter() throws InterruptedException {
        NextToTheCoffeePage nextToTheCoffeePage = new NextToTheCoffeePage(driver);
        nextToTheCoffeePage.click();
        ExtentTestManager.getTest().info("photo",Screenshot.captureScreen("click", driver));
        ExtentTestManager.getTest().info("Hello world");
    }
}