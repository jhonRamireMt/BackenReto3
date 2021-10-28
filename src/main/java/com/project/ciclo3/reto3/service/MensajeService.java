package com.project.ciclo3.reto3.service;

import com.project.ciclo3.reto3.modelo.Message;
import com.project.ciclo3.reto3.repositorio.MensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MensajeService {

    @Autowired
    private MensajeRepository mensajeRepository;

    public List<Message> getMessageAll(){
        return mensajeRepository.obtenerMensajeLista();
    }

    public Optional<Message> getMessageById(int id){
        return mensajeRepository.obtenerMensajeById(id);
    }

    public Message saveMessage(Message mensaje){
        if(mensaje.getIdMessage()==null){
            return mensajeRepository.guardarMensaje(mensaje);
        }else{
            Optional<Message> aux = mensajeRepository.obtenerMensajeById(mensaje.getIdMessage());
            if(aux.isEmpty()){
                return mensajeRepository.guardarMensaje(mensaje);
            }else{
                return null;
            }
        }
    }
}
