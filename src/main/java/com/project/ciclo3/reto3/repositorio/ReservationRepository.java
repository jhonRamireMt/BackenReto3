package com.project.ciclo3.reto3.repositorio;

import com.project.ciclo3.reto3.custom.CountClients;
import com.project.ciclo3.reto3.modelo.Cabin;
import com.project.ciclo3.reto3.modelo.Client;
import com.project.ciclo3.reto3.modelo.Message;
import com.project.ciclo3.reto3.modelo.Reservation;
import com.project.ciclo3.reto3.repositorio.crud.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
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

    public Reservation actualizarCategory(Reservation reservation){
        return  reservationCrudRepository.save(reservation);
    }

    public void delete(Reservation reservation){
        reservationCrudRepository.delete(reservation);
    }

    public List<Reservation> getReservationByStatus(String description){
        return reservationCrudRepository.findAllByStatus(description);
    }

    public List<Reservation> getReservationPeriod(Date dateOne, Date dateTwo){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(dateOne,dateTwo);
    }

    public List<CountClients> getTopClients(){
        List<CountClients> res=new ArrayList<>();

        List<Object[]> report=reservationCrudRepository.countTotalReservationByClient();
        for(int i=0;i<report.size();i++){
            /*
            Categoria cat=(Categoria) report.get(i)[0];
            Integer cantidad=(Integer) report.get(i)[1];
            CountCategoria cc=new CountCategoria(cantidad,cat);
            res.add(cc);
            */
            res.add(new CountClients((Long) report.get(i)[1],(Client)report.get(i)[0] ));
        }
        return res;
    }

}
