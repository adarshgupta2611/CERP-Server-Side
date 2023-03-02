package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entity.projection.AttendanceRecord;
import com.app.repository.AttendanceRepository;

@Service
@Transactional
public class AttendanceServiceImpl implements AttendanceService {
	@Autowired
	private AttendanceRepository attendanceRepository;
	
	@Override
	public List<AttendanceRecord> showAttendance(Long studentId) {
		return attendanceRepository.findAttendanceByStudent(studentId);   
	}

}
