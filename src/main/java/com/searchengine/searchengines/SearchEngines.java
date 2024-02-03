package com.searchengine.searchengines;

public enum SearchEngines {
	
	GOOGLE("https://www.google.ca/"),
	YAHOO("https://ca.yahoo.com/"),
	BING("https://www.bing.com/");
	
	private String searchEngine;
	
	 SearchEngines(String searchEngine){
		this.searchEngine = searchEngine;
	}
	public String getSearchEngine() {
		return searchEngine;
	}
	
	

}
