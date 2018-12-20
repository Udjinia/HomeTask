package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NavigationUI extends MainPageObject
{
    protected static String
            MY_LIST_LINK;


    public NavigationUI(AppiumDriver driver)
    {
        super(driver);
    }

    public void clickMyList()
    {
        this.waitForElementAndClick(MY_LIST_LINK,"'My lists' item  is not found",15);
    }
}
