package com.james.VaadinStocks.util;

import java.util.List;

import com.james.VaadinStocks.ViewModels.Stock;
import com.james.VaadinStocks.fauxDB.FauxDbContext;

public class DashboardController {

	private FauxDbContext db;
	
	public DashboardController() {
		db = new FauxDbContext();
	}
	
	public Stock SaveStockToWatchlist(Stock stock) {
		db.getWatchlist().add(stock);
		
		// update values for stock here to display on watchlist.
		
		return stock;
	}
	
	public boolean RemoveStockFromWatchlist(Stock stock){
		boolean isDeleted = false;
		
		isDeleted = db.getWatchlist().remove(stock);
		
		return isDeleted;
	}
	
	public List<Stock> getWatchlist(){
		return db.getWatchlist();
	}
	
	
}
