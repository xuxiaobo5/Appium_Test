package com.appiumdemo.basic;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * @Author XUXIAOBO
 * @DATE 2017/8/1 0001.
 */
public class Operation {

    private AppiumDriver<WebElement> driver;
    private static int DEFAULT_TIMEOUT = 10;

    public Operation(AppiumDriver driver){
        this.driver = driver;
    }

    public void waitForElement(By by){
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement locateById(String id){
        waitForElement(By.id(id));
        return driver.findElement(By.id(id));
    }

    public WebElement locateById(String id, int index){
        waitForElement(By.id(id));
        return driver.findElements(By.id(id)).get(index);
    }

    public WebElement locateByText(String text){
        waitForElement(By.xpath("//android.widget.TextView[@text='"+ text +"']"));
        return driver.findElement(By.xpath("//android.widget.TextView[@text='"+ text +"']"));
    }

    public WebElement locateByText(String text, int index){
        waitForElement(By.xpath("//android.widget.TextView[@text='"+ text +"']"));
        return driver.findElements(By.xpath("//android.widget.TextView[@text='"+ text +"']")).get(index);
    }

    public WebElement locateByClassType(String className, int index){
        waitForElement(By.className(className));
        return driver.findElements(By.className(className)).get(index);
    }

    public void click(WebElement ele){
        ele.click();
    }

    public void longClick(WebElement ele){
        TouchAction action = new TouchAction(driver);
        action.longPress(ele).perform().release();
    }

    public String getWebElementText(WebElement ele){
        return ele.getText();
    }

    public void enterText(WebElement ele, String text){
        ele.click();
        ele.clear();
        ele.sendKeys(text);
    }

}
