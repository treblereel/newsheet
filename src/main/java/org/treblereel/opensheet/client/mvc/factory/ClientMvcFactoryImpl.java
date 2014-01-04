package org.treblereel.opensheet.client.mvc.factory;

import org.treblereel.opensheet.client.mvc.view.AdminView;
import org.treblereel.opensheet.client.mvc.view.TimesheetView;
import org.treblereel.opensheet.client.mvc.view.impl.AdminViewImpl;
import org.treblereel.opensheet.client.mvc.view.impl.timesheet.TimesheetViewImpl;

import com.google.web.bindery.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;


public class ClientMvcFactoryImpl implements ClientMvcFactory{
	
	private final EventBus eventBus = new SimpleEventBus();
	private final PlaceController placeController = new PlaceController(eventBus);
	
	private final TimesheetView timesheetView = new TimesheetViewImpl();
	private final AdminView adminView = new AdminViewImpl();

	@Override
	public EventBus getEventBus() {
		return this.eventBus;
	}

	@Override
	public PlaceController getPlaceController() {
		return placeController;
	}

	@Override
	public TimesheetView getTimesheetView() {
		return this.timesheetView;
	}

	@Override
	public AdminView getAdminView() {
		return this.adminView;
	}

}
