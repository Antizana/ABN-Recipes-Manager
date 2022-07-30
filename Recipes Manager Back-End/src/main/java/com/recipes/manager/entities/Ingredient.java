package com.recipes.manager.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "INGREDIENTS",catalog = "recipes_management")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ingredient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    @JoinColumn(name = "ingredient_id",referencedColumnName = "id")
    private RecipeIngredient recipeIngredient;
    @ManyToOne
    @JoinColumn(name = "recipe_id",referencedColumnName = "id")
    private Recipe recipe;
}
