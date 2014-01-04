package org.treblereel.opensheet.client.mvc.activity;

import org.treblereel.opensheet.client.AppConstants;
import org.treblereel.opensheet.client.mvc.factory.ClientMvcFactory;
import org.treblereel.opensheet.client.mvc.view.TimesheetView;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class TimesheetActivity extends AbstractMainActivity implements TimesheetView.TimesheetPresenter {
	private ClientMvcFactory clientFactory;
	
	public TimesheetActivity(ClientMvcFactory clientFactory) {
		this.clientFactory = clientFactory;
	}
	
	@Override
	public void start(AcceptsOneWidget container, EventBus eventBus) {
		applyCurrentLinkStyle(AppConstants.TIMESHEET_LINK_ID);
		final TimesheetView view = clientFactory.getTimesheetView();
		view.setPresenter(this);
		container.setWidget(view.asWidget());
	}
}
