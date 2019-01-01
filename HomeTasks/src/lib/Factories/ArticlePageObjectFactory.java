package lib.Factories;


import lib.Android.AndroidArticlePageObject;
import lib.IOS.IOSArticlePageObject;
import lib.Platform;
import lib.mobile_web.MWArticlePageObject;
import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ArticlePageObjectFactory
{
    public static ArticlePageObject get(RemoteWebDriver driver)
    {
        if (Platform.getInstance().isAndroid()){
            return new AndroidArticlePageObject(driver);
        }else if (Platform.getInstance().isIOS()) {
            return new IOSArticlePageObject(driver);
        } else {return new MWArticlePageObject(driver);}
    }
}
