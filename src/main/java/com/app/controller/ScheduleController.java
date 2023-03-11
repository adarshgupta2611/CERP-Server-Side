package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.ScheduleRequestDto;
import com.app.entities.Schedule;
import com.app.service.ScheduleService;

@RestController
@RequestMapping("/schedule")
@CrossOrigin(origins = "http://localhost:3000/")
public class ScheduleController {
	@Autowired
	private ScheduleService scheduleService;

	@PostMapping("/{courseName}")	
	public ResponseEntity<?> addSchedule(@Valid @RequestBody ScheduleRequestDto scheduledto, @PathVariable String courseName){
		Schedule schedule = scheduleService.addSchedule(scheduledto, courseName);
		return ResponseEntity.status(HttpStatus.CREATED).body(schedule); 
	}
	
	@GetMapping("/{courseName}")
	public ResponseEntity<?> getSchedule(@PathVariable String courseName){
		return ResponseEntity.ok(scheduleService.getSchedule(courseName));
	}
	
	@PutMapping("/{courseName}")
	public ResponseEntity<?> editSchedule(@Valid @RequestBody ScheduleRequestDto schedule, @PathVariable String courseName){
		scheduleService.editSchedule(schedule,courseName);
		return ResponseEntity.ok("schedule edit successfully");
	}
	
	@DeleteMapping("/{courseName}")
	public ApiResponse deleteEmpDetails(@Valid @RequestBody ScheduleRequestDto schedule) {
		return new ApiResponse(scheduleService.deleteSchedule(schedule.getId()));
	}
}
