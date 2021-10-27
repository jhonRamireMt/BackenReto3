package com.project.ciclo3.reto3.service;

import com.project.ciclo3.reto3.custom.CountClients;
import com.project.ciclo3.reto3.custom.DescriptionAmount;
import com.project.ciclo3.reto3.modelo.Cabin;
import com.project.ciclo3.reto3.repositorio.CabinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CabinService {

    @Autowired
    private CabinRepository cabinRepository;

    public List<Cabin> getCabinAll(){
        return cabinRepository.obtenerCabinLista();
    }

    public Optional<Cabin> getCabinById(int id){
        return cabinRepository.obtenerCabinId(id);
    }

    public Cabin saveCabin(Cabin c){
        if(c.getId()==null){
            return cabinRepository.guardarCabin(c);
        }else{
            Optional<Cabin> aux = cabinRepository.obtenerCabinId(c.getId());
            if(aux.isEmpty()){
                return cabinRepository.guardarCabin(c);
            }else{
                return c;
            }
        }
    }

    public Cabin updateCabin(Cabin cabin){
        if(cabin.getId()!=null){
            Optional<Cabin> aux=cabinRepository.obtenerCabinId(cabin.getId());
            if(!aux.isEmpty()){
                if(cabin.getName()!=null){
                    aux.get().setName(cabin.getName());
                }
                if(cabin.getBrand()!=null){
                    aux.get().setBrand(cabin.getBrand());
                }
                if(cabin.getRooms()!=null){
                    aux.get().setRooms(cabin.getRooms());
                }
                if(cabin.getDescription()!=null){
                    aux.get().setDescription(cabin.getDescription());
                }
                if(cabin.getCategory()!=null){
                    aux.get().setCategory(cabin.getCategory());
                }
                cabinRepository.guardarCabin(aux.get());
                return aux.get();
            }else{
                return cabin;
            }
        }else{
            return cabin;
        }
    }

    public boolean deleteCabin(int id) {
        Boolean aux = getCabinById(id).map(cabin -> {
            cabinRepository.delete(cabin);
            return true;
        }).orElse(false);
        return aux;
    }



}
