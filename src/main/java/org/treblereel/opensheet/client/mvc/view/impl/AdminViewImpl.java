package org.treblereel.opensheet.client.mvc.view.impl;

import org.treblereel.opensheet.client.mvc.view.AdminView;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class AdminViewImpl extends Composite implements AdminView {
	private AdminPresenter presenter;
	private Button button;

	public AdminViewImpl(){
		button = new Button("AdminViewImpl");
		initWidget(button);
	}
	
	@Override
	public void setPresenter(AdminPresenter presenter) {
		this.presenter = presenter;
	}

	public Widget asWidget() {
		return this;
	}

}
