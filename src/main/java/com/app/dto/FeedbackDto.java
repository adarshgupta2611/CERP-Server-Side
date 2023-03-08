package com.app.dto;


public class FeedbackDto {
    private int rating;
    
	
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public FeedbackDto(int rating) {
		super();
		this.rating = rating;
	}
	public FeedbackDto() {
		super();
	}
	@Override
	public String toString() {
		return "FeedbackDto [rating=" + rating + "]";
	}
	
    
    
}
