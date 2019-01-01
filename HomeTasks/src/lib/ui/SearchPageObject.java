package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class SearchPageObject extends MainPageObject
{
    protected static  String
            SEARCH_INIT_ELEMENT,
            SEARCH_INIT_FIELD ,
            SEARCH_INPUT,
            SEARCH_CANCEL_BUTTON,
            SEARCH_RESULT_BY_SUBSTRING_TPL,
            SEARCH_RESULT_ELEMENT,
            SEARCH_EMPTY_RESULT,
            SEARCH_DEFAULT_START_TEXT,
            SEARCH_CLEAR_BUTTON;

    public SearchPageObject (RemoteWebDriver driver)
    {
        super(driver);
    }

    /*TEMPLATE METHODS*/
    private static String gerResultSearchElement(String substring)
    {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}",substring);
    }
    /*TEMPLATE METHODS*/

    public void initSearchInput()
    {
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT,"Cannot find 'Search Wikipedia' input",15);
        this.waitForElementPresent(SEARCH_INIT_ELEMENT,"Cannot find 'Search Wikipedia' input after clicking init element",5);
    }

    public void initSearchInputInArticle()
    {
        this.waitForElementAndClick(SEARCH_INIT_FIELD,"Cannot find and click search button in article",5);

    }

    public void typeSearchLine(String search_line)
    {
        this.waitForElementAndSendKeys(SEARCH_INPUT,search_line,"Cannot find and type into search input",5);
    }

    public void waitForSearchResult(String substring)
    {
        String search_result_xpath = gerResultSearchElement(substring);
        this.waitForElementPresent(search_result_xpath,"Cannot find search result with substring "+ search_result_xpath ,5);
    }

    public  void waitForCancelButtonToAppear()
    {
        this.waitForElementPresent(SEARCH_CANCEL_BUTTON,"Cannot find X to cancel search",15);
    }

    public  void waitForCancelButtonToDisappear()
    {
        this.waitForElementNotPresent(SEARCH_CANCEL_BUTTON,"X is still present on the page",5);
    }

    public void clickCancelButton()
    {
        this.waitForElementAndClick(SEARCH_CANCEL_BUTTON,"Cannot find and click search cancel button",5);
    }

    public void clickByArticleWithSubstring(String substring)
    {
        String search_result_xpath = gerResultSearchElement(substring);
        this.waitForElementAndClick(search_result_xpath,"Cannot find and click search result with substring "+ search_result_xpath ,10);
    }

    public int GetAmountOfFoundArticle()
    {

        this.waitForElementPresent(SEARCH_RESULT_ELEMENT,"Cannot find anything by request",15);

        return this.getAmountOfElements(SEARCH_RESULT_ELEMENT);

    }

    public void waitForEmptyResultLabel()
    {
        this.waitForElementPresent(SEARCH_EMPTY_RESULT,"Cannot find empty result element",15);

    }

    public void assertThereIsNoResultOfSearch()
    {
        this.waitForElementNotPresent(SEARCH_RESULT_ELEMENT,"We supposed not ti find any result",15);
    }

    public  void waitDefaulSearchText()
    {
        waitForElementPresent(SEARCH_DEFAULT_START_TEXT,"Default text for starting search is not presented",15);
    }

    public  void clickClearButton()
    {
        this.waitForElementAndClick(SEARCH_CLEAR_BUTTON,"Cannot find and click Clear button in search field",15);
    };
}
