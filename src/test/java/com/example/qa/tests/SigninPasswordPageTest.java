package com.example.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.qa.base.TestBase;
import com.example.qa.pages.HomePage;
import com.example.qa.pages.SigninEmailPage;
import com.example.qa.pages.SigninPasswordPage;
import com.example.qa.util.TestUtil;

public class SigninPasswordPageTest extends TestBase{

	HomePage homePage;
	SigninEmailPage signinEmailPage;
	SigninPasswordPage signinPasswordPage;
	
	String sheetName = "accounts";
	
	public SigninPasswordPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		homePage = new HomePage();
		signinEmailPage = homePage.clickSignIn();
	}
	
	@DataProvider(name="testData")
	public Object[][] getAccountsTestData(){
		Object[][] testData = TestUtil.getTestData(sheetName);
		return testData;
	}

	@Test(priority=1, dataProvider="testData")
	public void signinPasswordPageTitleTest(String email, String password, String searchTerm){
		signinEmailPage.writeEmail(email);
		signinPasswordPage = signinEmailPage.clickNext();
		
		String title = signinPasswordPage.validateSigninPageTitle();
		Assert.assertEquals(title, "Gmail");
	}

	@Test(priority=2, dataProvider="testData")
	public void writePasswordTest(String email, String password, String searchTerm){
		signinEmailPage.writeEmail(email);
		signinPasswordPage = signinEmailPage.clickNext();
		
		signinPasswordPage.writePassword(password);
		signinPasswordPage.clickNext();
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
