package org.treblereel.opensheet.client.mvc.mapper;

import org.treblereel.opensheet.client.mvc.place.AdminPlace;
import org.treblereel.opensheet.client.mvc.place.TimesheetPlace;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;


@WithTokenizers({TimesheetPlace.Tokenizer.class, AdminPlace.Tokenizer.class})
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {
}

