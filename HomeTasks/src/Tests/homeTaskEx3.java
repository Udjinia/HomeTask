package Tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.List;

public class homeTaskEx3 {


    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception
    {

        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","AndroidTestDevice");
        capabilities.setCapability("platformVersion","8.0");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage","org.wikipedia");
        capabilities.setCapability("appActivity",".main.MainActivity");
        capabilities.setCapability("app","C:/HomeTask/HomeTasks/apks/org.wikipedia.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

    @Test
    public void testCancelSearch()
    {
        waitForElementAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Cannot find 'Search Wikipedia' input",
                5
        );

        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search…')]"),
                "Java",
                "Cannot find search input",
                5
        );

        waitForElementPresent(
                By.xpath("//*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_container']"),
                "Cannot find anything by request Java",
                15
        );

        int search_result_size=getAmountOfElements(
                By.xpath("//*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_container']")
        );

        Assert.assertTrue(
                "Search result is not empty",
                search_result_size > 0
        );

        waitForElementAndClick(
                By.id("org.wikipedia:id/search_close_btn"),
                "X button for clear search request is not clicked",
                5
        );

        int search_result_size_after=getAmountOfElements(
                By.xpath("//*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_container']")
        );

        Assert.assertTrue(
                "Search result is not empty",
                search_result_size_after == 0
        );

        waitForElementPresent(
                By.xpath("//*[@text='Search and read the free encyclopedia in your language']"),
                "Default text for starting search is not presented",
                15
        );
    }

    private WebElement waitForElementPresent (By by, String error_message, long timeoutInSecond )
    {
        WebDriverWait wait=new WebDriverWait(driver,timeoutInSecond);
        wait.withMessage(error_message+"\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private boolean waitForElementNotPresent (By by,String error_message, long timeoutInSecond)
    {
        WebDriverWait wait=new WebDriverWait(driver,timeoutInSecond);
        wait.withMessage(error_message+"\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    private WebElement waitForElementAndClick(By by, String error_message, long timeoutInSecond)
    {
        WebElement element= waitForElementPresent(by,error_message,timeoutInSecond);
        element.click();
        return element;
    }

    private WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSecond)
    {
        WebElement element= waitForElementPresent(by ,error_message,timeoutInSecond);
        element.sendKeys(value);
        return element;
    }

    private WebElement waitForElementAndClear (By by, String error_message, long timeoutInSecond)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSecond);
        element.clear();
        return element;
    }

    private int getAmountOfElements(By by)
    {
        List elements=driver.findElements(by);
        return elements.size();
    }
}
