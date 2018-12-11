package tests;
import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.MyListPageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import org.junit.Test;


public class newTaskEx5 extends CoreTestCase
{

    @Test
    public void testSaveTwoArticleInFolder()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        NavigationUI NavigationUI = new NavigationUI(driver);
        MyListPageObject MyListPageObject = new MyListPageObject(driver);

//---Save first article

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
        ArticlePageObject.waitForTitleElement();
        String first_article_title=ArticlePageObject.getArticleTitle();
        String name_of_folder="Learning programing";
        ArticlePageObject.addFirstArticleToMyList(name_of_folder);

 //---Save second article

        SearchPageObject.initSearchInputInArticle();
        SearchPageObject.typeSearchLine("Python");
        SearchPageObject.clickByArticleWithSubstring("General-purpose, high-level programming language");
        ArticlePageObject.waitForTitleElement();
        String second_article_title=ArticlePageObject.getArticleTitle();
        ArticlePageObject.addNotFirstArticleToMyList(name_of_folder);
        ArticlePageObject.closeArticle();

//----delete first article

        NavigationUI.clickMyList();
        MyListPageObject.openFolderByName(name_of_folder);
        MyListPageObject.swipeByArticleToDelete(first_article_title);
        MyListPageObject.clickBySavedArticle(second_article_title);
        String article_title=ArticlePageObject.getArticleTitle();

        assertEquals(
                "We see unexpected title",
                second_article_title,
                article_title
        );
    }
}
