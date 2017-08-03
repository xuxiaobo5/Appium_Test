package com.appiumdemo.testcases.login;

import com.appiumdemo.basic.BasicTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


/**
 * @Author XUXIAOBO
 * @DATE 2017/8/1 0001.
 */
public class Login1 extends BasicTest {

    @Test
    public void testName() throws Exception {
        helper.getPageCommon().clickMyTab();
        helper.getPageMy().clickLoginIcon();
        helper.getPageLogin().login("robotium2016@163.com","87654321");
        assertEquals("robotium2017",helper.getPageMy().getNickNameText());
    }
}
