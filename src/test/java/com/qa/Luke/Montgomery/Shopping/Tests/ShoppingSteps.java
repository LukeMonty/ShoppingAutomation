package com.qa.Luke.Montgomery.Shopping.Tests;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.Luke.Montgomery.Main.Constants;
import com.qa.Luke.Montgomery.Shopping.Tests.*;
import com.qa.Luke.Montgomery.Shopping.Pages.*;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ShoppingSteps {

	WebDriver driver;

	ExtentTest test;

	String url = "http://automationpractice.com/index.php";

	HomePage home;
	SignInPage signUp;
	CreateProfilePage createProfile;
	MyAccountPage accountPage;

	String fNameToCheck = "";
	String lNameToCheck = "";

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", Constants.DRIVER_FILEPATH);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		test = ShoppingTests.report.startTest("Sign a user up to the shopping website");
		test.log(LogStatus.INFO, "Go to Website");
	}

	@After
	public void tearDown() {
		driver.quit();
		ShoppingTests.report.endTest(test);
	}

	@Given("^that I am on the sign up page$")
	public void that_I_am_on_the_sign_up_page() throws Throwable {
		driver.get(url);
		home = PageFactory.initElements(driver, HomePage.class);
		home.goToSignIn();
		test.log(LogStatus.INFO, "Go to sign in page");

	}

	@When("^put my email \"([^\"]*)\"$")
	public void put_my_email(String arg1) throws Throwable {
		signUp = PageFactory.initElements(driver, SignInPage.class);

		signUp.beginCreatingAccount(arg1);
		test.log(LogStatus.INFO, "Entered email");

	}

	@When("^then I input \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void then_I_input(String title, String firstName, String lastName, String password, String dob,
			String address, String city, String state, String zipCode, String phone) {
		createProfile = PageFactory.initElements(driver, CreateProfilePage.class);

		fNameToCheck = firstName;
		lNameToCheck = lastName;

		String[] dateOfBirth = dob.split(" ");
		String day = dateOfBirth[0];
		String month = dateOfBirth[1];
		String year = dateOfBirth[2];
		createProfile.inputDetails(driver, title, firstName, lastName, password, day, month, year, address, city, state,
				zipCode, phone);

		test.log(LogStatus.INFO, "Inputted details");

	}

	@Then("^I will create my profile$")
	public void i_will_create_my_profile() {

		accountPage = PageFactory.initElements(driver, MyAccountPage.class);
		if (!accountPage.checkSignedIn(fNameToCheck + " " + lNameToCheck)) {
			test.log(LogStatus.FAIL, "FAIL: Create User failed");
		} else {
			test.log(LogStatus.PASS, "Success: Created User");
			assertTrue(accountPage.checkSignedIn(fNameToCheck + " " + lNameToCheck));
		}

	}

}
