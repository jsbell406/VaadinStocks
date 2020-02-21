package com.james.VaadinStocks;

import java.util.Collections;
import java.util.List;

import com.james.VaadinStocks.TestData.TestStocks;
import com.james.VaadinStocks.ViewModels.Stock;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;


@Route(value = "home", layout = MainAppLayout.class)
public class DashBoard extends VerticalLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1738386035616772502L;
	
	public DashBoard() {
		super();
		
		//add(new Text("Welcome to dashboard"));
		
		
		List<Stock> stockList = TestStocks.getTestStocks();
		Collections.sort(stockList);
		Stock stock = stockList.get(0);
		add(new Text("stock " + stock.getLongName()));
		
		Grid<Stock> grid = new Grid<>(/*Stock.class*/);
		grid.setItems(stockList);

		//grid.removeColumnByKey("id");
		
		//grid.setColumns("ticker","currentPrice","currentPercentage");
		
		
		
		grid.addColumn(Stock::getTicker).setHeader("Ticker");
		grid.addColumn(Stock::getCurrentPrice).setHeader("Price");
		grid.addColumn(Stock::getCurrentPercentage).setHeader("Percentage");
		add(grid);
		
		
		

	
		
		
		
		
//		Checkbox checkbox = new Checkbox();
//		checkbox.setLabel("Default Checkbox");
//		add(checkbox);
		
		
	}

}
