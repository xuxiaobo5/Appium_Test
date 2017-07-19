import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;
import java.util.List;

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
        capabilities.setCapability("deviceName","Android Emulator");
        capabilities.setCapability("app",app.getAbsoluteFile());
        capabilities.setCapability("appActivity","com.netease.nr.biz.ad.AdActivity");
        capabilities.setCapability("unicodeKeyboard",true);
        capabilities.setCapability("restKeyboard",true);
        capabilities.setCapability("noReset",true);
        capabilities.setCapability("sessionOverride",true);
        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
    }

    @Test
    public void testDemo() throws Exception {
        //Thread.sleep(10000);
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("com.netease.newsreader.activity:id/be3")));
//        driver.findElement(By.id("com.netease.newsreader.activity:id/be3")).click();
//        WebElement searchET = driver.findElement(By.id("com.netease.newsreader.activity:id/aev"));
//        searchET.sendKeys("234508021@qq.com");
//        Thread.sleep(5000);

        //列表的操作
        List<WebElement> elements = driver.findElements(By.id("com.netease.newsreader.activity:id/du"));
        String expectedText = "这些肉中的寄生虫最多，千万不要再吃了！";
        int index = -1;
        for (int i = 0; i < elements.size(); i++) {
            if(elements.get(i).getText().contains(expectedText)){
                index = i;
                break;
            }
        }
        System.out.println("=============="+ index);

//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("com.netease.newsreader.activity:id/be3")));
//        driver.findElements(By.id("com.netease.newsreader.activity:id/y9")).get(4).click();
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("com.netease.newsreader.activity:id/a4h")));
//        driver.findElement(By.id("com.netease.newsreader.activity:id/a4h")).click();
//
//        WebElement username = driver.findElement(By.id("com.netease.newsreader.activity:id/ot"));
//        username.clear();
//        username.sendKeys("xuxiaobo5@163.com");
//        WebElement password = driver.findElement(By.id("com.netease.newsreader.activity:id/oz"));
//        password.clear();
//        password.sendKeys("Xxb520Hjj@");
//        WebElement loginBtn = driver.findElement(By.id("com.netease.newsreader.activity:id/p1"));
//        loginBtn.click();
//
//        driver.findElement(By.id("com.netease.newsreader.activity:id/a2g")).click();
//        WebElement firstEle = driver.findElements(By.id("com.netease.newsreader.activity:id/du")).get(0);
//        TouchAction action = new TouchAction(driver);
//        action.longPress(firstEle);
//        Thread.sleep(5000);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
}
