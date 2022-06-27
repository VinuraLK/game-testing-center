package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.converter.AppointmentConvertor;
import com.example.demo.dto.AppointmentDto;
import com.example.demo.dto.ClientDto;
import com.example.demo.model.Appointment;
import com.example.demo.service.AppointmentService;

@RestController
public class AppointmentController {

	@Autowired
	private AppointmentService service;
	
	@Autowired
	private AppointmentConvertor convertor;

	public AppointmentController(AppointmentConvertor convertor) {
		super();
		this.convertor = convertor;
	}
	
	//create appointment API
		@PostMapping("gamestestingcenter/appointment/create")
		public AppointmentDto createAppointment(AppointmentDto appointmentdto) {
			Appointment appointment = convertor.dtoToEntity(appointmentdto);
			service.createAppointment(appointment);
			return convertor.entityToDto(appointment);
			
		}
		
		//Get All Rest API
		@PostMapping("gamestestingcenter/appointment/getall")
		public List<AppointmentDto> getAllAppointments(){
			List<Appointment> getallappointments = service.getAllGames();
			return convertor.entitytoDto(getallappointments);
		}
		
		//get appointment by id
		@GetMapping("gamestestingcenter/appointment/getappointment/{id}")
		public AppointmentDto getAppointmentById(@PathVariable("id") long id) {
			Appointment a = service.getAppointmentById(id);
			return convertor.entityToDto(a);
		}
		
		//update appointment
		@PutMapping("/gamestestingcenter/client/updateappointment/{id}")
		public AppointmentDto updateAppointment(@PathVariable("id") long id, @RequestBody AppointmentDto dto ) {
			Appointment entity = convertor.dtoToEntity(dto);
			entity = service.updateAppointment(id, entity);
			return convertor.entityToDto(entity);
		}
		
		//delete appointment
		@DeleteMapping("/gamestestingcenter/appointment/delete/{id}")
		public void deleteAppointment(@PathVariable("id") long id) {
			service.deleteAppointment(id);
		}
		
		
		
}
