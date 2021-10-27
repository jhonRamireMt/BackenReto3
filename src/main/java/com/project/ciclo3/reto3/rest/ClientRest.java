package com.project.ciclo3.reto3.rest;

import com.project.ciclo3.reto3.modelo.Category;
import com.project.ciclo3.reto3.modelo.Client;
import com.project.ciclo3.reto3.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ClientRest {

    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<Client> getClientAll(){
        return clientService.getClientAll();
    }

    @GetMapping("/{id}")
    public Optional<Client> getClientById(@PathVariable("id") int id){
        return clientService.getClientById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client saveClient(@RequestBody Client client){
        return clientService.saveClient(client);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client updateCabin(@RequestBody Client client){
        return clientService.updateClient(client);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteCabin(@PathVariable("id")int id){
        return clientService.deleteClient(id);
    }

}
