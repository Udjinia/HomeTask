package lib.Android;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class AndroidSearchPageObject extends SearchPageObject
{
    static {
        SEARCH_INIT_ELEMENT="xpath://*[contains(@text,'Search Wikipedia')]";
                SEARCH_INIT_FIELD ="id:org.wikipedia:id/menu_page_search";
                SEARCH_INPUT="xpath://*[contains(@text,'Search…')]";
                SEARCH_CANCEL_BUTTON="id:org.wikipedia:id/search_close_btn";
                SEARCH_RESULT_BY_SUBSTRING_TPL ="xpath://*[@resource-id ='org.wikipedia:id/page_list_item_container']//*[@text='{SUBSTRING}']";
                SEARCH_RESULT_ELEMENT="xpath://*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_container']";
                SEARCH_EMPTY_RESULT="xpath://*[@text='No results found']";
                SEARCH_DEFAULT_START_TEXT="xpath://*[@text='Search and read the free encyclopedia in your language']";
   }

    public AndroidSearchPageObject (AppiumDriver driver)
    {
        super(driver);
    }
}
