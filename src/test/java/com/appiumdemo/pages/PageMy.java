package com.appiumdemo.pages;

import com.appiumdemo.basic.Operation;
import org.openqa.selenium.WebElement;

/**
 * @Author XUXIAOBO
 * @DATE 2017/8/1 0001.
 */
public class PageMy {

    private Operation finder;

    public PageMy(Operation finder){
        this.finder = finder;
    }

    public WebElement getLoginIcon(){
        return finder.locateById("com.netease.newsreader.activity:id/a6y");
    }

    public void clickLoginIcon(){
        finder.click(getLoginIcon());
    }

    public  WebElement getNickName(){
        return finder.locateById("com.netease.newsreader.activity:id/apm");
    }

    public String getNickNameText(){
        return finder.getWebElementText(getNickName());
    }
}
