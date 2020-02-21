package com.james.VaadinStocks;

import java.util.Collections;
import java.util.List;

import com.james.VaadinStocks.TestData.AllStocks;
import com.james.VaadinStocks.TestData.TestStocks;
import com.james.VaadinStocks.ViewModels.Stock;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;


@Route(value = "home", layout = MainAppLayout.class)
public class DashBoard extends VerticalLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1738386035616772502L;
	private TextField filterText;
	private Grid<Stock> watchList;
	private Grid<Stock> addToWatchList;
	private AllStocks allStocks = AllStocks.getInstance();
	
	public DashBoard() {
		super();
		filterText = new TextField();
		watchList = new Grid<>();
		addToWatchList = new Grid<>();
				
		add(new Text("Welcome to your watchlist"));
				
		List<Stock> stockList = TestStocks.getTestStocks();
		Collections.sort(stockList);
		
		watchList.setItems(stockList);
		
		watchList.addColumn(Stock::getTicker).setHeader("Ticker");
		watchList.addColumn(Stock::getCurrentPrice).setHeader("Price");
		watchList.addColumn(Stock::getCurrentPercentage).setHeader("Percentage");
		add(watchList);
				
		add(new Text("Add Stocks to watchlist"));

		filterText.setPlaceholder("Search for stocks to add....");
		filterText.setClearButtonVisible(true);
		filterText.setValueChangeMode(ValueChangeMode.EAGER);
		filterText.addValueChangeListener(e -> updateList());
		
		addToWatchList.addColumn(Stock::getLongName).setHeader("Company");
		addToWatchList.addColumn(Stock::getTicker).setHeader("Ticker");
		
		
		//TODO:
		//add grid with filtertext
		
		//setSizeFull();
		
		//updateList();
		//END TODO:
		
	}
	
	public void updateList() {
		addToWatchList.setItems(allStocks.find(filterText.getValue()));
	}

}
