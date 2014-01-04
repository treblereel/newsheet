package org.treblereel.opensheet.client.utils;

import org.treblereel.opensheet.shared.dto.SheetDTO;
import org.treblereel.opensheet.shared.dto.SheetHourDTO;

public class FakeTreeStore {
	
	
	public static SheetDTO getSheetData(){
		SheetDTO root = new SheetDTO();
		root.setId(0L);
		root.setName("root");
		
		SheetDTO element  = new SheetDTO(); 
		element.setName("P1");
		element.setId(1L);
		element.setHour(2, new SheetHourDTO(8,false,true));
		element.setHour(12, new SheetHourDTO(8,false,true));
		element.setHour(4, new SheetHourDTO(8,false,true));
		element.setHour(5, new SheetHourDTO(8,false,true));
		element.setHour(3, new SheetHourDTO(8,false,true));
		element.setHour(19, new SheetHourDTO(8,false,true));
		element.setHour(27, new SheetHourDTO(8,false,true));
		root.addChild(element);
		
		element  = new SheetDTO(); 
		element.setName("P2");
		element.setId(2L);
		element.setHour(2, new SheetHourDTO(8,false,true));
		element.setHour(12, new SheetHourDTO(8,false,true));
		element.setHour(4, new SheetHourDTO(8,false,true));
		element.setHour(5, new SheetHourDTO(8,false,true));
		element.setHour(30, new SheetHourDTO(8,false,true));
		element.setHour(19, new SheetHourDTO(8,false,true));
		element.setHour(27, new SheetHourDTO(8,false,true));
		root.addChild(element);
		
		element  = new SheetDTO(); 
		element.setName("P3");
		element.setId(3L);
		element.setHour(2, new SheetHourDTO(8,false,true));
		element.setHour(12, new SheetHourDTO(8,false,true));
		element.setHour(24, new SheetHourDTO(8,false,true));
		element.setHour(25, new SheetHourDTO(8,false,true));
		element.setHour(3, new SheetHourDTO(8,false,true));
		element.setHour(19, new SheetHourDTO(8,false,true));
		element.setHour(27, new SheetHourDTO(8,false,true));
		root.addChild(element);
		
		
		element  = new SheetDTO(); 
		element.setName("P4");
		element.setId(4L);
		element.setHour(2, new SheetHourDTO(8,false,true));
		element.setHour(12, new SheetHourDTO(8,false,true));
		element.setHour(14, new SheetHourDTO(8,false,true));
		element.setHour(15, new SheetHourDTO(8,false,true));
		element.setHour(31, new SheetHourDTO(8,false,true));
		element.setHour(29, new SheetHourDTO(8,false,true));
		element.setHour(27, new SheetHourDTO(8,false,true));
		root.addChild(element);
		
		
		return root;
	}

}
