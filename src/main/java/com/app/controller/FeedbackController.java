package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.FeedbackDto;
import com.app.entities.Feedback;
import com.app.entity.projection.FeedbackList;
import com.app.service.FeedbackService;


@RestController
@RequestMapping("/feedback")
@CrossOrigin(origins = "http://localhost:3000/")
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;

	@PostMapping("/{studentId}/{subjectName}") 
	public ResponseEntity<?> addFeedback(@PathVariable Long studentId, @PathVariable String subjectName, @RequestBody FeedbackDto feedbackdto){
		Feedback feedback = feedbackService.addFeedback(feedbackdto, studentId, subjectName);
		if(feedback != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(feedback); 
		}
		else {
			return ResponseEntity.status(500).body("Feedback is already given");

		}
	}
	
	@GetMapping("/{subjectName}")
	public ResponseEntity<?> showFeedback(@PathVariable String subjectName){
		List<FeedbackList> feedbackList = feedbackService.showFeedback(subjectName);
    	if(feedbackList!=null)
    		return ResponseEntity.ok(feedbackList);
    	else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid subject name");
	}
}

