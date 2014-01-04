package org.treblereel.opensheet.shared.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SheetDTO extends TreeNodeDTO {

	private static final long serialVersionUID = 8878936568544440160L;
	private List<SheetDTO> children = new ArrayList<SheetDTO>();
	private Map<Integer,SheetHourDTO> hours = new HashMap<Integer,SheetHourDTO>();
	private String type;
	private SheetDTO parent;
	
	
	public SheetDTO() {

	}

	public List<SheetDTO> getChildren() {
		return children;
	}

	public void setChildren(List<SheetDTO> children) {
		this.children = children;
	}

	public void addChild(SheetDTO child) {
		getChildren().add(child);
	}

	public Map<Integer,SheetHourDTO> getHours() {
		return hours;
	}

	public void setHours(Map<Integer,SheetHourDTO> hours) {
		this.hours = hours;
	}
	
	public void setHour(Integer day,SheetHourDTO hour) {
		getHours().put(day, hour);
	}
	
	public SheetHourDTO getHour(Integer day){
		if(getHours().containsKey(day)){
			return getHours().get(day);
		}else{
			return new SheetHourDTO();
		}
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public SheetDTO getParent() {
		return parent;
	}

	public void setParent(SheetDTO parent) {
		this.parent = parent;
	}
	

}
