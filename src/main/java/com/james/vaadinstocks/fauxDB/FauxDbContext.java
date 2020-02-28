package com.james.VaadinStocks.fauxDB;

import java.util.ArrayList;
import java.util.List;

import com.james.VaadinStocks.TestData.TestStocks;
import com.james.VaadinStocks.ViewModels.Stock;

public class FauxDbContext {

	private List<Stock> userWatchlist;
	private List<Stock> allStocks;
	
	
	public FauxDbContext()
	{
		userWatchlist = new ArrayList<Stock>();
		allStocks = TestStocks.getAllStocks();
	}
	
	public List<Stock> getWatchlist()
	{
		return userWatchlist;
	}
	
}
