package com.example.demo.dto;

import lombok.Data;

@Data
public class AppointmentDto {

	private long id;
	private long gameID;
	private String date;
	private String firstName;
	private String lastName;
	private long clientID;
}
