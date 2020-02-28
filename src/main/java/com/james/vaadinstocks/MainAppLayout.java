package com.james.VaadinStocks;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route("")
public class MainAppLayout extends AppLayout{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3615594340414875949L;
	
	public MainAppLayout() {
		super();
		
		//Image img = new Image("D:\\Repos\\VaadinStocks\\Images\\dollar-currency-money-us-dollar-47344.jpeg","Money");
		//img.setHeight("44px");
		
		addToNavbar(new DrawerToggle());
		
		VerticalLayout vlDrawer = new VerticalLayout();
		vlDrawer.add(new RouterLink("Dashboard", DashBoard.class));
		vlDrawer.add(new RouterLink("Testing", Testing.class) );
		
		addToDrawer(vlDrawer);
		
		
		
		
		
	}

}
