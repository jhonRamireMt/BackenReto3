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

    public Client updateClient(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> aux = clientRepository.obtenerClienteById(client.getIdClient());
            if(!aux.isEmpty()){
                if(client.getName()!=null){
                    aux.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    aux.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    aux.get().setPassword(client.getPassword());
                }
                clientRepository.guardarCliente(aux.get());
                return aux.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }

    public boolean deleteClient(int id) {
        Boolean aux = getClientById(id).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return aux;
    }
}
