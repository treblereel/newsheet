package org.treblereel.opensheet.shared.dto;

import java.io.Serializable;

public class SheetHourDTO implements Serializable {

	private static final long serialVersionUID = -3262426684147922545L;
	private Integer hour = 0;
	private Boolean isVocation = false;
	private Boolean isEditable = true;

	public SheetHourDTO() {

	}

	public SheetHourDTO(Integer hour,Boolean isVocation,Boolean isEditable) {
		this.hour = hour;
		this.isVocation = isVocation;
		this.isEditable = isEditable;
	}

	public Integer getHour() {
		return hour;
	}

	public void setHour(Integer hour) {
		this.hour = hour;
	}

	public Boolean getIsVocation() {
		return isVocation;
	}

	public void setIsVocation(Boolean isVocation) {
		this.isVocation = isVocation;
	}

	public Boolean getIsEditable() {
		return isEditable;
	}

	public void setIsEditable(Boolean isEditable) {
		this.isEditable = isEditable;
	}

}
