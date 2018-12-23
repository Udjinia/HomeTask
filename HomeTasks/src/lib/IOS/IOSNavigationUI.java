package lib.IOS;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUI;

public class IOSNavigationUI extends NavigationUI
{
    static {
        MY_LIST_LINK = "id:Saved";
        RETURN_TO_EXPLORE="xpath://XCUIElementTypeButton[@name='Wikipedia, return to Explore']";
    }

    public IOSNavigationUI (AppiumDriver driver)
    {
        super(driver);
    }
}
