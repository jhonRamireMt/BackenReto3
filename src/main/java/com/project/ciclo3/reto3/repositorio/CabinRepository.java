package com.project.ciclo3.reto3.repositorio;

import com.project.ciclo3.reto3.custom.CountClients;
import com.project.ciclo3.reto3.modelo.Cabin;
import com.project.ciclo3.reto3.modelo.Category;
import com.project.ciclo3.reto3.modelo.Client;
import com.project.ciclo3.reto3.repositorio.crud.CabinCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;

@Repository
public class CabinRepository {

    @Autowired
    private CabinCrudRepository cabinCrudRepository;

    public List<Cabin> obtenerCabinLista(){
        return (List<Cabin>) cabinCrudRepository.findAll();
    }

    public Optional<Cabin> obtenerCabinId(int id){
        return cabinCrudRepository.findById(id);
    }

    public Cabin guardarCabin(Cabin cabin){
        return cabinCrudRepository.save(cabin);
    }

    public Cabin actualizarCabin(Cabin cabin){
        return  cabinCrudRepository.save(cabin);
    }

    public void delete(Cabin cabin){
        cabinCrudRepository.delete(cabin);
    }




}
