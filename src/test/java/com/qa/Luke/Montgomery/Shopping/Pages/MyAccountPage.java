package com.qa.Luke.Montgomery.Shopping.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage {
	
	@FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
	private WebElement myAccountButton;
	
	public boolean checkSignedIn(String arg) {
		return myAccountButton.getText().contains(arg);
	}

}
