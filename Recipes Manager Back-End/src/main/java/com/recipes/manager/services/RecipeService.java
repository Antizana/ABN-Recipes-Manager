package com.recipes.manager.services;


import com.recipes.manager.entities.Recipe;
import com.recipes.manager.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {


    @Autowired
    private RecipeRepository recipeRepository;


    public Recipe addRecipe(Recipe recipe){
        return recipeRepository.save(recipe);
    }

    public ResponseEntity deleteRecipeById(Long recipe_id){
        Recipe r=recipeRepository.findById(recipe_id).orElse(null);
        if(r!=null){
            recipeRepository.delete(r);
            return ResponseEntity.ok(r);
        }
        return null;
    }

    public Recipe updateRecipe(Recipe recipe){
        return recipeRepository.save(recipe);
    }

    public Recipe getRecipe(Recipe recipe){
        return recipeRepository.findById(recipe.getId()).orElse(null);
    }

    public List<Recipe> getAllRecipe(){
        return recipeRepository.findAll();
    }
    public List<Recipe> getAllRecipesByUserId(Long userId){
        return recipeRepository.findAllByUser(userId);
    }

    public Recipe findById(Long id){
        return recipeRepository.findById(id).orElse(null);
    }





}
