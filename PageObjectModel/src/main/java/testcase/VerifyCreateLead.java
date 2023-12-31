package testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.LoginPage;


public class VerifyCreateLead extends ProjectSpecificMethod {

	@BeforeTest
	public void setValues() {
		filename ="Leads";
		shName="Sheet1";
	}
	
	@Test(dataProvider="fetchData")
	public void verifyLoginFunctality(String cname,String fname,String lname,String phno) {


		LoginPage lp = new LoginPage(driver);

		lp.enterUsername().enterPassword().clickLogin().verifyLogin().clickCRMSFA().clickLeads().clickCreateLead()
				.enterCompanyName(cname).enterFirstName(fname).enterLastName(lname).clickCreate().verifyViewLead();

	}

}
