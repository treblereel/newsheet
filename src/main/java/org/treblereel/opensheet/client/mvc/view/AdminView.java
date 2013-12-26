package org.treblereel.opensheet.client.mvc.view;

import com.google.gwt.user.client.ui.IsWidget;

public interface AdminView extends IsWidget {
	public void setPresenter(AdminPresenter presenter);
	
	public interface AdminPresenter {
	}
}
