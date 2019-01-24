package com.qa.Luke.Montgomery.Shopping.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage {
	@FindBy(xpath = "//*[@id=\"SubmitCreate\"]/span")
	private WebElement createUserButton;
	
	@FindBy(id = "email_create")
	private WebElement createUserEmail;
	
	public void beginCreatingAccount(String email) {
		createUserEmail.sendKeys(email);
		
		createUserButton.click();
	}
}
