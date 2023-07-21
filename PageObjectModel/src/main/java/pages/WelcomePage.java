package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.ProjectSpecificMethod;
import io.cucumber.java.en.Then;

public class WelcomePage extends ProjectSpecificMethod {
	
	public WelcomePage(RemoteWebDriver driver) {
	this.driver=driver;
	}

	public WelcomePage verifyLogin() {
		System.out.println(driver.getTitle());
		// return new WelcomePage();
		return this;
	}

	public MyHomePage clickCRMSFA() {
		driver.findElement(By.linkText("CRM/SFA")).click();
		return new MyHomePage(driver);
	}

	public void clickLogout() {

	}

}
