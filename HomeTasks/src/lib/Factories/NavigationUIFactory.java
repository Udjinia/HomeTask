package lib.Factories;

import io.appium.java_client.AppiumDriver;
import lib.Android.AndroidNavigationUI;
import lib.IOS.IOSNavigationUI;
import lib.Platform;
import lib.ui.NavigationUI;

public class NavigationUIFactory
{
    public static NavigationUI get(AppiumDriver driver)
    {
        if (Platform.getInstance().isAndroid()){
            return new AndroidNavigationUI(driver);
        }
        else {
            return new IOSNavigationUI(driver);
        }
    }
}
