package com.example.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.qa.base.TestBase;
import com.example.qa.pages.HomePage;
import com.example.qa.pages.SigninEmailPage;
import com.example.qa.util.TestUtil;

public class SigninEmailPageTest extends TestBase{
	
	HomePage homePage;
	SigninEmailPage signinEmailPage;
	
	String sheetName = "accounts";
	
	public SigninEmailPageTest(){
		super();
	}

	@BeforeMethod
	public void setUp(){
		initialization();
		homePage = new HomePage();
		signinEmailPage = homePage.clickSignIn();
	}
	
	@Test(priority=1)
	public void signinEmailPageTitleTest(){
		String title = signinEmailPage.validateSigninPageTitle();
		Assert.assertEquals(title, "Gmail");
	}
	
	@DataProvider(name="testData")
	public Object[][] getAccountsTestData(){
		Object[][] testData = TestUtil.getTestData(sheetName);
		return testData;
	}

	@Test(priority=2, dataProvider="testData")
	public void writeEmailTest(String email, String password, String searchTerm){
		signinEmailPage.writeEmail(email);
		signinEmailPage.clickNext();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
