package com.appiumdemo;

import com.appiumdemo.basic.BasicTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by XUXIAOBO_17 on 2017/7/16.
 */

public class Demo extends BasicTest {

    @Test
    public void testDemo() throws Exception {
        //Thread.sleep(10000);
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("com.netease.newsreader.activity:id/be3")));
//        driver.findElement(By.id("com.netease.newsreader.activity:id/be3")).click();
//        WebElement searchET = driver.findElement(By.id("com.netease.newsreader.activity:id/aev"));
//        searchET.sendKeys("234508021@qq.com");
//         Thread.sleep(5000);

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

}
