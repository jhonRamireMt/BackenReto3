package com.project.ciclo3.reto3.rest;

import com.project.ciclo3.reto3.custom.CountClients;
import com.project.ciclo3.reto3.custom.DescriptionAmount;
import com.project.ciclo3.reto3.modelo.Message;
import com.project.ciclo3.reto3.modelo.Reservation;
import com.project.ciclo3.reto3.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ReservationRest {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getReservationAll(){
        return reservationService.getReservationAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservationById(@PathVariable int id){
        return reservationService.getReservationById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation saveReservation(@RequestBody Reservation reservation){
        return reservationService.saveReservation(reservation);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation updateCabin(@RequestBody Reservation reservation){
        return reservationService.updateReservation(reservation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteCabin(@PathVariable("id")int id){
        return reservationService.deleteReservation(id);
    }

    @GetMapping("/report-status")
    public DescriptionAmount getClientDescritionStatus(){
        return reservationService.getStatusReport();
    }
    @GetMapping("/report-clients")
    public List<CountClients> getCountClients(){
        return reservationService.getTopClients();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getDatesReport(@PathVariable("dateOne")String d1, @PathVariable("dateTwo")String d2){
        return reservationService.getReservationPeriod(d1,d2);
    }


}
