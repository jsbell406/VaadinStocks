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
		List<Stock> searchList = TestStocks.getAllStocks();
	
		
		filteredList.clear();
	
		if(search.isBlank())
			return filteredList;
		
		searchList.forEach(s -> {
			if(s.getLongName().toUpperCase().contains(search.toUpperCase()) | s.getTicker().toUpperCase().contains(search.toUpperCase())) 
				filteredList.add(s);		
		});		
		return filteredList;		
	}
	
}
