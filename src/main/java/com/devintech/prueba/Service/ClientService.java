package com.devintech.prueba.Service;

import com.devintech.prueba.Entity.Client;
import com.devintech.prueba.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long clientId) {
        return clientRepository.findById(clientId).orElse(null);
    }

    public void deleteClient(Long clientId) {
        clientRepository.deleteById(clientId);
    }
}
