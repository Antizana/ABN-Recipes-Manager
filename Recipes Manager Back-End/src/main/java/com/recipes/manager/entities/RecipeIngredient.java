package com.recipes.manager.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "RECIPE_INGREDIENTS",catalog = "recipes_management")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RecipeIngredient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String remarks;
    @OneToOne(mappedBy = "recipeIngredient", optional = false)
    private Ingredient ingredients;

    public Ingredient getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredient ingredients) {
        this.ingredients = ingredients;
    }
}
