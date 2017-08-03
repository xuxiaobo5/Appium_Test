package com.appiumdemo.pages;

import com.appiumdemo.basic.Operation;
import org.openqa.selenium.WebElement;

/**
 * @Author XUXIAOBO
 * @DATE 2017/8/1 0001.
 */
public class PageNavigation {

    private Operation finder;

    public PageNavigation(Operation finder){
        this.finder = finder;
    }

    public WebElement getNewsTab(){
        return finder.locateById("com.netease.newsreader.activity:id/zh",0);
    }

    public WebElement getMyTab(){
        return finder.locateById("com.netease.newsreader.activity:id/zh",4);
    }

    public void clickNewsTab(){
        finder.click(getNewsTab());
    }

    public void clickMyTab(){
        finder.click(getMyTab());
    }
}
