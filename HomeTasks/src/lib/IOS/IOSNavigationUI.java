package lib.IOS;

import lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSNavigationUI extends NavigationUI
{
    static {
        MY_LIST_LINK = "id:Saved";
        RETURN_TO_EXPLORE="xpath://XCUIElementTypeButton[@name='Wikipedia, return to Explore']";
    }

    public IOSNavigationUI (RemoteWebDriver driver)
    {
        super(driver);
    }
}
