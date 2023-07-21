package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;



import base.ProjectSpecificMethod;

public class MyHomePage extends ProjectSpecificMethod{


	public MyHomePage(RemoteWebDriver driver) {
		this.driver=driver;
		}

	public LeadsPage clickLeads() {
		driver.findElement(By.linkText("Leads")).click();
		return new LeadsPage(driver);

	}
}
