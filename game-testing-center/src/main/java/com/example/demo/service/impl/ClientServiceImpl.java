package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.repository.ClientRepository;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Appointment;
import com.example.demo.model.Client;
import com.example.demo.service.ClientService;

@Service
public class ClientServiceImpl  implements ClientService{

	private ClientRepository clientRepository;
	
	public ClientServiceImpl(ClientRepository clientRepository) {
		super();
		this.clientRepository = clientRepository;
	}

	@Override
	public Client saveClient(Client client) {
		Client gh = clientRepository.save(client);
		return gh;
	}

	@Override
	public List<Client> getAllClients() {
		return clientRepository.findAll();
	}

	@Override
	public Client getClientById(long id) {
		 Optional<Client> client = clientRepository.findById(id);
		 if(client.isPresent()) {
			 return client.get();
			 
		 }else {
			 throw new ResourceNotFoundException("Client", "id", id);
		 }
	}

	@Override
	public Client updateClient(Client client, long id) {
		Client existingClient = clientRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Client", "Id", id));
		
		existingClient.setFirstName(client.getFirstName());
		existingClient.setLastName(client.getLastName());
		existingClient.setEmail(client.getEmail());
		
		clientRepository.save(existingClient);
		
		return existingClient;
	}

	@Override
	public void deleteClient(long id) {
		clientRepository.deleteById(id);
		
	}

	@Override
	public List<Appointment> getAppointmentsForClient(long id) {
		Client client = clientRepository.findById(id).get();
		return client.getAppointments();
		
	}
	
  
	
}
