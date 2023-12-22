package com.app.controller;

import com.app.dto.ApiResponse;
import com.app.dto.ScheduleRequestDto;
import com.app.entities.Schedule;
import com.app.service.ScheduleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedule")
@CrossOrigin(origins = "http://localhost:3000/")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @PostMapping("/{courseName}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> addSchedule(@Valid @RequestBody ScheduleRequestDto scheduledto, @PathVariable String courseName) {
        Schedule schedule = scheduleService.addSchedule(scheduledto, courseName);
        return ResponseEntity.status(HttpStatus.CREATED).body(schedule);
    }

    @GetMapping("/{courseName}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> getSchedule(@PathVariable String courseName) {
        return ResponseEntity.ok(scheduleService.getSchedule(courseName));
    }

    @PutMapping("/{courseName}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> editSchedule(@Valid @RequestBody ScheduleRequestDto schedule, @PathVariable String courseName) {
        scheduleService.editSchedule(schedule, courseName);
        return ResponseEntity.ok("schedule edit successfully");
    }

    @DeleteMapping("/{courseName}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ApiResponse deleteEmpDetails(@Valid @RequestBody ScheduleRequestDto schedule) {
        return new ApiResponse(scheduleService.deleteSchedule(schedule.getId()));
    }
}