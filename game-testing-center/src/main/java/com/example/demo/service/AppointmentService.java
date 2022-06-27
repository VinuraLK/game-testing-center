package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.AppointmentDto;
import com.example.demo.model.Appointment;

public interface AppointmentService {

	Appointment createAppointment(Appointment appointment);

	List<Appointment> getAllGames();
	
	Appointment getAppointmentById (long id);
	
	Appointment updateAppointment (long id, Appointment entity);
	
	void deleteAppointment (long id);

}
