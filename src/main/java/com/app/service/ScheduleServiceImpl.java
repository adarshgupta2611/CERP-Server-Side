package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.EntityNotFoundException;
import com.app.dto.ScheduleRequestDto;
import com.app.entities.Course;
import com.app.entities.Schedule;
import com.app.entities.Subject;
import com.app.repository.CourseRepository;
import com.app.repository.ScheduleRepository;
import com.app.repository.SubjectRepository;

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {
	@Autowired
	private ScheduleRepository scheduleRepository;

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private SubjectRepository subjectRepository;

	@Override
	public Schedule addSchedule(ScheduleRequestDto scheduleDto, String courseName) {
		Course course =  courseRepository.findByCourseName(courseName);
		Subject subject = subjectRepository.findBySubjectName(scheduleDto.getSubjectName());
		Schedule schedule = new Schedule();
		schedule.setStartTime(scheduleDto.getStartTime());
		schedule.setEndTime(scheduleDto.getEndTime());
		schedule.setLocation(scheduleDto.getLocation());
		schedule.setCourse(course);
		schedule.setSubject(subject);
		return scheduleRepository.save(schedule);
	}

	@Override
	public List<com.app.entity.projection.Schedule> getSchedule(String courseName) {
		return scheduleRepository.findFullScheduleByCourse(courseName);
	}

	@Override
	public void editSchedule(ScheduleRequestDto scheduleDto, String courseName) {
		Subject subject = subjectRepository.findBySubjectName(scheduleDto.getSubjectName());
		Course course = courseRepository.findByCourseName(courseName);
		Schedule editedSchedule = scheduleRepository.findById(scheduleDto.getId()).get();
		if(scheduleDto.getStartTime()!=null)
			editedSchedule.setStartTime(scheduleDto.getStartTime());
		if(scheduleDto.getEndTime()!=null)
			editedSchedule.setEndTime(scheduleDto.getEndTime());
		if(scheduleDto.getLocation()!=null)
			editedSchedule.setLocation(scheduleDto.getLocation());
		if(subject!=null)
			editedSchedule.setSubject(subject);
		editedSchedule.setCourse(course);
	}

	@Override
	public String deleteSchedule(Long id) {
		if (scheduleRepository.existsById(id)) {
			scheduleRepository.deleteById(id);
			return "Schedule deleted successfully";
		}
		return "Deletion Failed : Invalid Schedule Id";
	}

}
