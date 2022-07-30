package com.recipes.manager.repositories;

import com.recipes.manager.entities.Recipe;
import com.recipes.manager.entities.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient,Long> {
}
