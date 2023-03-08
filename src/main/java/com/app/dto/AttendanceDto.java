package com.app.dto;

public class AttendanceDto {

	private Long studentId;
	private Long subjectId;
	private int attendance;
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public Long getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}
	public int getAttendance() {
		return attendance;
	}
	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}
	public AttendanceDto(Long studentId, Long subjectId, int attendance) {
		super();
		this.studentId = studentId;
		this.subjectId = subjectId;
		this.attendance = attendance;
	}
	public AttendanceDto() {
		super();
	}
	@Override
	public String toString() {
		return "AttendanceDto [studentId=" + studentId + ", subjectId=" + subjectId + ", attendance=" + attendance
				+ "]";
	}
	
	
}
