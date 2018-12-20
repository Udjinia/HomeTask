package Tests.New_Task;
import lib.CoreTestCase;
import lib.Factories.ArticlePageObjectFactory;
import lib.Factories.SearchPageObjectFactory;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class newTaskEx6 extends CoreTestCase {

    @Test
    public void testAssertElementPresent() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
        ArticlePageObject.assertArticleTitleElementPresent();

    }
}
