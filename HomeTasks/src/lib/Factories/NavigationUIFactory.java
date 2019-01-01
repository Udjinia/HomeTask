package lib.Factories;

import lib.Android.AndroidNavigationUI;
import lib.IOS.IOSNavigationUI;
import lib.Platform;
import lib.mobile_web.MWNavigationUI;
import lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NavigationUIFactory
{
    public static NavigationUI get(RemoteWebDriver driver)
    {
        if (Platform.getInstance().isAndroid()){
            return new AndroidNavigationUI(driver);
        } else  if (Platform.getInstance().isIOS()) {
            return new IOSNavigationUI(driver);
        } else {
            return  new MWNavigationUI(driver);
        }
    }
}

