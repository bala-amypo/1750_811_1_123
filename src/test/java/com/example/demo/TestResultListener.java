package com.example.demo.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;

public class TestResultListener implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getMethod().getMethodName() + " - PASS");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getMethod().getMethodName() + " - FAIL");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println(result.getMethod().getMethodName() + " - SKIPPED");
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("=== TEST STARTED ===");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("=== TEST FINISHED ===");
    }
}