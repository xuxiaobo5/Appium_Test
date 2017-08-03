package com.appiumdemo.listeners;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.IAnnotation;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @Author XUXIAOBO
 * @DATE 2017/8/2 0002.
 */
public class RetryListener implements IAnnotationTransformer {
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
        IRetryAnalyzer iRetryAnalyzer = iTestAnnotation.getRetryAnalyzer();
        if (iRetryAnalyzer == null){
            iTestAnnotation.setRetryAnalyzer(RetryRunner.class);
        }
    }
}
