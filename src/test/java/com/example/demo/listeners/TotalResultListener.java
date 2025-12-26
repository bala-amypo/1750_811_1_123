package com.example.demo.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TotalResultListener implements ITestListener {
    private int passed = 0;
    private int failed = 0;
    private int skipped = 0;

    @Override
    public void onTestSuccess(ITestResult result) {
        passed++;
        System.out.println(result.getMethod().getMethodName() + " - PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        failed++;
        System.out.println(result.getMethod().getMethodName() + " - FAILED");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        skipped++;
        System.out.println(result.getMethod().getMethodName() + " - SKIPPED");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("TOTAL RESULTS: PASSED=" + passed + ", FAILED=" + failed + ", SKIPPED=" + skipped);
    }

    @Override public void onStart(ITestContext context) {}
    @Override public void onTestStart(ITestResult result) {}
    @Override public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
}
