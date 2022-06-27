package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.converter.AppointmentConvertor;
import com.example.demo.converter.ClientConvertor;
import com.example.demo.dto.AppointmentDto;
import com.example.demo.dto.ClientDto;
import com.example.demo.model.Appointment;
import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;
import com.example.demo.service.AppointmentService;
import com.example.demo.service.ClientService;

@RestController
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private AppointmentService appointmentService;
	 
	@Autowired
	private ClientConvertor convertor;
	
	@Autowired
	private AppointmentConvertor appConvertor;
	
	public ClientController(AppointmentConvertor appConvertor) {
		super();
		this.appConvertor=appConvertor;
	}
	
	public ClientController(ClientConvertor convertor) {
		super();
		this.convertor = convertor;
	}
	
	// create client REST API
	@PostMapping("/gamestestingcenter/client/create")
	public ClientDto saveClient(@RequestBody ClientDto dto){
		
		Client client = convertor.dtoToEntity(dto);
		
		client = clientService.saveClient(client);
		
		return convertor.entityToDto(client);
	}
	
	// get all clients REST API
	@GetMapping("/gamestestingcenter")
	public List<ClientDto> getAllClients(){
		List<Client> getAll = clientService.getAllClients();
		return convertor.entitytoDto(getAll);
	}
	
	// get employee by id client REST API
	@GetMapping("/gamestestingcenter/client/findbyid/{id}")
	public ClientDto getClientById(@PathVariable("id") long clientId ) {
		Client getClientById = clientService.getClientById(clientId);
		return convertor.entityToDto(getClientById);
	}
	
	// update client client REST API
	@PutMapping("/gamestestingcenter/client/updateclient/{id}")
	public ClientDto updateClient(@PathVariable("id") long id,@RequestBody ClientDto dto) {
		Client entity = convertor.dtoToEntity(dto);
		entity =clientService.updateClient(entity, id);
		return convertor.entityToDto(entity);
		}
	
	// get delete client REST API
	@DeleteMapping("/gamestestingcenter/client/deleteclient/{id}")
	public void deleteClient(@PathVariable("id") long id) {
		clientService.deleteClient(id);
	}
	
	//get appointments for a client
	@GetMapping("/gametestingcenter/client/{id}/appointments")
	public List<AppointmentDto> getAppointmentsForClient(@PathVariable("id") long id ){
		List<Appointment> appList = clientService.getAppointmentsForClient(id);
		return appConvertor.entitytoDto(appList);
	}
	
	//Create an Appointment for a client
	@PostMapping("/gametestingcenter/client/{id}/makeappointment")
	public void createAppointmentForClient(@PathVariable("id") long id,@RequestBody Appointment appointment) {
		Client client = clientService.getClientById(id);
		appointment.setClient(client);
		appointmentService.createAppointment(appointment);
	}
}
