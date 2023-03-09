package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AttendanceRequestDto;
import com.app.dto.UpdateAttendanceDto;
import com.app.entities.Attendance;
import com.app.entity.projection.AttendanceList;
import com.app.service.AttendanceService;

@RestController
@RequestMapping("/attendance")
@CrossOrigin(origins = "http://localhost:3000/")
public class AttendanceController {
	@Autowired
	private AttendanceService attendanceService;
	
	@GetMapping("/{studentId}")
	public ResponseEntity<?> showAttendance(@PathVariable Long studentId){
		return ResponseEntity.ok(attendanceService.showAttendanceByStudent(studentId));
	}
	
	@PostMapping("/{subjectName}")
    public ResponseEntity<?> addAttendance(@Valid @RequestBody AttendanceRequestDto attendancedto, @PathVariable String subjectName){
		 Attendance attendance = attendanceService.addAttendance(attendancedto, subjectName);
		  if(attendance != null)
		     	 return ResponseEntity.status(HttpStatus.CREATED).body(attendance); 
		  else
	            return ResponseEntity.status(500).body("Attendance is already present");
	}
	
	@GetMapping("/admins/{subjectName}")
	public ResponseEntity<?> showAttendance(@PathVariable String subjectName){
    	List<AttendanceList> attendanceList = attendanceService.showAttendance(subjectName);
    	if(attendanceList!=null)
    		return ResponseEntity.ok(attendanceList);
    	else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid subject name");
	}
	
	 @PatchMapping("/{subjectName}/{studentId}")
	    public ResponseEntity<?> updateAttendance(@RequestBody UpdateAttendanceDto attendance,@PathVariable String subjectName, @PathVariable Long studentId){
	    	attendanceService.updateAttendance(attendance.getAttendance(), subjectName, studentId);
	    	return ResponseEntity.ok("updated successfully");
	    }
   
}
