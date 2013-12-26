package org.treblereel.opensheet.client.mvc.activity;

import java.util.LinkedHashMap;
import java.util.Map;

import org.treblereel.opensheet.client.AppConstants;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;

public abstract class AbstractMainActivity extends AbstractActivity {
	private static Map<String, Element> navLinks = new LinkedHashMap<String, Element>();
	static {
		navLinks.put(AppConstants.TIMESHEET_LINK_ID, DOM.getElementById(AppConstants.TIMESHEET_LINK_ID));
		navLinks.put(AppConstants.ADMIN_LINK_ID, DOM.getElementById(AppConstants.ADMIN_LINK_ID));
	}
	
	public void applyCurrentLinkStyle(String viewId) {
		for (String linkId : navLinks.keySet()) {
			final Element link = navLinks.get(linkId);
			if (link == null) continue;
			if (linkId.equals(viewId)) {
				link.addClassName("b-current");
			} else {
				link.removeClassName("b-current");
			}
		}
	}
}
