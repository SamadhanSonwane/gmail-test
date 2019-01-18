package com.example.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.example.qa.base.TestBase;

public class HomePage extends TestBase{
	
	//Object repository
	@FindBy(xpath="//a[contains(text(), 'Sign In')]")
	WebElement signinbutton;
	
	// Initialize page objects
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle(){
		return driver.getTitle();
	}
	
	public SigninEmailPage clickSignIn(){
		signinbutton.click();
		return new SigninEmailPage();
	}

}
