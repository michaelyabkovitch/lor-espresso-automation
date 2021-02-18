package Tests;

import Pages.NextToTheCoffeePage;
import com.aventstack.extentreports.service.ExtentTestManager;
import net.bsmch.Screenshot;
import org.testng.annotations.Test;

import java.awt.*;

public class NextToTheCoffeeTest extends MainTest {
    @Test
    public void enter() throws InterruptedException {
        NextToTheCoffeePage nextToTheCoffeePage = new NextToTheCoffeePage(driver);
        nextToTheCoffeePage.click();
        Thread.sleep(10000);
        ExtentTestManager.getTest().info("photo",Screenshot.captureScreen("click", driver));
        ExtentTestManager.getTest().info("Hello world");
    }
}