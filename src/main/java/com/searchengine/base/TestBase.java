package com.searchengine.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.searchengine.browsers.Browsers;
import com.searchengine.searchengines.SearchEngines;
import com.serachengine.proxydriver.ProxyDriver;

public class TestBase {

	public static WebDriver wd;
	private final Browsers DEFAULT_BROWSER = Browsers.CHROME;
	private  String searchEngine = SearchEngines.YAHOO.getSearchEngine();
	

	
	public void initialisation() {

		switch (DEFAULT_BROWSER) {
		case CHROME:
			wd = new ProxyDriver(new ChromeDriver());
			break;
		case EDGE:
			wd = new ProxyDriver(new EdgeDriver());
			break;
		case FIREFOX:
			wd = new ProxyDriver(new FirefoxDriver());
			break;
		default:
			throw new IllegalArgumentException();
		}
		
		wd.get(searchEngine);
		
		wd.manage().window().maximize();
		

	}
	
	@AfterMethod
	public void tearDown() {
		wd.quit();
	}

}
