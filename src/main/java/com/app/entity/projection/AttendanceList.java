package com.app.entity.projection;

import com.app.entities.Student;

public class AttendanceList {
	private Student student;
	private int attendance;
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public int getAttendance() {
		return attendance;
	}
	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}
	public AttendanceList(Student student, int attendance) {
		super();
		this.student = student;
		this.attendance = attendance;
	}
	public AttendanceList() {
		super();
	}
	
	
}
