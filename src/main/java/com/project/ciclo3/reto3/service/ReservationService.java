package com.project.ciclo3.reto3.service;

import com.project.ciclo3.reto3.custom.CountClients;
import com.project.ciclo3.reto3.custom.DescriptionAmount;
import com.project.ciclo3.reto3.modelo.Cabin;
import com.project.ciclo3.reto3.modelo.Reservation;
import com.project.ciclo3.reto3.repositorio.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    public Reservation updateReservation(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> aux = reservationRepository.obtenerReservationById(reservation.getIdReservation());
            if(!aux.isEmpty()){

                if(reservation.getStartDate()!=null){
                    aux.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    aux.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    aux.get().setStatus(reservation.getStatus());
                }
                reservationRepository.guardarReservation(aux.get());
                return aux.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    public boolean deleteReservation(int reservationId) {
        Boolean aux = getReservationById(reservationId).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return aux;
    }

    public List<CountClients> getTopCategorias(){
        return reservationRepository.getTopClients();
    }

    public DescriptionAmount getStatusReport(){
        List<Reservation> completed=reservationRepository.getReservationByStatus("completed");
        List<Reservation> cancelled=reservationRepository.getReservationByStatus("cancelled");

        DescriptionAmount descAmt=new DescriptionAmount(completed.size(),cancelled.size());
        return descAmt;
    }
    public List<Reservation> getReservationPeriod(String d1, String d2){

        // yyyy-MM-dd
        SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
        Date dateOne=new Date();
        Date dateTwo=new Date();
        try {
            dateOne=parser.parse(d1);
            dateTwo=parser.parse(d2);
        }catch (ParseException e) {
            e.printStackTrace();
        }
        if(dateOne.before(dateTwo)){
            return reservationRepository.getReservationPeriod(dateOne,dateTwo);
        }else{
            return new ArrayList<>();
        }
    }
}
