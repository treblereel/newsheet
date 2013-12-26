package org.treblereel.opensheet.client.mvc.layout;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class AppLayout extends Composite {

	private static AppLayoutUiBinder uiBinder = GWT
			.create(AppLayoutUiBinder.class);
	@UiField
	SimplePanel appContent;

	interface AppLayoutUiBinder extends UiBinder<Widget, AppLayout> {
	}

	public AppLayout() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public SimplePanel getAppContentHolder() {
		return this.appContent;
	}

}
