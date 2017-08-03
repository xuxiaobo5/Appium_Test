package com.appiumdemo.pages;

import com.appiumdemo.basic.Operation;

/**
 * @Author XUXIAOBO
 * @DATE 2017/8/1 0001.
 */
public class Helper {

    private Operation finder;
    PageNavigation pageCommon;
    PageMy pageMy;
    PageLogin pageLogin;

    public Helper(Operation finder){
        this.finder = finder;
    }

    public PageNavigation getPageCommon(){
        if(pageCommon == null){
            pageCommon = new PageNavigation(finder);
        }
        return pageCommon;
    }

    public PageMy getPageMy(){
        if (pageMy == null) {
            pageMy = new PageMy(finder);
        }
        return pageMy;
    }

    public PageLogin getPageLogin(){
        if(pageLogin == null){
            pageLogin = new PageLogin(finder);
        }
        return pageLogin;
    }
}
