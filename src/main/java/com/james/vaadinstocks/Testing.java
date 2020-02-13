package com.james.VaadinStocks;

import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class Testing extends VerticalLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2188094981826207200L;

	public Testing() {
		super();
		Checkbox checkbox = new Checkbox();
		checkbox.setLabel("Default Checkbox");
		add(checkbox);
	}

}
