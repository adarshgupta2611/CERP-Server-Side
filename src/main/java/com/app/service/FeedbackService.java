package com.app.service;

import java.util.List;

import com.app.dto.FeedbackDto;
import com.app.entities.Feedback;

public interface FeedbackService {
	Feedback addFeedback(FeedbackDto feedbackdto, Long studentId, String subjectName);
	Feedback getFeedbackById(Long id);
	List<Integer> showFeedback(String subjectName);
}


