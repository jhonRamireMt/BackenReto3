package com.project.ciclo3.reto3.rest;

import com.project.ciclo3.reto3.modelo.Cabin;
import com.project.ciclo3.reto3.service.CabinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Cabin")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CabinRest {

    @Autowired
    private CabinService cabinService;

    @GetMapping("/all")
    public List<Cabin> getAllCabin(){
        return cabinService.getCabinAll();
    }

    @GetMapping("/{id}")
    public Optional<Cabin> getCabinId(@PathVariable("id") int id){
        return cabinService.getCabinById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cabin save(@RequestBody Cabin cabin){
        return cabinService.saveCabin(cabin);
    }
}
