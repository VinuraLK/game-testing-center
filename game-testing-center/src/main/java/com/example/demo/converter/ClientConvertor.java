package com.example.demo.converter;

import java.text.Collator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.dto.ClientDto;
import com.example.demo.model.Client;



@Component
public class ClientConvertor {
	
	public ClientDto entityToDto (Client client) {
		
		ClientDto dto = new ClientDto();
		dto.setId(client.getId());
		dto.setEmail(client.getEmail());
		dto.setFirstName(client.getFirstName());
		dto.setLastName(client.getLastName());
		
		return dto;
	}
	
	public Client dtoToEntity(ClientDto dto) {
		
		Client cl = new Client();
		cl.setEmail(dto.getEmail());
		cl.setFirstName(dto.getFirstName());
		cl.setLastName(dto.getLastName());
		cl.setId(dto.getId());
		
		return cl;
	}
	
	public List<ClientDto> entitytoDto(List<Client> client){
		
		return client.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	
	}
	
	public List<Client> dtoToEntity(List<ClientDto> dto){
		
		return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
		
	}
	
	
}
