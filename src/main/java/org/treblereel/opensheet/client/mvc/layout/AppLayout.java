package org.treblereel.opensheet.client.mvc.layout;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.event.SelectEvent;

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
	
	@UiHandler("adminButton")
	public void onAdminButtonClick(SelectEvent event){
		Window.Location.assign(calculateUrl("admin"));
	}
	
	@UiHandler("timesheetButton")
	public void onTimesheetButtonClick(SelectEvent event){
		Window.Location.assign(calculateUrl("timesheet"));
	}

	private String calculateUrl(String location) {
		return Window.Location.getHref().split("#")[0] + "#"+location+":";
	}
}
