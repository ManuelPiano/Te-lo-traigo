package com.devintech.prueba.Controller;

import com.devintech.prueba.Entity.Client;
import com.devintech.prueba.Service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/create")
    @Operation(summary = "Crear nuevo cliente")
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    @GetMapping("/list")
    @Operation(summary = "Listar todos los clientes")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    @Operation(summary = "mostrar clientes por su id")
    public Client getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "borrar cliente por su id")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }
}
