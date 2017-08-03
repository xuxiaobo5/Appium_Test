package com.appiumdemo.basic;

import com.appiumdemo.pages.Helper;
import com.steadystate.css.util.Output;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author XUXIAOBO
 * @DATE 2017/7/21 0021.
 */
public class BasicTest {

    protected static AppiumDriver<WebElement> driver;
    protected Helper helper;
    private Operation finder;


    @BeforeMethod
    public void initDriver() throws Exception {
        File classpathRoot = new File(System.getProperty("user.dir"));
        File app = new File(classpathRoot,"apk/test.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Android Emulator");
        capabilities.setCapability("app",app.getAbsoluteFile());
        capabilities.setCapability("appActivity","com.netease.nr.biz.ad.AdActivity");
        capabilities.setCapability("unicodeKeyboard",true);
        capabilities.setCapability("restKeyboard",true);
        capabilities.setCapability("noReset",true);
        capabilities.setCapability("sessionOverride",true);
        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        finder = new Operation(driver);
        helper = new Helper(finder);
    }


    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

    public static void captureScreenShot(ITestResult result){
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String passFailMethod = result.getMethod().getRealClass().getSimpleName()+ "." + result.getMethod().getMethodName();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String dir = "screenshots/Failures";
        new File(dir).mkdir();
        String path = passFailMethod + "-" +dateFormat.format(new Date()) + ".png";
        try{
            FileUtils.copyFile(scrFile, new File(dir + "/" + path));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
