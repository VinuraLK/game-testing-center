package com.example.demo.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.dto.AppointmentDto;
import com.example.demo.dto.GameDto;
import com.example.demo.model.Appointment;
import com.example.demo.model.Game;

@Component
public class AppointmentConvertor {
	
	public AppointmentDto entityToDto(Appointment appointment) {
		AppointmentDto dto = new AppointmentDto();
		dto.setClientID(appointment.getClientID());
		dto.setDate(appointment.getDate());
		dto.setFirstName(appointment.getFirstName());
		dto.setLastName(appointment.getLastName());
		dto.setGameID(appointment.getGameID());
		dto.setId(appointment.getId());
		
		return dto;
		
	}
	
	public Appointment dtoToEntity (AppointmentDto appdto) {
		Appointment app = new Appointment();
		app.setClientID(appdto.getClientID());
		app.setDate(appdto.getDate());
		app.setFirstName(appdto.getFirstName());
		app.setLastName(appdto.getLastName());
		app.setGameID(appdto.getGameID());
		app.setId(appdto.getId());
		
		return app;
	}
	
	public List<AppointmentDto> entitytoDto(List<Appointment> applist){
		
		return applist.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	
	}
	
	public List<Appointment> dtoToEntity(List<AppointmentDto> dtolist){
		
		return dtolist.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
		
	}
}
