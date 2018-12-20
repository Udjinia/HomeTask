package lib;

import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import lib.ui.WelkomPageObject;
import org.openqa.selenium.ScreenOrientation;
import java.time.Duration;
import lib.Platform;


public class CoreTestCase extends TestCase
{
    protected AppiumDriver driver;
    protected Platform Platform;


    @Override
    protected void setUp() throws Exception
    {

        super.setUp();
        driver = Platform.getInstance().getDriver();
        this.rotateScreenPortrait();
        this.skipWelcomPageForIOSApp();
    }

    @Override
    protected void tearDown()throws Exception
    {
        driver.quit();
        super.tearDown();
    }

    protected void rotateScreenPortrait()
    {
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    protected void rotateScreenLandscape()
    {
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }

    protected void backgroudApp(int seconds)
    {
        driver.runAppInBackground(Duration.ofSeconds(seconds));
    }

    private void skipWelcomPageForIOSApp()
    {
        if(Platform.getInstance().isIOS()){
            WelkomPageObject WelkomPageObject = new WelkomPageObject(driver);
            WelkomPageObject.clickSkip();
        }
    }
}
