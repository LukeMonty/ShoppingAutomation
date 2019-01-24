package com.qa.Luke.Montgomery.Shopping.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateProfilePage {

	@FindBy(id = "id_gender1")
	private WebElement genderRadioButtonMr;

	@FindBy(id = "id_gender2")
	private WebElement genderRadioButtonMrs;

	@FindBy(id = "customer_firstname")
	private WebElement firstNameInput;

	@FindBy(id = "customer_lastname")
	private WebElement lastNameInput;

	@FindBy(id = "passwd")
	private WebElement passwordInput;

	@FindBy(id = "days")
	private WebElement daysDropDown;

	@FindBy(id = "months")
	private WebElement monthsDropDown;

	@FindBy(id = "years")
	private WebElement yearsDropDown;

	@FindBy(id = "address1")
	private WebElement addressInput;

	@FindBy(id = "city")
	private WebElement cityInput;

	@FindBy(id = "id_state")
	private WebElement stateDropDown;

	@FindBy(id = "postcode")
	private WebElement postcodeInput;

	@FindBy(id = "phone_mobile")
	private WebElement phoneInput;

	@FindBy(xpath = "//*[@id=\"submitAccount\"]/span")
	private WebElement registerButton;

	public void inputDetails(WebDriver driver, String gender, String firstName, String lastName, String password, String dropDownDay,
			String dropDownMonth, String dropDropYear, String address, String city, String state, String postcode,
			String phone) {
		
		genderRadioButtonMr = new WebDriverWait(driver, 10).until(
				ExpectedConditions.presenceOfElementLocated(By.id("id_gender1")));
		
		
		if (gender.equals("Mr.")) {
			genderRadioButtonMr.click();
		} else {
			genderRadioButtonMrs.click();
		}

		firstNameInput.sendKeys(firstName);
		lastNameInput.sendKeys(lastName);
		passwordInput.sendKeys(password);
		daysDropDown.sendKeys(dropDownDay);
		monthsDropDown.sendKeys(dropDownMonth);
		yearsDropDown.sendKeys(dropDropYear);
		addressInput.sendKeys(address);
		cityInput.sendKeys(city);
		stateDropDown.sendKeys(state);
		postcodeInput.sendKeys(postcode);
		phoneInput.sendKeys(phone);
		
		registerButton.click();
	}

}
