package Tests.New_Task;
import lib.CoreTestCase;
import lib.Factories.ArticlePageObjectFactory;
import lib.Factories.MyListPageObjectFactory;
import lib.Factories.NavigationUIFactory;
import lib.Factories.SearchPageObjectFactory;
import lib.Platform;
import lib.ui.*;
import org.junit.Test;


public class newTaskEx5 extends CoreTestCase
{
    private static String
            NAME_OF_FOLDER ="Learning programing",
            FIRST_SEARCH="Java",
            FIRST_ARTICLE_TITLE="Java (programming language)",
            FIRST_ARTICLE_DESCRIPTION="bject-oriented programming language",
            SECOND_SEARCH="Python",
            SECOND_ARTICLE_TITLE="Python (programming language)",
            SECOND_ARTICLE_DESCRIPTION="eneral-purpose, high-level programming language",
            LOGIN="Udjinia",
            PASSWORD="Ch4ernaa";

    @Test
    public void testSaveTwoArticleInFolder()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        MyListPageObject MyListPageObject = MyListPageObjectFactory.get(driver);

//---Save first article

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(FIRST_SEARCH);
        SearchPageObject.clickByArticleWithSubstring(FIRST_ARTICLE_DESCRIPTION);
        ArticlePageObject.waitForArticleTitleElement(FIRST_ARTICLE_TITLE);
        String first_article_title=ArticlePageObject.getArticleTitle(FIRST_ARTICLE_TITLE);

        if (lib.Platform.getInstance().isAndroid()) {
            ArticlePageObject.addFirstArticleToMyList(NAME_OF_FOLDER);
        } else {
            ArticlePageObject.addFirstArticleToMySaved();
        }

        if (Platform.getInstance().isMW()){
            AuthorizationPageObject Auth=new AuthorizationPageObject(driver);
            Auth.clickAuthButton();
            Auth.enterLoginData(LOGIN, PASSWORD);
            Auth.submitForm();
            ArticlePageObject.waitForTitleElement();
            assertEquals("W are not the same page after login",FIRST_ARTICLE_TITLE,ArticlePageObject.getArticleTitle(FIRST_ARTICLE_TITLE));

            ArticlePageObject.addFirstArticleToMySaved();
        }

 //---Save second article

        SearchPageObject.initSearchInputInArticle();

        if (lib.Platform.getInstance().isIOS()) {
            SearchPageObject.clickClearButton();
        }
        SearchPageObject.typeSearchLine(SECOND_SEARCH);
        SearchPageObject.clickByArticleWithSubstring(SECOND_ARTICLE_DESCRIPTION);
        ArticlePageObject.waitForArticleTitleElement(SECOND_ARTICLE_TITLE);
        String second_article_title=ArticlePageObject.getArticleTitle(SECOND_ARTICLE_TITLE);

        if (lib.Platform.getInstance().isAndroid()) {
            ArticlePageObject.addNotFirstArticleToMyList(NAME_OF_FOLDER);
            ArticlePageObject.closeArticle();
        } else if (lib.Platform.getInstance().isIOS()){
            ArticlePageObject.addNotFirstArticleToMySaved();
            NavigationUI.clickTabToGoHomeButton();
        } else {
            ArticlePageObject.addNotFirstArticleToMySaved();
        }

//----delete first article

        if (Platform.getInstance().isMW()){
            NavigationUI.openNavigation();
        }
        NavigationUI.clickMyList();

        if (lib.Platform.getInstance().isAndroid()){
            MyListPageObject.openFolderByName(NAME_OF_FOLDER);
        }

        MyListPageObject.swipeByArticleToDelete(first_article_title);

        MyListPageObject.clickBySavedArticle(second_article_title);
        String article_title=ArticlePageObject.getArticleTitle(SECOND_ARTICLE_TITLE);

        assertEquals(
                "We see unexpected title",
                second_article_title,
                article_title
        );
    }
}
