package com.project.ciclo3.reto3.service;

import com.project.ciclo3.reto3.modelo.Client;
import com.project.ciclo3.reto3.repositorio.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getClientAll(){
        return clientRepository.obtenerClienteLista();
    }

    public Optional<Client> getClientById(int id){
        return clientRepository.obtenerClienteById(id);
    }

    public Client saveClient(Client client){
        if(client.getIdClient()==null){
            return clientRepository.guardarCliente(client);
        }else{
            Optional<Client> aux = clientRepository.obtenerClienteById(client.getIdClient());
            if(aux.isEmpty()){
                return clientRepository.guardarCliente(client);
            }else{
                return client;
            }
        }
    }
}
