package org.treblereel.opensheet.client;

import org.treblereel.opensheet.client.mvc.factory.ClientMvcFactory;
import org.treblereel.opensheet.client.mvc.layout.AppLayout;
import org.treblereel.opensheet.client.mvc.mapper.AppActivityMapper;
import org.treblereel.opensheet.client.mvc.mapper.AppPlaceHistoryMapper;
import org.treblereel.opensheet.client.mvc.place.TimesheetPlace;

import com.google.web.bindery.event.shared.EventBus;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.container.Container;

public class Opensheet implements EntryPoint {
	private SimplePanel containerWidget;
	private TimesheetPlace defaultPlace = new TimesheetPlace();

	public void onModuleLoad() {
		final AppLayout mainLayout = new AppLayout();
		containerWidget = mainLayout.getAppContentHolder();

		final ClientMvcFactory clientFactory = GWT
				.create(ClientMvcFactory.class);
		EventBus eventBus = clientFactory.getEventBus();
		PlaceController placeController = clientFactory.getPlaceController();

		// activate activity manager and init display
		ActivityMapper activityMapper = new AppActivityMapper(clientFactory);
		ActivityManager activityManager = new ActivityManager(activityMapper,
				eventBus);
		activityManager.setDisplay(containerWidget);

		// display default view with activated history processing
		AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
		historyHandler.register(placeController, eventBus, defaultPlace);

		RootLayoutPanel.get().add(mainLayout);

		History.newItem("timesheet:");

	}
}
