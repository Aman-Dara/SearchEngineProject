package com.searchengine.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.searchengine.base.TestBase;
import com.serachengine.proxydriver.ProxyDriver;

public class YahooHomePage extends TestBase{
	
	private static final By searchPlaceholder = By.cssSelector("#ybar-sbq");
	private static final By firstReturnItem = By.cssSelector("#main>div>ol>li:nth-of-type(2)>div>div:nth-of-type(2)>div>a>h3>span");
	
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
