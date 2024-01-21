package com.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
@NoArgsConstructor
@Getter
@Setter
public class ApiResponse  implements Serializable{
	private LocalDateTime timestamp;
	private String message;
	public ApiResponse(String message) {
		super();
		this.message = message;
		this.timestamp=LocalDateTime.now();
	}
	
}