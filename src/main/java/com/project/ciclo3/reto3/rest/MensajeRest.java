package com.project.ciclo3.reto3.rest;

import com.project.ciclo3.reto3.modelo.Client;
import com.project.ciclo3.reto3.modelo.Message;
import com.project.ciclo3.reto3.service.MensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class MensajeRest {

    @Autowired
    private MensajeService mensajeService;

    @GetMapping("/all")
    public List<Message> getMessagesAll(){
        return mensajeService.getMessageAll();
    }

    @GetMapping("/{id}")
    public Optional<Message> getMessageById(@PathVariable int id){
        return mensajeService.getMessageById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message saveMessage(@RequestBody Message mensaje){
        return mensajeService.saveMessage(mensaje);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message updateCabin(@RequestBody Message message){
        return mensajeService.updateMessage(message);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteCabin(@PathVariable("id")int id){
        return mensajeService.deleteMessage(id);
    }

}
