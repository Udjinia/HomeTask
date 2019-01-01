package lib.ui;

import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NavigationUI extends MainPageObject
{
    protected static String
            MY_LIST_LINK,
            RETURN_TO_EXPLORE,
            OPEN_NAVIGATION;


    public NavigationUI(RemoteWebDriver driver)
    {
        super(driver);
    }

    public void clickMyList()
    {
        if (Platform.getInstance().isMW()) {
            this.tryCllickElementWithFewAttempts(MY_LIST_LINK,"'My lists' item  is not found",10);
        } else {
            this.waitForElementAndClick(MY_LIST_LINK, "'My lists' item  is not found", 15);
        }
    }

    public  void clickTabToGoHomeButton()
    {
        this.waitForElementAndClick(RETURN_TO_EXPLORE,"Cannot find and click the 'Return to Explore' button ",10);
    }

    public void openNavigation()
    {
        if (Platform.getInstance().isMW()) {
            this.waitForElementAndClick(OPEN_NAVIGATION, "Cannot find and click open navigation button", 5);
        } else {
            System.out.println("Method openNavigation() do nothing for platform"+Platform.getInstance().getPlatformVar());
        }
    }
}
