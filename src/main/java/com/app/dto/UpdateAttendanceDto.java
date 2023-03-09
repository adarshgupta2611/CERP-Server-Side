package com.app.dto;

public class UpdateAttendanceDto {
	private int attendance;

	public UpdateAttendanceDto(int attendance) {
		super();
		this.attendance = attendance;
	}

	public UpdateAttendanceDto() {
		super();
	}

	public int getAttendance() {
		return attendance;
	}

	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}

	@Override
	public String toString() {
		return "UpdateAttendanceDto [attendance=" + attendance + "]";
	}
	
}
