package com.appiumdemo;

import com.appiumdemo.basic.BasicTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.Set;

/**
 * Created by XUXIAOBO_17 on 2017/7/16.
 */

public class WebViewOperation extends BasicTest {

    @Test
    public void testDemo() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("com.netease.newsreader.activity:id/b54")));
        WebElement newsItem = driver.findElements(By.id("com.netease.newsreader.activity:id/cr")).get(2);
        newsItem.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("com.netease.newsreader.activity:id/ap7")));
        Set<String> handles = driver.getContextHandles();
        for (String handle : handles){
            System.out.println(handle);
        }
        driver.context("WEBVIEW");
        driver.findElement(By.id("//*[@id=\"img-0\"]/div/div[1]")).click();
    }

}
