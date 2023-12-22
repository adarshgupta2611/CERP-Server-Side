package com.app.service;

import com.app.dto.ScheduleRequestDto;
import com.app.entities.Schedule;

import java.util.List;

public interface ScheduleService {
	Schedule addSchedule(ScheduleRequestDto scheduleDto, String courseName);
	List<com.app.entity.projection.Schedule> getSchedule(String courseName);
	void editSchedule(ScheduleRequestDto scheduleDto, String courseName);
	String deleteSchedule(Long id);
}