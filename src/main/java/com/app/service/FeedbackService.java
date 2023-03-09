package com.app.service;

import java.util.List;

import com.app.dto.FeedbackDto;
import com.app.entities.Feedback;
import com.app.entity.projection.FeedbackList;

public interface FeedbackService {
	Feedback addFeedback(FeedbackDto feedbackdto, Long studentId, String subjectName);
	Feedback getFeedbackById(Long id);
	List<FeedbackList> showFeedback(String subjectName);
}


