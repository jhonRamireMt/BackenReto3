package com.project.ciclo3.reto3.rest;

import com.project.ciclo3.reto3.modelo.Cabin;
import com.project.ciclo3.reto3.modelo.Category;
import com.project.ciclo3.reto3.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CategoryRest {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getCategoryAll(){
        return categoryService.getCategoryAll();
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategoryId(@PathVariable("id") int id){
        return categoryService.getCategoryById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category saveCategory(@RequestBody Category category){
        return categoryService.saveCategory(category);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category updateCabin(@RequestBody Category category){
        return categoryService.updateCategory(category);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteCabin(@PathVariable("id")int id){
        return categoryService.deleteCategory(id);
    }

}
