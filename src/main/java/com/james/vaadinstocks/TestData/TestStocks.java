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
	
	
}
