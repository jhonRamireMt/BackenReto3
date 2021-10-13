package com.project.ciclo3.reto3.service;

import com.project.ciclo3.reto3.modelo.Category;
import com.project.ciclo3.reto3.repositorio.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getCategoryAll(){
        return categoryRepository.obtenerCategoryLista();
    }

    public Optional<Category> getCategoryById(int id){
        return categoryRepository.obtenerCategoryId(id);
    }

   public Category saveCategory(Category category){
        if(category.getId()==null){
            return categoryRepository.guardarCategory(category);
        }else{
            Optional<Category> aux = categoryRepository.obtenerCategoryId(category.getId());
            if(aux.isEmpty()){
                return categoryRepository.guardarCategory(category);
            }else{
                return category;
            }
        }
   }
}
