package org.treblereel.opensheet.client.mvc.factory;

import org.treblereel.opensheet.client.mvc.view.AdminView;
import org.treblereel.opensheet.client.mvc.view.TimesheetView;

import com.google.web.bindery.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;


public interface ClientMvcFactory {
	public EventBus getEventBus();
	public PlaceController getPlaceController();
	
	public TimesheetView getTimesheetView();
	public AdminView getAdminView();
}
