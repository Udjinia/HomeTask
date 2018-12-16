package Tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;

public class homeTaskEx5 {

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
    public void testSaveTwoArticleInFolder()
    {

//---Save first article
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

        String first_article_title="Java (programming language)";

        waitForElementAndClick(
                By.xpath("//*[@resource-id ='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
                "Cannot find 'Object-oriented programming language' topic searching by 'Object-oriented programming language'",
                15
        );
        waitForElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Cannot find article title",
                15
        );

        waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='More options']"),
                "'More Options' button is not found",
                15
        );

        waitForElementAndClick(
                By.xpath("//*[@text='Add to reading list']"),
                "'Add to reading list' item is not found",
                15
        );

        waitForElementAndClick(
                By.id("org.wikipedia:id/onboarding_button"),
                "'Got' button is not found",
                15
        );

        waitForElementAndClear(
                By.id("org.wikipedia:id/text_input"),
                "Cannot find input to set name of articles folder",
                5
        );

        String name_of_folder="Learning programing";

        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/text_input"),
                name_of_folder,
                "Cannot put test in the article folder",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[@text='OK']"),
                "'OK' button is not pressed",
                15
        );

//---Save second article

        waitForElementAndClick(
                By.id("org.wikipedia:id/menu_page_search"),
                "Cannot find 'Search Wikipedia' input",
                5
        );

        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search…')]"),
                "Python",
                "Cannot find search input",
                5
        );

        String second_article_title="Python (programming language)";

        waitForElementAndClick(
                By.xpath("//*[@resource-id ='org.wikipedia:id/page_list_item_container']//*[@text='General-purpose, high-level programming language']"),
                "Cannot find 'General-purpose, high-level programming language' topic searching by 'General-purpose, high-level programming language'",
                15
        );
        waitForElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Cannot find article title",
                15
        );

        waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='More options']"),
                "'More Options' button is not found",
                15
        );

        waitForElementAndClick(
                By.xpath("//*[@text='Add to reading list']"),
                "'Add to reading list' item is not found",
                15
        );

        waitForElementAndClick(
                By.xpath("//*[@text='"+name_of_folder+"']"),
                "'Learning programing' folder is not found",
                15
        );

//----delete first article

        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot close article, cannot find x link",
                15
        );

        waitForElementAndClick(
                By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"),
                "'My lists' item  is not found",
                15
        );

        waitForElementAndClick(
                By.xpath("//*[@text='"+name_of_folder+"']"),
                "Created folder is not found",
                15
        );

        swipElementToLeft(
                By.xpath("//*[@text='"+first_article_title+"']"),
                "Cannot find first saved article"
        );

        waitForElementNotPresent(
                By.xpath("//*[@text='"+first_article_title+"']"),
                "First saved article is not deleted",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[@text='"+second_article_title+"']"),
                "Second saved article is not presented in the list od saved articles",
                15
        );

        WebElement title_element=waitForElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Cannot find article title",
                15
        );
        String article_title=title_element.getAttribute("text");

        Assert.assertEquals(
                "We see unexpected title",
                second_article_title,
                article_title
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
    protected void swipeUp (int timeOfSwipe)
    {
         TouchAction action= new TouchAction(driver);

        Dimension size=driver.manage().window().getSize();
        int x=(int)(size.width/2);
        int start_y=(int)(size.height*0.85);
        int end_y=(int)(size.height*0.1);

        action.
                press(PointOption.point(x,start_y)).
                waitAction(WaitOptions.waitOptions(Duration.ofMillis(timeOfSwipe))).
                moveTo(PointOption.point(x,end_y)).
                release().
                perform();
    }

    protected  void swipUpQuick()
    {
        swipeUp(1000);
    }

    protected  void swipUpToFindElement (By by, String error_message, int max_swipe)
    {
        int already_swipr=0;
        while (driver.findElements(by).size()==0){

            if (already_swipr > max_swipe){
                waitForElementPresent(by,"Can not find element by swipping up \n"+error_message,0);
                return;
            }
            swipUpQuick();
            ++already_swipr;
        }
    }

    protected  void swipElementToLeft (By by,String error_message)
    {
        WebElement element=waitForElementPresent(by,error_message,10);

        int left_x=element.getLocation().getX();
        int right_x=left_x+element.getSize().getWidth();
        int upper_y=element.getLocation().getY();
        int lower_y=upper_y+element.getSize().getHeight();
        int middle_y=(upper_y+lower_y)/2;

        TouchAction action= new TouchAction(driver);
        action.
                press(PointOption.point(right_x,middle_y)).
                waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).
                moveTo(PointOption.point(left_x,middle_y)).
                release().
                perform();
    }
}
