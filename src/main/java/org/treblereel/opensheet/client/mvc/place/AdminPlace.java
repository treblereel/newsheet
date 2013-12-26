package org.treblereel.opensheet.client.mvc.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class AdminPlace extends Place {
	private static final String VIEW_HISTORY_TOKEN = "admin";
	
	public AdminPlace() { }
	
	@Prefix(value = VIEW_HISTORY_TOKEN)
	public static class Tokenizer implements PlaceTokenizer<AdminPlace> {
		@Override
		public AdminPlace getPlace(String token) {
			return new AdminPlace();
		}

		@Override
		public String getToken(AdminPlace place) {
			return "";
		}
	}
}
