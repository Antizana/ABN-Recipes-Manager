package com.recipes.manager.services;


import com.recipes.manager.entities.Ingredient;
import com.recipes.manager.entities.Recipe;
import com.recipes.manager.entities.RecipeIngredient;
import com.recipes.manager.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {

    @Autowired
    private IngredientRepository repository;
    @Autowired
    private RecipeIngredientService recipeIngredientService;
    @Autowired
    private RecipeService recipeService;

    public void addIngredient(Long ingredient_id,Recipe r){
        RecipeIngredient ri=recipeIngredientService.findById(ingredient_id);
        if(ri!=null){
            Ingredient ingredient=new Ingredient();
            ingredient.setRecipe(r);
            ingredient.setRecipeIngredient(ri);
            repository.save(ingredient);
        }
    }
}
