package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NavigationUI extends MainPageObject
{
    protected static String
            MY_LIST_LINK,
            RETURN_TO_EXPLORE;


    public NavigationUI(AppiumDriver driver)
    {
        super(driver);
    }

    public void clickMyList()
    {
        this.waitForElementAndClick(MY_LIST_LINK,"'My lists' item  is not found",15);
    }

    public  void clickTabToGoHomeButton()
    {
        this.waitForElementAndClick(RETURN_TO_EXPLORE,"Cannot find and click the 'Return to Explore' button ",10);
    };
}
