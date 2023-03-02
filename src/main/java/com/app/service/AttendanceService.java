package com.app.service;

import java.util.List;

import com.app.entity.projection.AttendanceRecord;

public interface AttendanceService {
	List<AttendanceRecord> showAttendance(Long studentId);
}
