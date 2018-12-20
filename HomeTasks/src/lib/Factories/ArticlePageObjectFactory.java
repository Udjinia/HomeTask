package lib.Factories;

import io.appium.java_client.AppiumDriver;
import lib.Android.AndroidArticlePageObject;
import lib.IOS.IOSArticlePageObject;
import lib.Platform;
import lib.ui.ArticlePageObject;

public class ArticlePageObjectFactory
{
    public static ArticlePageObject get(AppiumDriver driver)
    {
        if (Platform.getInstance().isAndroid()){
            return new AndroidArticlePageObject(driver);
        }
        else {
            return new IOSArticlePageObject(driver);
        }
    }
}
