package lib.Factories;

import lib.Android.AndroidMyListPageObject;
import lib.IOS.IOSMyListPageObject;
import lib.Platform;
import lib.mobile_web.MWMyListPageObject;
import lib.ui.MyListPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MyListPageObjectFactory
{
    public static MyListPageObject get(RemoteWebDriver driver)
    {
        if (Platform.getInstance().isAndroid()){
            return new AndroidMyListPageObject(driver);
        } else if (Platform.getInstance().isIOS()) {
            return new IOSMyListPageObject(driver);
        } else {
            return  new MWMyListPageObject(driver);
        }
    }
}
