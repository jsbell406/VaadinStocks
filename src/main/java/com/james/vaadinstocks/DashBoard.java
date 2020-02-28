package com.james.VaadinStocks;

import java.util.Collections;
import java.util.List;

import com.james.VaadinStocks.TestData.AllStocks;
import com.james.VaadinStocks.TestData.TestStocks;
import com.james.VaadinStocks.ViewModels.Stock;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.NativeButton;
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
		
		//watchList.setFindAllOperation(() -> TestStocks.getTestStocks());
		
		
		
		watchList.addColumn(Stock::getTicker).setHeader("Ticker");
		watchList.addColumn(Stock::getCurrentPrice).setHeader("Price");
		watchList.addColumn(Stock::getCurrentPercentage).setHeader("Percentage");
		watchList.addComponentColumn(this::buildRemoveFromWatchlistButton);
		
		watchList.setItems(stockList);
		
		add(watchList);
				
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
	
	private Button buildRemoveFromWatchlistButton(Stock stock)
	{
		Button button = new Button(new Icon(VaadinIcon.MINUS));
		
		button.addClickListener(b -> removeStockFromWatchlist(stock));
		
		return button;
	}
	
	private Button buildAddToWatchlistButton(Stock stock)
	{
		Button button = new Button(new Icon(VaadinIcon.PLUS));
		
		button.addClickListener(b -> addStockToWatchlist(stock));
		
		return button;
	}
	
	private void removeStockFromWatchlist(Stock stock)
	{    
		boolean isRemove = false;
	
		Dialog dialog = new Dialog();
		dialog.setCloseOnEsc(false);
		dialog.setCloseOnOutsideClick(false);
		
		NativeButton confirmButton = new NativeButton("Confirm", event -> {
			//isRemove = true;
		    dialog.close();
		});
		NativeButton cancelButton = new NativeButton("Cancel", event -> {
		   // isRemove = false;
		    dialog.close();
		    });
		
		dialog.add("Remove " + stock.getLongName());
		dialog.add(confirmButton, cancelButton);
		
		dialog.open();
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
