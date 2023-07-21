package testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.LoginPage;


public class VerifyLogin extends ProjectSpecificMethod {

	
	
	
	@Test
	public void verifyLoginFunctality() {

		LoginPage lp = new LoginPage(driver);
		/*
		 * lp.enterUsername(); lp.enterPassword(); lp.clickLogin();
		 * 
		 * 
		 * WelcomePage wp=new WelcomePage(); wp.clickCRMSFA();
		 */

		lp.enterUsername().enterPassword().clickLogin().verifyLogin();

	}

}