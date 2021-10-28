package com.project.ciclo3.reto3.repositorio;


import com.project.ciclo3.reto3.modelo.Client;
import com.project.ciclo3.reto3.modelo.Message;
import com.project.ciclo3.reto3.repositorio.crud.MensajeCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class MensajeRepository {

    @Autowired
    private MensajeCrudRepository mensajeCrudRepository;

    public List<Message> obtenerMensajeLista(){
        return (List<Message>) mensajeCrudRepository.findAll();
    }

    public Optional<Message> obtenerMensajeById(int id){
        return mensajeCrudRepository.findById(id);
    }

    public Message guardarMensaje(Message mensaje){
        return mensajeCrudRepository.save(mensaje);
    }

    public Message actualizarCategory(Message message){
        return  mensajeCrudRepository.save(message);
    }

    public void borrarCategory(Message message){
        mensajeCrudRepository.delete(message);
    }
}
