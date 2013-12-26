package org.treblereel.opensheet.client.mvc.view;

import com.google.gwt.user.client.ui.IsWidget;

public interface TimesheetView extends IsWidget {
	public void setPresenter(TimesheetPresenter presenter);
	
	public interface TimesheetPresenter {
	}
}
