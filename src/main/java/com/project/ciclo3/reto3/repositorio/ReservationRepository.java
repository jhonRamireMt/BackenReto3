package com.project.ciclo3.reto3.repositorio;

import com.project.ciclo3.reto3.modelo.Reservation;
import com.project.ciclo3.reto3.repositorio.crud.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> obtenerReservationLista(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    public Optional<Reservation> obtenerReservationById(int id){
        return reservationCrudRepository.findById(id);
    }

    public Reservation guardarReservation(Reservation reservation){
        return reservationCrudRepository.save(reservation);
    }

}
