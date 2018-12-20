package Tests.New_Task;

import lib.CoreTestCase;
import lib.Factories.SearchPageObjectFactory;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class newTaskEx3 extends CoreTestCase
{
    @Test
    public void testCancelSearch()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        String search_line="Java";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForSearchResult("Object-oriented programming language");

        int search_result_size=SearchPageObject.GetAmountOfFoundArticle();

        assertTrue(
                "Search result is not empty",
                search_result_size > 0
        );
        SearchPageObject.clickCancelButton();
        SearchPageObject.assertThereIsNoResultOfSearch();

        if (Platform.getInstance().isAndroid())
        {
            SearchPageObject.waitDefaulSearchText();
        }

    }
}
