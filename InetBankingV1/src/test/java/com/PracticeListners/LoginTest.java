package com.PracticeListners;

import org.junit.Assert;
import org.testng.annotations.Test;

public class LoginTest {
	
	@Test
	void loginByEmail() {
		System.out.println("Login By Email");
		Assert.assertEquals("Premnath", "Premnath");
	}

	
	@Test
	void loginByFacebook() {
		System.out.println("Login By Facebook");
		Assert.assertEquals("Premnath", "Premnath");
	}
}
