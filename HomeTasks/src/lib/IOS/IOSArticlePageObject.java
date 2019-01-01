package lib.IOS;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSArticlePageObject extends ArticlePageObject
{
    static {
        ARTICLE_NAME_BY_SUBSTRING_TPL = "id:{ARTICLE_NAME}";
        FOOTER_ELEMENT = "id:View article in browser";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "id:Save for later";
        CLOSE_ARTICLE_BUTTON = "id:Back";
        CLOSE_SYNC_POP_UP_BUTTON ="id:places auth close";
    }

    public IOSArticlePageObject (RemoteWebDriver driver)
    {
        super(driver);
    }
}
