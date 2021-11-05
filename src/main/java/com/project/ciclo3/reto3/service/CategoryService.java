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

    public Category updateCategory(Category category){
        if(category.getId()!=null){
            Optional<Category> aux =categoryRepository.obtenerCategoryId(category.getId());
            if(!aux.isEmpty()){
                if(category.getDescription()!=null){
                    aux.get().setDescription(category.getDescription());
                }
                if(category.getName()!=null){
                    aux.get().setName(category.getName());
                }
                return categoryRepository.guardarCategory(aux.get());
            }
        }
        return category;
    }
    public boolean deleteCategory(int id){
        Boolean aux=getCategoryById(id).map(categoria -> {
            categoryRepository.delete(categoria);
            return true;
        }).orElse(false);
        return aux;
    }
}
