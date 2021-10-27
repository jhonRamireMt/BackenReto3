package com.project.ciclo3.reto3.repositorio.crud;

import com.project.ciclo3.reto3.modelo.Cabin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface CabinCrudRepository extends CrudRepository<Cabin,Integer> {



}
