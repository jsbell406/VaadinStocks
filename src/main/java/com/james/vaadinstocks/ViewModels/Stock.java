package com.james.VaadinStocks.ViewModels;

public class Stock implements Comparable<Stock> {
	
	private int id;
	private String ticker;
	private String longName;
	private double currentPrice;
	private double currentPercentage;
	
	public Stock() {}
	
	public Stock(String ticker, String longName) {
		super();
		this.ticker = ticker;
		this.longName = longName;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}

	public double getCurrentPercentage() {
		return currentPercentage;
	}

	public void setCurrentPercentage(double currentPercentage) {
		this.currentPercentage = currentPercentage;
	}

	public String getTicker() {
		return ticker;
	}

	public String getLongName() {
		return longName;
	}

	@Override
	public int compareTo(Stock o) {
		// TODO Auto-generated method stub
		return -Double.valueOf(currentPercentage).compareTo(o.getCurrentPercentage());
	}
	
	
	

}
