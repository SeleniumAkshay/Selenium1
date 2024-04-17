package com.shoppersStack.genericUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.shoppersStack.pom.HomePage;
import com.shoppersStack.pom.LoginPage;
import com.shoppersStack.pom.WelcomePage;

public class BaseTest {

	public WebDriver driver;
	public static WebDriver listenersDriver;
	public FileUtility file = new FileUtility();
	public WebdriverUtility webdriverUtil = new WebdriverUtility();
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public ExtentTest test;
	public JavaUtility java = new JavaUtility();
	public HomePage homePage;

	@BeforeSuite
	public void bs() {
		System.out.println("BeforeSuite");
//		spark=new ExtentSparkReporter("./Reports/"+java.localDateTime()+".html");
	}

	@BeforeTest
	public void bt() {
		System.out.println("BeforeTest");
//		report=new ExtentReports();
//		report.attachReporter(spark);
//		test = report.createTest("Demo");
	}

	@BeforeClass
	public void bc() throws IOException {
//		String url = file.readPropertyData("url");
//		
//		String browser = file.readPropertyData("browser");

		
		String url = System.getProperty("url");

		String browser = System.getProperty("browser");

		System.out.println("BeforeClass");

		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			System.out.println(" Enter Valid Browser Name ");
		}
		listenersDriver = driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get(url);
		homePage = new HomePage(driver);
	}

	@BeforeMethod
	public void bm() throws IOException {
		System.out.println("BeforeMethod");
//		test.log(Status.INFO, "Navigated");
		WelcomePage welcomePage = new WelcomePage(driver);
		welcomePage.getLoginButton().click();
//		test.log(Status.INFO, "In login page");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.getEmailTf().sendKeys(file.readPropertyData("username"));
		loginPage.getPwtTf().sendKeys(file.readPropertyData("password"));
		loginPage.getLoginButton().click();
//		test.log(Status.INFO, "In home page");
	}

	@AfterMethod
	public void am() {
		System.out.println("AfterMethod");

		homePage.getAccountBtn().click();
		homePage.getLogOutBtn().click();
//		test.log(Status.INFO, "Logout");

	}

	@AfterClass
	public void ac() throws InterruptedException {
		System.out.println("AfterClass");
		Thread.sleep(3000);
		driver.quit();
	}

	@AfterTest
	public void at() {
		System.out.println("AfterTest");
//		report.flush();
	}

	@AfterSuite
	public void as() {
		System.out.println("AfterSuite");
	}

}
