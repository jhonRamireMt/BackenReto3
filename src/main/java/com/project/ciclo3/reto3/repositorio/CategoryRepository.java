package com.project.ciclo3.reto3.repositorio;

import com.project.ciclo3.reto3.modelo.Category;
import com.project.ciclo3.reto3.repositorio.crud.CategoryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {

    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    public List<Category> obtenerCategoryLista(){
        return (List<Category>) categoryCrudRepository.findAll();
    }

    public Optional<Category> obtenerCategoryId(int id){
        return categoryCrudRepository.findById(id);
    }

    public Category guardarCategory(Category category){
        return  categoryCrudRepository.save(category);
    }
}
