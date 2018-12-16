package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;

public class CoreTestCase extends TestCase
{
    protected AppiumDriver driver;

    private static final String
            PLATFORM_IOS="ios",
            PLATFORM_ANDROID="android";


    private static String AppiumURL="http://127.0.0.1:4723/wd/hub";

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();

        DesiredCapabilities capabilities=this.getCapabilitiesByPlatformEnv();
        driver = this.getDriverPlatformEnv(capabilities);
        this.rotateScreenPortrait();
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

    private DesiredCapabilities getCapabilitiesByPlatformEnv() throws Exception
    {
        String platform= System.getenv("PLATFORM");
        DesiredCapabilities capabilities=new DesiredCapabilities();
        if (platform.equals(PLATFORM_ANDROID))
        {
            capabilities.setCapability("platformName","Android");
            capabilities.setCapability("deviceName","AndroidTestDevice");
            capabilities.setCapability("platformVersion","8.0");
            capabilities.setCapability("automationName","Appium");
            capabilities.setCapability("appPackage","org.wikipedia");
            capabilities.setCapability("appActivity",".main.MainActivity");
            capabilities.setCapability("app","/Users/eartemeva/Desktop/JavaAppiumAutomation/apks/org.wikipedia.apk");

        }
        else if (platform.equals(PLATFORM_IOS)) {
            capabilities.setCapability("platformName", "Tests/IOS");
            capabilities.setCapability("deviceName", "iPhone XR");
            capabilities.setCapability("platformVersion", "12.1");
            capabilities.setCapability("app", "/Users/eartemeva/Desktop/JavaAppiumAutomation/apks/Wikipedia.app");
        }
        else
        {
            throw new Exception("Cannot get run platform from env variable. Platform value="+platform);
        }
        return capabilities;
    }

    private AppiumDriver getDriverPlatformEnv(DesiredCapabilities capabilities) throws Exception
    {
        String platform= System.getenv("PLATFORM");

        if (platform.equals(PLATFORM_ANDROID))
        {
            driver = new AndroidDriver(new URL(AppiumURL),capabilities);
        }
        else if (platform.equals(PLATFORM_IOS))
        {
            driver = new IOSDriver(new URL(AppiumURL),capabilities);
        }
        else
        {
            throw new Exception("Cannot get run driver for platform from env variable. Platform value="+platform);
        }
        return driver;
    }
}
