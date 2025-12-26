package com.example.demo.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TotalResultListener implements ITestListener {

    private int passedTests = 0;
    private int failedTests = 0;
    private int skippedTests = 0;

    @Override
    public void onTestSuccess(ITestResult result) {
        passedTests++;
        System.out.println(result.getMethod().getMethodName() + " - PASS");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        failedTests++;
        System.out.println(result.getMethod().getMethodName() + " - FAIL");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        skippedTests++;
        System.out.println(result.getMethod().getMethodName() + " - SKIPPED");
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Starting Test Suite: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Finished Test Suite: " + context.getName());
        System.out.println("Total Passed: " + passedTests);
        System.out.println("Total Failed: " + failedTests);
        System.out.println("Total Skipped: " + skippedTests);
        System.out.println("Total Tests Run: " + (passedTests + failedTests + skippedTests));
    }

    @Override
    public void onTestStart(ITestResult result) {
        // optional: can log test start
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // optional
    }
}
