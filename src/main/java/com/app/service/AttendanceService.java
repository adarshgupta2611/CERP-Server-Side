package com.app.service;

import com.app.dto.AttendanceRequestDto;
import com.app.entities.Attendance;
import com.app.entity.projection.AttendanceList;
import com.app.entity.projection.AttendanceRecord;

import java.util.List;

public interface AttendanceService {
	List<AttendanceRecord> showAttendanceByStudent(Long studentId);
	Attendance addAttendance(AttendanceRequestDto attendancedto, String subjectName);
	List<AttendanceList> showAttendance(String subjectName);
	void updateAttendance(int attendance,String subjectName, Long studentId);
}