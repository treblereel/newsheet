package org.treblereel.opensheet.client.mvc.activity;

import org.treblereel.opensheet.client.AppConstants;
import org.treblereel.opensheet.client.mvc.factory.ClientMvcFactory;
import org.treblereel.opensheet.client.mvc.view.AdminView;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;


public class AdminActivity extends AbstractMainActivity implements AdminView.AdminPresenter {
	private ClientMvcFactory clientFactory;
	
	public AdminActivity(ClientMvcFactory clientFactory) {
		this.clientFactory = clientFactory;
	}
	
	@Override
	public void start(AcceptsOneWidget container, EventBus eventBus) {
		applyCurrentLinkStyle(AppConstants.ADMIN_LINK_ID);
		
		final AdminView view = clientFactory.getAdminView();
		view.setPresenter(this);
		container.setWidget(view.asWidget());
	}
}
