package com.james.VaadinStocks;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "Testing", layout = MainAppLayout.class)
public class Testing extends VerticalLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2188094981826207200L;

	public Testing() {
		super();
		
		Button button = new Button(new Icon(VaadinIcon.PLUS));
		Icon icon = new Icon(VaadinIcon.PLUS);
	
		
		
		icon.setColor("#2464c9");
		
		add(button, icon);
	}

}
