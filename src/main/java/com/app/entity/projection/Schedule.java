package com.app.entity.projection;

import java.time.LocalDateTime;

public class Schedule {
	private long scheduleId;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private String Location;
	private String subjectName;
	
	public Schedule() {
	}

	public Schedule(long scheduleId, LocalDateTime startTime, LocalDateTime endTime, String location,
			String subjectName) {
		super();
		this.scheduleId = scheduleId;
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

	public long getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(long scheduleId) {
		this.scheduleId = scheduleId;
	}

	@Override
	public String toString() {
		return "Schedule [startTime=" + startTime + ", endTime=" + endTime + ", Location=" + Location + ", subjectName="
				+ subjectName + "]";
	}
}
