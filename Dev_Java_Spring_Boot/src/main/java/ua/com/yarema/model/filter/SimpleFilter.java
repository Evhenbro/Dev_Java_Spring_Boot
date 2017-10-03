package ua.com.yarema.model.filter;

import java.util.regex.Pattern;

public class SimpleFilter {
	
	private static final Pattern SEARCH_TIME = Pattern.compile("^([0-2][0-3]:[0-5][0-9])|(0{1}[0-9]:[0-5][0-9])|(1{1}[0-9]:[0-5][0-9])$");
	
	private String search = "";
	
	private String searchTime = "";

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getSearchTime() {
		return searchTime;
	}

	public void setSearchTime(String searchTime) {
		if (SEARCH_TIME.matcher(searchTime).matches())
		this.searchTime = searchTime;
	}
	
}
