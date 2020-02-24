package com.james.VaadinStocks.TestData;

import java.util.ArrayList;
import java.util.List;

import com.james.VaadinStocks.ViewModels.Stock;

public class TestStocks {

	public static List<Stock> getTestStocks(){
		List<Stock> stocks = new ArrayList<>();
		
		Stock s1 = new Stock("TSLA", "Tesla Motors");
		s1.setId(1);
		s1.setCurrentPrice(805.50);
		s1.setCurrentPercentage(15.5);
		stocks.add(s1);
		
		Stock s2 = new Stock("TTWO", "Take-Two Interactice Software");
		s2.setId(2);
		s2.setCurrentPrice(115.13);
		s2.setCurrentPercentage(-0.5);
		stocks.add(s2);
		
		Stock s3 = new Stock("BA", "The Boeing Company");
		s3.setId(3);
		s3.setCurrentPrice(336.28);
		s3.setCurrentPercentage(-1.5);
		stocks.add(s3);
		
		Stock s4 = new Stock("LMT", "Lockheed Martin Corporation");
		s4.setId(4);
		s4.setCurrentPrice(425.97);
		s4.setCurrentPercentage(2.33);
		stocks.add(s4);
		
		Stock s5 = new Stock("AAPL", "Apple");
		s5.setId(5);
		s5.setCurrentPrice(320.30);
		s5.setCurrentPercentage(0.56);
		stocks.add(s5);
		
		
		
		return stocks;
	}
	
	public static List<Stock> getAllStocks(){
		List<Stock> stocks = new ArrayList<>();
		
		stocks.add(new Stock("TSLA", "Tesla Motors"));
		stocks.add(new Stock("TTWO", "Take-Two Interactice Software"));
		stocks.add(new Stock("BA", "The Boeing Company"));
		stocks.add(new Stock("LMT", "Lockheed Martin Corporation"));
		stocks.add(new Stock("AAPL", "Apple"));
		stocks.add(new Stock("AA", "Alcoa"));
		stocks.add(new Stock("ABBV", "AbbVie"));
		stocks.add(new Stock("BYND", "Beyond Meat"));
		stocks.add(new Stock("NOC", "Northrop Grumman"));
		stocks.add(new Stock("NFLX", "Netflix"));
		stocks.add(new Stock("MSFT", "Microsoft"));
		stocks.add(new Stock("NVDA", "Nvidia"));
		stocks.add(new Stock("AMZN", "Amazon"));
		stocks.add(new Stock("INTC", "Intel"));
		stocks.add(new Stock("DIS", "The Walt Disney"));
		stocks.add(new Stock("FSLR", "First Solar"));
		stocks.add(new Stock("UBER", "Uber"));
		stocks.add(new Stock("SPOT", "Spotify"));
		stocks.add(new Stock("TWTR", "Twitter"));
		stocks.add(new Stock("ONTX", "Onconova Therapeutics"));
		stocks.add(new Stock("SPCE", "Virgin Galactic"));
		
		return stocks;
	}
	
	
}
