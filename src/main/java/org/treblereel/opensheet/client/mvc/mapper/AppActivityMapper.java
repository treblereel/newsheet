package org.treblereel.opensheet.client.mvc.mapper;

import org.treblereel.opensheet.client.mvc.activity.AdminActivity;
import org.treblereel.opensheet.client.mvc.activity.TimesheetActivity;
import org.treblereel.opensheet.client.mvc.factory.ClientMvcFactory;
import org.treblereel.opensheet.client.mvc.place.AdminPlace;
import org.treblereel.opensheet.client.mvc.place.TimesheetPlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;


public class AppActivityMapper implements ActivityMapper {
	private ClientMvcFactory clientFactory;
	
	public AppActivityMapper(ClientMvcFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
	}
	
	@Override
	public Activity getActivity(Place place) {
		if (place instanceof TimesheetPlace) {
			return new TimesheetActivity(clientFactory);
		} else if (place instanceof AdminPlace) {
			return new AdminActivity(clientFactory);
		} 
		return null;
	}
}