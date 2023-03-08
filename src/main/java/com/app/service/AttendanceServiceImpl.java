package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.EntityNotFoundException;
import com.app.dto.AttendanceRequestDto;
import com.app.entities.Attendance;
import com.app.entities.Student;
import com.app.entities.Subject;
import com.app.entity.projection.AttendanceList;
import com.app.entity.projection.AttendanceRecord;
import com.app.repository.AttendanceRepository;
import com.app.repository.StudentRepository;
import com.app.repository.SubjectRepository;

@Service
@Transactional
public class AttendanceServiceImpl implements AttendanceService {
	@Autowired
	private AttendanceRepository attendanceRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private SubjectRepository subjectRepository;

	@Override
	public List<AttendanceRecord> showAttendanceByStudent(Long studentId) {
		return attendanceRepository.findAttendanceByStudent(studentId);   
	}

	@Override
	public Attendance addAttendance(AttendanceRequestDto attendancedto, String subjectName) {
		Student student = studentRepository.findById(attendancedto.getStudentId())
				.orElseThrow(() -> new EntityNotFoundException("Student not found with id: " + attendancedto.getStudentId()));

		Subject subject = subjectRepository.findBySubjectName(subjectName);
		Attendance at = attendanceRepository.findAttendanceByStudentAndSubject(student, subject);
		Attendance attendance = new Attendance();
		if(at == null) {
			attendance.setStudent(student);
			attendance.setSubject(subject);
			attendance.setAttendance(attendancedto.getAttendance());
			return attendanceRepository.save(attendance);
		}
		else {
			return null;
		}
	}

	@Override
	public List<AttendanceList> showAttendance(String subjectName) {
		return attendanceRepository.findAllBySubjectNameAndSortedById(subjectName);
	}
	
	@Override
	public void updateAttendance(int attendance, String subjectName, Long studentId) {
		Student student = studentRepository.findById(studentId).get();
		Subject subject = subjectRepository.findBySubjectName(subjectName);
		Attendance at = attendanceRepository.findAttendanceByStudentAndSubject(student, subject);
		at.setAttendance(attendance);
	}
}
