package com.app.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "feedback")
public class Feedback extends BaseEntity
{

	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    private int knowledge;
    private int communication;
    private int punctuality;
    private int teaching;
    private int guidance;
    private String suggestion;

	public Feedback() {
		super();
	}
	
	
	

	public String getSuggestion() {
		return suggestion;
	}




	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}




	public int getKnowledge() {
		return knowledge;
	}



	public void setKnowledge(int knowledge) {
		this.knowledge = knowledge;
	}



	public int getCommunication() {
		return communication;
	}



	public void setCommunication(int communication) {
		this.communication = communication;
	}



	public int getPunctuality() {
		return punctuality;
	}



	public void setPunctuality(int punctuality) {
		this.punctuality = punctuality;
	}



	public int getTeaching() {
		return teaching;
	}



	public void setTeaching(int teaching) {
		this.teaching = teaching;
	}



	public int getGuidance() {
		return guidance;
	}



	public void setGuidance(int guidance) {
		this.guidance = guidance;
	}



	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	
    
    
}
