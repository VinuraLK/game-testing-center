package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Appointment;
import com.example.demo.model.Client;

public interface ClientService {

	Client saveClient(Client client);
	
	List<Client> getAllClients();
	
	Client getClientById(long id);
	
	Client updateClient(Client client, long id);
	
	void deleteClient(long id);
	
	List<Appointment> getAppointmentsForClient(long id);
}
