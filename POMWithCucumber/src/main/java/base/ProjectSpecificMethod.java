package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utils.ReadExcelData;

public class ProjectSpecificMethod extends AbstractTestNGCucumberTests {

	// public RemoteWebDriver driver;

	// Challenge :
	// Cucumber requries driver instance to be static
	// POM - static supports sequential
	// -parallel is not possible with static
	// POM requires constructor call to share the driver instance between
	// the pages for individual threads
	// Step:1 to make the thread secured
	private static final ThreadLocal<RemoteWebDriver> tlDriver = new ThreadLocal<RemoteWebDriver>();

	public RemoteWebDriver getDriver() {
		return tlDriver.get();
	}

	public void setDriver() {
		// ChromeOptions opt =new ChromeOptions();
		tlDriver.set(new ChromeDriver());
	}

	public static Properties prop;
	public String filename, shName;
	
	@Parameters({ "language" })
	@BeforeMethod
	public void preCondition(String language) throws IOException {

		if (language.equalsIgnoreCase("English")) {
			FileInputStream fis = new FileInputStream("src/main/resources/Config_en.properties");
			prop = new Properties();
			prop.load(fis);
		} else if (language.equalsIgnoreCase("French")) {
			FileInputStream fis = new FileInputStream("src/main/resources/Config_fr.properties");
			prop = new Properties();
			prop.load(fis);
		}
		// driver = new ChromeDriver();
		setDriver();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterMethod
	public void postCondition() {
		getDriver().close();
	}

	@DataProvider(indices = 0)
	public String[][] sendData() throws IOException {
		// create a two dimensional array
		return ReadExcelData.readData(filename, shName);

	}

	
}
