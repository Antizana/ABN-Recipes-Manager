package com.recipes.manager.repositories;

import com.recipes.manager.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe,Long> {
    @Query(name = "findAllByUserId",value = "SELECT R FROM Recipe R WHERE R.user.id=?1")
    List<Recipe> findAllByUser(Long userId);
}
