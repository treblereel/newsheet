package org.treblereel.opensheet.client.mvc.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class TimesheetPlace extends Place {
	private static final String VIEW_HISTORY_TOKEN = "timesheet";
	
	public TimesheetPlace() { }
	
	@Prefix(value = VIEW_HISTORY_TOKEN)
	public static class Tokenizer implements PlaceTokenizer<TimesheetPlace> {
		@Override
		public TimesheetPlace getPlace(String token) {
			return new TimesheetPlace();
		}

		@Override
		public String getToken(TimesheetPlace place) {
			return "";
		}
	}
}
