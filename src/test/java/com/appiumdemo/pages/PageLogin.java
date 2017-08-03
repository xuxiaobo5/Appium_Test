package com.appiumdemo.pages;

import com.appiumdemo.basic.Operation;
import org.openqa.selenium.WebElement;

/**
 * @Author XUXIAOBO
 * @DATE 2017/8/1 0001.
 */
public class PageLogin {

    private Operation finder;

    public PageLogin(Operation finder){
        this.finder = finder;
    }

    public WebElement getNameET(){
        return finder.locateById("com.netease.newsreader.activity:id/mv");
    }

    public WebElement getPasswordET(){
        return finder.locateById("com.netease.newsreader.activity:id/n1");
    }

    public WebElement getLoginBtn(){
        return finder.locateById("com.netease.newsreader.activity:id/n2");
    }

    public void enterName(String name){
        finder.enterText(getNameET(),name);
    }

    public void enterPassword(String password){
        finder.enterText(getPasswordET(),password);
    }

    public void clickLoginBtn(){
        getLoginBtn().click();
    }

    public void login(String name, String password){
        enterName(name);
        enterPassword(password);
        clickLoginBtn();
    }
}
