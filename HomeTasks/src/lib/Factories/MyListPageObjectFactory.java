package lib.Factories;

import io.appium.java_client.AppiumDriver;
import lib.Android.AndroidMyListPageObject;
import lib.IOS.IOSMyListPageObject;
import lib.Platform;
import lib.ui.MyListPageObject;

public class MyListPageObjectFactory
{
    public static MyListPageObject get(AppiumDriver driver)
    {
        if (Platform.getInstance().isAndroid()){
            return new AndroidMyListPageObject(driver);
        }
        else {
            return new IOSMyListPageObject(driver);
        }
    }
}
