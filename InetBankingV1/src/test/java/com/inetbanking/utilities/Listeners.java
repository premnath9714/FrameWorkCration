package com.inetbanking.utilities;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.inetbanking.testcases.BaseClass;

public class Listeners extends TestListenerAdapter {
	
	public void onTestStart(ITestResult tr) {
		System.out.println("Test Started");
	}

	public void onTestSuccess(ITestResult tr) {
		System.out.println("Test Passed");
	}
	
	public void onTestFailure(ITestResult tr) {
		System.out.println("Test Failed");
		BaseClass.takeSS(tr.getName()+"-"+System.currentTimeMillis());
	}
	
	public void onTestSkipped(ITestResult tr) {
		System.out.println("Test Skipped");
	}

}
