package lib;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Platform
{
    private static final String
            PLATFORM_IOS="ios",
            PLATFORM_ANDROID="android",
            PLATFORM_MOBILE_WEB="mobile_web",
            Appium_URL="http://127.0.0.1:4723/wd/hub";

    private static Platform instance;

    private Platform()  {}

    public static Platform getInstance()
    {
        if (instance == null) { instance = new Platform(); }
        return instance;
    }

    public RemoteWebDriver getDriver () throws Exception
    {
        URL URL=new URL(Appium_URL);
        if (this.isAndroid()){
            return new AndroidDriver(URL,this.getAndroidDesiredCapabilities());
        }else if (this.isIOS()) {
            return new IOSDriver(URL,this.getAIOSDesiredCapabilities());
        }else if (this.isMW()) {
            System.setProperty("webdriver.chrome.driver","/Users/eartemeva/Desktop/JavaAppium/chrome_driver/chromedriver");
            return new ChromeDriver(this.getMWCromeOptions());
        }else{
            throw new Exception("Cannot detect type of platform driver. Platform value="+this.getPlatformVar());
        }
    }

    public boolean isAndroid()
    {
        return isPlatfrom(PLATFORM_ANDROID);
    }

    public boolean isIOS()
    {
        return isPlatfrom(PLATFORM_IOS);
    }

    public boolean isMW()
    {
        return isPlatfrom(PLATFORM_MOBILE_WEB);
    }

    private DesiredCapabilities getAndroidDesiredCapabilities()
    {
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","AndroidTestDevice");
        capabilities.setCapability("platformVersion","8.0");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage","org.wikipedia");
        capabilities.setCapability("appActivity",".main.MainActivity");
        capabilities.setCapability("app","/Users/eartemeva/Desktop/JavaAppiumAutomation/apks/org.wikipedia.apk");
        return capabilities;
    }

    private DesiredCapabilities getAIOSDesiredCapabilities()
    {
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability("platformName", "Tests/IOS");
        capabilities.setCapability("deviceName", "iPhone SE");
        capabilities.setCapability("platformVersion", "11.3");
        capabilities.setCapability("app", "/Users/eartemeva/Desktop/JavaAppiumAutomation/apks/Wikipedia.app");
        return capabilities;
    }

    private ChromeOptions getMWCromeOptions()
    {
        Map<String, Object> deviceMetrics= new HashMap<String, Object>();
        deviceMetrics.put("width",360);
        deviceMetrics.put("height",640);
        deviceMetrics.put("pixelRatio",3.0);

        Map<String, Object> mobileEmulator= new HashMap<String, Object>();
        mobileEmulator.put("deviceMetrics",deviceMetrics);
        mobileEmulator.put("userAgent","Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D)");

        ChromeOptions chromeOptions= new ChromeOptions();
        chromeOptions.addArguments("window-size=340,640");

        return chromeOptions;
    }

    private boolean isPlatfrom(String my_platform)
    {
        String platform=this.getPlatformVar();
        return my_platform.equals(platform);
    }

    public String getPlatformVar()
    {
        return System.getenv("PLATFORM");
    }

}