package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.WebElement;

abstract public class ArticlePageObject extends MainPageObject {
    protected static String
            ARTICLE_TITLE,
            FOOTER_ELEMENT,
            OPTIONS_BUTTON,
            OPTIONS_ADD_TO_MY_LIST_BUTTON,
            ADD_TO_MY_LIST_OVERLAY,
            MY_LIST_NAME_INPUT,
            MY_LIST_OK_BUTTON,
            CLOSE_ARTICLE_BUTTON,
            CLOSE_SYNC_POP_UP_BUTTON,
            FOLDER_NAME_BY_SUBSTRING_TPL,
            ARTICLE_NAME_BY_SUBSTRING_TPL;

    public ArticlePageObject(AppiumDriver driver) {
        super(driver);
    }

    /*TEMPLATE METHODS*/
    private static String getFolderName(String name_of_folder) {
        return FOLDER_NAME_BY_SUBSTRING_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }

    private static String getArticleName(String name_of_article) {
        return ARTICLE_NAME_BY_SUBSTRING_TPL.replace("{ARTICLE_NAME}", name_of_article);
    }

    /*TEMPLATE METHODS*/

    public WebElement waitForArticleTitleElement(String article_title) {
        if (Platform.getInstance().isAndroid()) {
            return this.waitForElementPresent(ARTICLE_TITLE, "Cannot find article title", 15);
        } else {
            String article_name = getArticleName(article_title);
            return this.waitForElementPresent(article_name, "Cannot find article title", 15);
        }
    }

    public String getArticleTitle(String article_title) {
        WebElement title_element = waitForArticleTitleElement(article_title);
        if (Platform.getInstance().isAndroid()) {
            return title_element.getAttribute("text");
        } else {
            return title_element.getAttribute("name");
        }
    }

    public void swipeToFooter() {
        if (Platform.getInstance().isAndroid()) {
            this.swipUpToFindElement(FOOTER_ELEMENT, "Cannot find the end of article", 50);
        } else {
            this.swipUpTillElementApeare(FOOTER_ELEMENT, "Cannot find the end of article", 50);
        }
    }

    public void addFirstArticleToMyList(String name_of_folder) {
        this.waitForElementAndClick(OPTIONS_BUTTON, "'More Options' button is not found", 15);
        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON, "'Add to reading list' item is not found", 15);
        this.waitForElementAndClick(ADD_TO_MY_LIST_OVERLAY, "'Got' button is not found", 15);
        this.waitForElementAndClear(MY_LIST_NAME_INPUT, "Cannot find input to set name of articles folder", 5);
        this.waitForElementAndSendKeys(MY_LIST_NAME_INPUT, name_of_folder, "Cannot put test in the article folder", 5);
        this.waitForElementAndClick(MY_LIST_OK_BUTTON, "'OK' button is not pressed", 15);
    }

    public void addNotFirstArticleToMyList(String substring) {
        this.waitForElementAndClick(OPTIONS_BUTTON, "'More Options' button is not found", 15);
        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON, "'Add to reading list' item is not found", 15);
        String folder_name = getFolderName(substring);
        this.waitForElementAndClick(folder_name, "'" + substring + "' folder is not found", 15);
    }

    public void addFirstArticleToMySaved() {
        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON, "Cannot add article to reading list", 10);
        this.waitForElementAndClick(CLOSE_SYNC_POP_UP_BUTTON, "Cannot close sync pop up", 10);
    }

    public void addNotFirstArticleToMySaved() {
        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON, "Cannot add article to reading list", 10);

    }

    public void closeArticle() {
        this.waitForElementAndClick(CLOSE_ARTICLE_BUTTON, "Cannot close article, cannot find X button", 15);
    }

    public void assertArticleTitleElementPresent() {
        this.assertElementPresent(ARTICLE_TITLE, "Cannot find article title");
    }
}

