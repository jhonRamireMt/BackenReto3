package com.project.ciclo3.reto3.repositorio;

import com.project.ciclo3.reto3.modelo.Client;
import com.project.ciclo3.reto3.repositorio.crud.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<Client> obtenerClienteLista(){
        return (List<Client>) clientCrudRepository.findAll();
    }

    public Optional<Client> obtenerClienteById(int id){
        return clientCrudRepository.findById(id);
    }

    public Client guardarCliente(Client cliente){
        return clientCrudRepository.save(cliente);

    }
}
