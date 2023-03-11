package com.app.dto;

import java.time.LocalDateTime;

public class ScheduleRequestDto {
	private Long Id;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private String Location;
	private String subjectName;
	
	public ScheduleRequestDto() {
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public ScheduleRequestDto(Long id, LocalDateTime startTime, LocalDateTime endTime, String location,
			String subjectName) {
		super();
		Id = id;
		this.startTime = startTime;
		this.endTime = endTime;
		Location = location;
		this.subjectName = subjectName;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	@Override
	public String toString() {
		return "ScheduleRequestDto [startTime=" + startTime + ", endTime=" + endTime + ", Location=" + Location
				+ ", subjectName=" + subjectName + "]";
	}
	
	
}
