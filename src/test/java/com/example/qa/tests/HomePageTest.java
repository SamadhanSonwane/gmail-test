package com.example.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.example.qa.base.TestBase;
import com.example.qa.pages.HomePage;
import com.example.qa.pages.SigninEmailPage;

public class HomePageTest extends TestBase{
	
	HomePage homePage;
	SigninEmailPage signinEmailpage;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		homePage = new HomePage();
	}
	
	@Test(priority=1)
	public void homePageTitleTest(){
		String title = homePage.validateHomePageTitle();
		Assert.assertEquals(title, "Gmail - Free Storage and Email from Google");
	}
	
	@Test(priority=2)
	public void clickSignInTest(){
		signinEmailpage = homePage.clickSignIn();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
