package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.AppointmentDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Appointment;
import com.example.demo.repository.AppointmentRepository;
import com.example.demo.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	private AppointmentRepository appointmentRepository;
	
	@Override
	public Appointment createAppointment(Appointment appointment) {
		Appointment app = appointmentRepository.save(appointment);
		return app;
	}

	@Override
	public List<Appointment> getAllGames() {
		List<Appointment> applist = appointmentRepository.findAll();
		return applist;
	}

	@Override
	public Appointment getAppointmentById(long id) {
		Optional<Appointment> app = appointmentRepository.findById(id);
		return app.get();
	}

	@Override
	public Appointment updateAppointment(long id, Appointment entity) {
		Appointment existingAppointment = appointmentRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Appointment", "Id", id));
		
		existingAppointment.setFirstName(entity.getFirstName());
		existingAppointment.setClientID(entity.getClientID());
		existingAppointment.setDate(entity.getDate());
		existingAppointment.setGameID(entity.getGameID());
		existingAppointment.setId(entity.getId());
		existingAppointment.setLastName(entity.getLastName());
		
		appointmentRepository.save(existingAppointment);
		
		return existingAppointment;
	}

	@Override
	public void deleteAppointment(long id) {
		appointmentRepository.deleteById(id);
		
	}

}
