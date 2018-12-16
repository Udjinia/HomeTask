package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject

{
    private static final String
            ARTICLE_TITLE="id:org.wikipedia:id/view_page_title_text",
            FOOTER_ELEMENT="xpath://*[@text='View page in browser']",
            OPTIONS_BUTTON="xpath://android.widget.ImageView[@content-desc='More options']",
            OPTIONS_ADD_TO_MY_LIST_BUTTON="xpath://*[@text='Add to reading list']",
            ADD_TO_MY_LIST_OVERLAY ="id:org.wikipedia:id/onboarding_button",
            MY_LIST_NAME_INPUT="id:org.wikipedia:id/text_input",
            MY_LIST_OK_BUTTON ="xpath://*[@text='OK']",
            CLOSE_ARTICLE_BUTTON="xpath://android.widget.ImageButton[@content-desc='Navigate up']",
            FOLDER_NAME_BY_SUBSTRING_TPL ="xpath://*[@text='{FOLDER_NAME}']";

    public ArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    /*TEMPLATE METHODS*/
    private static String getFolderName(String name_of_folder)
    {
        return FOLDER_NAME_BY_SUBSTRING_TPL.replace("{FOLDER_NAME}",name_of_folder);
    }
    /*TEMPLATE METHODS*/

    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(ARTICLE_TITLE,"Cannot find article title",15);
    }

    public String getArticleTitle()
    {
        WebElement title_element=waitForTitleElement();
        return title_element.getAttribute("text");
    }

    public void swipeToFooter()
    {
        this.swipUpToFindElement(FOOTER_ELEMENT,"Cannot find the end of article",20);
    }

    public void addFirstArticleToMyList(String name_of_folder)
    {
        this.waitForElementAndClick(OPTIONS_BUTTON,"'More Options' button is not found",15);
        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON,"'Add to reading list' item is not found",15);
        this.waitForElementAndClick(ADD_TO_MY_LIST_OVERLAY,"'Got' button is not found",15);
        this.waitForElementAndClear(MY_LIST_NAME_INPUT,"Cannot find input to set name of articles folder",5);
        this.waitForElementAndSendKeys(MY_LIST_NAME_INPUT,name_of_folder,"Cannot put test in the article folder",5);
        this.waitForElementAndClick(MY_LIST_OK_BUTTON,"'OK' button is not pressed",15);
    }

    public void addNotFirstArticleToMyList(String substring)
    {
        this.waitForElementAndClick(OPTIONS_BUTTON,"'More Options' button is not found",15);
        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON,"'Add to reading list' item is not found",15);
        String folder_name=getFolderName(substring);
        this.waitForElementAndClick(folder_name,"'"+substring+"' folder is not found",15);
    }

    public void closeArticle()
    {
        this.waitForElementAndClick(CLOSE_ARTICLE_BUTTON,"Cannot close article, cannot find X button",15);
    }

    public void assertArticleTitleElementPresent()
    {
        this.assertElementPresent(ARTICLE_TITLE,"Cannot find article title");
    }
}
