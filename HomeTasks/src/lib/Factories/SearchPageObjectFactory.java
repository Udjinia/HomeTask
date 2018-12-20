package lib.Factories;

import io.appium.java_client.AppiumDriver;
import lib.Android.AndroidSearchPageObject;
import lib.IOS.IOSSearchPageObject;
import lib.Platform;
import lib.ui.SearchPageObject;

public class SearchPageObjectFactory
{
    public static SearchPageObject get(AppiumDriver driver)
    {
        if (Platform.getInstance().isAndroid()){
            return new AndroidSearchPageObject(driver);
        }
        else {
            return new IOSSearchPageObject(driver);
        }
    }
}
