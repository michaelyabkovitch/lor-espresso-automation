package Tests.RegisteredUserTests;

import Pages.RegisteredUserPages.FavoriteItemPage;
import Tests.MainTest;
import org.testng.annotations.Test;

public class FavoriteItemTest extends MainTest {
    @Test
    public void favoriteItemTesting() throws InterruptedException {
        Thread.sleep(5000);
        FavoriteItemPage favoriteItemPage = new FavoriteItemPage(driver);
        favoriteItemPage.favoriteItemTest();
    }
}
