package com.james.VaadinStocks;

import java.util.Collections;
import java.util.List;

import com.james.VaadinStocks.TestData.AllStocks;
import com.james.VaadinStocks.TestData.TestStocks;
import com.james.VaadinStocks.ViewModels.Stock;
import com.james.VaadinStocks.util.DashboardController;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;


@Route(value = "Dashboard", layout = MainAppLayout.class)
public class DashBoard extends VerticalLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1738386035616772502L;
	private TextField filterText;
	private Grid<Stock> watchlist;
	private Grid<Stock> addToWatchList;
	private AllStocks allStocks = AllStocks.getInstance();
	private DashboardController db;
	

	public DashBoard() {
		super();
		
		db = new DashboardController();
		
		filterText = new TextField();
		
		buildWatchlist();
		
		addToWatchList = new Grid<>();
				
		add(new Text("Welcome to your watchlist"));
				
		List<Stock> stockList = TestStocks.getTestStocks();
		Collections.sort(stockList);
		
		//watchList.setFindAllOperation(() -> TestStocks.getTestStocks());
		
		
		
		
		
		//watchList.setItems(stockList);
		
		//add(watchList);
				
		add(new Text("Add Stocks to watchlist"));

		filterText.setPlaceholder("Search for stocks to add....");
		filterText.setClearButtonVisible(true);
		filterText.setValueChangeMode(ValueChangeMode.EAGER);
		filterText.addValueChangeListener(e -> updateList());
		
		addToWatchList.addColumn(Stock::getLongName).setHeader("Company");
		addToWatchList.addColumn(Stock::getTicker).setHeader("Ticker");
		addToWatchList.addComponentColumn(this::buildAddToWatchlistButton);
		
		add(filterText,addToWatchList);
		
		setSizeFull();
		
		updateList();
				
	}
	
	private void populateWatchlist()
	{
		
	}
	
	private void buildWatchlist(){
		watchlist = new Grid<>();
		
		watchlist.addColumn(Stock::getTicker).setHeader("Ticker");
		watchlist.addColumn(Stock::getCurrentPrice).setHeader("Price");
		watchlist.addColumn(Stock::getCurrentPercentage).setHeader("Percentage");
		watchlist.addComponentColumn(this::buildRemoveFromWatchlistButton);	
		
		add(watchlist);
		
	}
	private Button buildRemoveFromWatchlistButton(Stock stock)
	{
		Button button = new Button(new Icon(VaadinIcon.MINUS));
		
		button.addClickListener(b -> confirmRemoveStockFromWatchlist(stock));
		
		return button;
	}
	
	private Button buildAddToWatchlistButton(Stock stock)
	{
		Button button = new Button(new Icon(VaadinIcon.PLUS));
		
		button.addClickListener(b -> addStockToWatchlist(stock));
		
		return button;
	}
	
	private void confirmRemoveStockFromWatchlist(Stock stock)
	{    
		Div div = new Div();
		
	
		Dialog dialog = new Dialog();
		dialog.setCloseOnEsc(false);
		dialog.setCloseOnOutsideClick(false);
		
		div.add("Remove " + stock.getLongName());
		
		Button confirmButton = new Button("Confirm", event  -> {
			removeStock(stock);
			
		    dialog.close();
		});
		Button cancelButton = new Button("Cancel", event -> {
		   
		    dialog.close();
		    });
		
		
		dialog.add(div);
		dialog.add(confirmButton, cancelButton);
		
		dialog.open();
	}
	
	private void removeStock(Stock stock)
	{
		Dialog d = new Dialog();
		
		d.add(stock.getLongName() + " removed");
		
		d.open();
	}
	private void addStockToWatchlist(Stock stock) {
		Dialog dialog = new Dialog();
		dialog.add(stock.getLongName());
		
		dialog.open();
	}
	
	public void updateList() {
		addToWatchList.setItems(allStocks.find(filterText.getValue()));
	}

}
