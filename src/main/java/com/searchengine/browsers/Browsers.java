package com.searchengine.browsers;

public enum Browsers {
	
	CHROME("chrome"),
	EDGE("edge"),
	FIREFOX("firefox");
	
	private String browser;
	
	Browsers(String browser){
		this.browser = browser;
	}
	
	public String getBrowser() {
		return browser;
	}

}
