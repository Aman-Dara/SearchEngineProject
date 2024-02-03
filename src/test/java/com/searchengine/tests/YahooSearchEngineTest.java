package com.searchengine.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.searchengine.base.TestBase;
import com.searchengine.pages.YahooHomePage;

public class YahooSearchEngineTest extends TestBase {
	
	YahooHomePage homePage;
	
	@BeforeMethod
	public void launchBrowser() {
		initialisation();
		homePage = new YahooHomePage();
	}
	@Test
	public void validateInputInSearchEngine() {
		homePage.searchItem("qatar airways");
		Assert.assertEquals(homePage.actualResult(), "Qatar Airways Official Website - Book on the Official Website",
				"Page has been loaded successfully");
		
	}
	
	@AfterMethod
	public void tearDown() {
		wd.quit();
	}

}
