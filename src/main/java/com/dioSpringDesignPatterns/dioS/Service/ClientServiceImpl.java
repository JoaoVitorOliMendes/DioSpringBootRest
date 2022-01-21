package com.dioSpringDesignPatterns.dioS.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dioSpringDesignPatterns.dioS.Repository.AddressRepository;
import com.dioSpringDesignPatterns.dioS.Repository.ClientRepository;
import com.dioSpringDesignPatterns.dioS.model.Address;
import com.dioSpringDesignPatterns.dioS.model.Client;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private AddressService addressService;

	@Override
	public Iterable<Client> searchAll() {
		return clientRepository.findAll();
	}

	@Override
	public Client searchById(Long id) {
		Optional<Client> client = clientRepository.findById(id);
		if(client.isPresent())
			return client.get();
		else
			return null;
	}

	@Override
	public void insert(Client client) {
		client = serachClientAddress(client);
		clientRepository.save(client);
	}

	@Override
	public void update(Long id, Client client) {
		Optional<Client> clientSaved = clientRepository.findById(id);
		if(clientSaved.isPresent()) {
			client = serachClientAddress(client);
			clientRepository.save(client);			
		}
	}

	private Client serachClientAddress(Client client) {
		String postalCode = client.getAddress().getPostalCode();
		Address address = addressRepository.findById(postalCode).orElseGet(() -> {
			Address newAddress = addressService.searchPostalCode(postalCode);
			addressRepository.save(newAddress);
			return newAddress;
		});
		
		client.setAddress(address);
		return client;
	}

	@Override
	public void delete(Long id) {
		clientRepository.deleteById(id);
	}

}
