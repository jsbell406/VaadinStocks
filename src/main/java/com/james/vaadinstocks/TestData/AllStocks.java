package com.james.VaadinStocks.TestData;

import java.util.ArrayList;
import java.util.List;

import com.james.VaadinStocks.ViewModels.Stock;

public class AllStocks {

	private static AllStocks allStocks;
	
	private AllStocks() {}
	
	public static synchronized AllStocks getInstance() {
		if(allStocks == null) {
			allStocks = new AllStocks();
		}
		return allStocks;
	}
	
	public List<Stock> find(String search){
		List<Stock> filteredList = new ArrayList<>();
		List<Stock> searchList = new ArrayList<>();
		
		//TODO:
		
		//populate searchList with stocks
		//populate filteredList using search string
		//have search logic search both company name and ticker. 
		//	have logic return results that contains even a portion of the search string.
		
		filteredList.clear();
		// first search logic attempt..... NOT TESTED
		searchList.forEach(s -> {
			if(s.getLongName().contains(search) | s.getTicker().contains(search))
				filteredList.add(s);		
		});		
		return filteredList;		
	}
	
}
