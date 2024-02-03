package com.searchengine.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.searchengine.base.TestBase;
import com.serachengine.proxydriver.ProxyDriver;

public class GoogleHomePage extends TestBase{
	
	private static final By searchPlaceholder = By.cssSelector("#APjFqb");
	private static final By firstReturnItem = By.xpath("//span[text()='Qatar Airways Official Website - Book on the Official Website']");
	
	public void searchItem(String searchData) {
		((ProxyDriver) wd).sendKeys(searchPlaceholder, searchData + Keys.ENTER);
		
	}
	
	public String getText() {
		return ((ProxyDriver) wd).getText(firstReturnItem);
	}

	public String actualResult() {
		return getText();
	}
	
	
	


}
