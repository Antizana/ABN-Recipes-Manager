package com.recipes.manager.services;

import com.recipes.manager.entities.RecipeIngredient;
import com.recipes.manager.repositories.RecipeIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeIngredientService {
    @Autowired
    private RecipeIngredientRepository repository;

    public List<RecipeIngredient> findAll(){
        return repository.findAll();
    }
    public RecipeIngredient findById(Long id){
        return repository.findById(id).orElse(null);
    }
}
