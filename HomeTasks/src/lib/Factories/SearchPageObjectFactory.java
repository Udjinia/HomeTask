package lib.Factories;

import lib.Android.AndroidSearchPageObject;
import lib.IOS.IOSSearchPageObject;
import lib.Platform;
import lib.mobile_web.MWSearchPageObject;
import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SearchPageObjectFactory
{
    public static SearchPageObject get(RemoteWebDriver driver)
    {
        if (Platform.getInstance().isAndroid()){
            return new AndroidSearchPageObject(driver);
        } else if (Platform.getInstance().isIOS()){
            return new IOSSearchPageObject(driver);
        } else {
            return new MWSearchPageObject(driver);
        }
    }
}
