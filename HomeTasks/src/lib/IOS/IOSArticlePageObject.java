package lib.IOS;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class IOSArticlePageObject extends ArticlePageObject
{
    static {
        ARTICLE_NAME_BY_SUBSTRING_TPL = "id:{ARTICLE_NAME}";
        FOOTER_ELEMENT = "id:View article in browser";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "id:Save for later";
        CLOSE_ARTICLE_BUTTON = "id:Back";
        CLOSE_SYNC_POP_UP_BUTTON ="id:places auth close";
    }

    public IOSArticlePageObject (AppiumDriver driver)
    {
        super(driver);
    }
}
