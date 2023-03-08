package com.app.dto;

public class AttendanceRequestDto {
	
	private Long studentId;
	private int attendance;
	
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	
	public int getAttendance() {
		return attendance;
	}
	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}
	public AttendanceRequestDto(Long studentId, int attendance) {
		super();
		this.studentId = studentId;
		this.attendance = attendance;
	}
	public AttendanceRequestDto() {
		super();
	}
	@Override
	public String toString() {
		return "AttendanceRequestDto [studentId=" + studentId + ", attendance=" + attendance + "]";
	}
	
	
	
	
}
