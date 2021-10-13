package com.project.ciclo3.reto3.service;

import com.project.ciclo3.reto3.modelo.Reservation;
import com.project.ciclo3.reto3.repositorio.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getReservationAll(){
        return reservationRepository.obtenerReservationLista();
    }

    public Optional<Reservation> getReservationById(int id){
        return reservationRepository.obtenerReservationById(id);
    }

    public Reservation saveReservation(Reservation reservation){
        if(reservation.getIdReservation()==null){
            return reservationRepository.guardarReservation(reservation);
        }else{
            Optional<Reservation> aux = reservationRepository.obtenerReservationById(reservation.getIdReservation());
            if(aux.isEmpty()){
                return reservationRepository.guardarReservation(reservation);
            }else{
                return reservation;
            }
        }
    }
}
