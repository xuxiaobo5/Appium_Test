import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;

/**
 * Created by XUXIAOBO_17 on 2017/7/16.
 */

public class Demo {

    private  AppiumDriver<WebElement> driver;

    @BeforeMethod
    public void setUp() throws Exception {
        File classpathRoot = new File(System.getProperty("user.dir"));
        File app = new File(classpathRoot,"apk/test.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Android");
        capabilities.setCapability("app",app.getAbsoluteFile());
        capabilities.setCapability("appActivity","com.netease.nr.biz.ad.AdActivity");
        capabilities.setCapability("noReset",true);
        capabilities.setCapability("sessionOverride",true);
        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
    }

    @Test
    public void testName() throws Exception {
        Thread.sleep(10000);
        driver.findElements(By.id("com.netease.newsreader.activity:id/y9")).get(4);
        driver.findElement(By.id("com.netease.newsreader.activity:id/a4h")).click();

        WebElement username = driver.findElement(By.id("com.netease.newsreader.activity:id/ot"));
        username.clear();
        username.sendKeys("xuxiaobo5@163.com");

        WebElement password = driver.findElement(By.id("com.netease.newsreader.activity:id/oz"));
        password.clear();
        password.sendKeys("Xxb520Hjj@");


    }

    @AfterMethod
    public void tearDown() throws Exception {

    }
}
