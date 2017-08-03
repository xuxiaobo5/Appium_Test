package com.appiumdemo.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * @Author XUXIAOBO
 * @DATE 2017/8/2 0002.
 */
public class RetryRunner implements IRetryAnalyzer{

    int index = 0;
    int retryTimes = 1;

    public boolean retry(ITestResult iTestResult) {
        if (index < retryTimes){
            index ++;
            return true;
        }
        return false;
    }
}
