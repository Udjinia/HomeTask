package lib.ui;

import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MyListPageObject extends MainPageObject
{
    protected static String
            FOLDER_BY_NAME_TPL,
            ARTICLE_BY_TITLE_TPL,
            REMOVE_FROM_SAVED_BUTTON_TPL,
            ADD_TO_SAVED_BUTTON_TPL;

    public MyListPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

    /*TEMPLATE METHODS*/
    private static String gerFolderXpathByName(String name_of_folder)
    {
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}",name_of_folder);
    }

    private static String gerSavedArticleLocatorByTitle(String article_title)
    {
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}",article_title);
    }

    private static String getRemoveButtonByTitle(String article_title)
    {
        return REMOVE_FROM_SAVED_BUTTON_TPL.replace("{TITLE}",article_title);
    }

    private static String getAddButtonByTitle(String article_title)
    {
        return ADD_TO_SAVED_BUTTON_TPL.replace("{TITLE}",article_title);
    }
    /*TEMPLATE METHODS*/

    public void openFolderByName(String name_of_folder)
    {
        String folder_name_xpath=gerFolderXpathByName(name_of_folder);

        this.waitForElementAndClick(folder_name_xpath,"Created folder is not found by name " +name_of_folder,15);
    }

    public  void clickBySavedArticle (String article_title)
    {
        String article_xpath= gerSavedArticleLocatorByTitle(article_title);

        this.waitForArticleToAppearByTitle(article_title);
        this.waitForElementAndClick(article_xpath,"'"+article_title+"' article is not presented in the list of saved articles",15);

    }

    public void waitForArticleToAppearByTitle(String article_title)
    {
        String article_xpath= gerSavedArticleLocatorByTitle(article_title);

        this.waitForElementPresent(article_xpath,"Cannot find saved article by title - "+article_title,5);
    }


    public void waitForArticleToDisappearByTitle(String article_title)
    {
        String article_xpath= gerSavedArticleLocatorByTitle(article_title);

        this.waitForElementNotPresent(article_xpath,"Saved article still present with title - "+article_title,5);
    }

    public  void waitForAddButtonIsApearedOnWatchlist(String article_title)
    {
        String button_xpath= getAddButtonByTitle(article_title);
        this.waitForElementPresent(
                button_xpath,
                "Cannot find 'Add to saved list' button on the Watchlist page for  article ='"+article_title+"' by locator = "+ button_xpath,
                20
        );
    }

    public void swipeByArticleToDelete(String article_title)
    {
        this.waitForArticleToAppearByTitle(article_title);
        String article_xpath = gerSavedArticleLocatorByTitle(article_title);


        if (Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()){
            this.swipElementToLeft(article_xpath,"Cannot find saved article");
        } else {
            String remote_locator=getRemoveButtonByTitle (article_title);
            this.waitForElementAndClick(remote_locator,"Cannot find and click for removing article from saved by locator="+remote_locator ,5);
        }

        if (Platform.getInstance().isIOS()){
            this.clickElementToTheRightUpperCorner(article_xpath,"Cannot find saved article");
        }

        if (Platform.getInstance().isMW()){
            System.out.println("refresh page" );
            driver.navigate().refresh();
        }
        this.waitForArticleToDisappearByTitle(article_title);
    }
}
