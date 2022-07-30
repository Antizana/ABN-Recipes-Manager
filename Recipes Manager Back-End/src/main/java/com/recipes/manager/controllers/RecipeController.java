package com.recipes.manager.controllers;

import com.recipes.manager.entities.Recipe;
import com.recipes.manager.entities.RecipeIngredient;
import com.recipes.manager.entities.User;
import com.recipes.manager.services.IngredientService;
import com.recipes.manager.services.RecipeIngredientService;
import com.recipes.manager.services.RecipeService;
import com.recipes.manager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/api/v1/recipes" )
public class RecipeController {

    @Autowired
    private RecipeService recipeService;
    @Autowired
    private UserService userService;
    @Autowired
    private IngredientService ingredientService;
    @Autowired
    private RecipeIngredientService recipeIngredientService;

    @PostMapping(path = "/add-recipe")
    public Recipe addRecipe(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "description") String description,
            @RequestParam(name = "preTime") String preparation_time,
            @RequestParam(name = "cockTime") String cockTime,
            @RequestParam(name = "price") String price,
            @RequestParam(name = "servingFor") String servingFor,
            @RequestParam(name = "veg") String veg,
            @RequestParam(name = "cockedIn") String cockedIn,
            @RequestParam(name = "user_id") Long user_id,
            @RequestParam(name = "ingredients") String ingredients
                            ){
        User u=userService.findById(user_id);
        if(u!=null){
            Recipe r=new Recipe();
            r.setRecipe_name(name);
            r.setDescription(description);
            r.setPreparation_time(preparation_time);
            r.setCock_time(cockTime);
            r.setCocked_in(cockedIn);
            r.setUser(u);
            r.setVegetarian(veg);
            r.setServing(Integer.valueOf(servingFor));
            r.setPrice(Float.valueOf(price));
            Recipe recipe=recipeService.addRecipe(r);
            for(String s:ingredients.split(",")){
                ingredientService.addIngredient(Long.valueOf(s),r);
            }
            return r;
        }
        return null;
    }
    @DeleteMapping("/delete-recipe")
    public ResponseEntity deleteRecipe(@RequestParam(name = "recipe_id") Long recipe_id){
        return recipeService.deleteRecipeById(recipe_id);
    }
    @PutMapping("/update-recipe")
    public Recipe updateRecipe(@RequestParam(name = "name") String name,
                               @RequestParam(name = "description") String description,
                               @RequestParam(name = "preTime") String preparation_time,
                               @RequestParam(name = "cockTime") String cockTime,
                               @RequestParam(name = "price") String price,
                               @RequestParam(name = "servingFor") String servingFor,
                               @RequestParam(name = "veg") String veg,
                               @RequestParam(name = "cockedIn") String cockedIn,
                               @RequestParam(name = "user_id") Long user_id,
                               @RequestParam(name = "recipe_id") Long recipe_id){
        User u=userService.findById(user_id);
        if(u!=null){
            Recipe r=new Recipe();
            r.setId(Long.valueOf(recipe_id));
            r.setRecipe_name(name);
            r.setDescription(description);
            r.setPreparation_time(preparation_time);
            r.setCock_time(cockTime);
            r.setCocked_in(cockedIn);
            r.setUser(u);
            r.setVegetarian(veg);
            r.setServing(Integer.valueOf(servingFor));
            r.setPrice(Float.valueOf(price));
            Recipe recipe=recipeService.updateRecipe(r);
            return recipe;
        }
        return null;
    }
    @GetMapping("/all-recipe")
    public Recipe allRecipes(@RequestBody Recipe recipe){
        return recipeService.addRecipe(recipe);
    }
    @GetMapping("/all-recipes-by-user")
    public List<Recipe> getAllRecipesByUserId(@RequestParam(name = "user_id") Long user_id){
        return recipeService.getAllRecipesByUserId(user_id);
    }
    @GetMapping("/all-recipe-ingredients")
    public List<RecipeIngredient> getAllIngredients(){
        return recipeIngredientService.findAll();
    }




}
