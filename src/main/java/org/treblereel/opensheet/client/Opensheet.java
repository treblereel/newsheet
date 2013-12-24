package org.treblereel.opensheet.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Opensheet implements EntryPoint {
  
	
  public void onModuleLoad() {
   
	  
    RootPanel.get("errorLabelContainer").add(new Button());

  }
}
