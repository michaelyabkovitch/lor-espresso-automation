package Tests.GuestTests;

import Pages.GuestPages.SearchBox;
import Tests.MainTest;
import org.testng.annotations.Test;

public class SearchBoxTest extends MainTest {
    @Test
    public void searchBoxTesting() {
        SearchBox searchBox = new SearchBox(driver);
        searchBox.searchItem();
    }
}
