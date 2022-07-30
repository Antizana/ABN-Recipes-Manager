package com.recipes.manager.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "RECIPES",catalog = "recipes_management")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Recipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String recipe_name;
    private String description;
    private String preparation_time;
    private String cock_time;
    private Float price;
    private String vegetarian;
    private Integer serving;
    private String cocked_in;
    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "recipe",cascade = CascadeType.REMOVE)
    private List<Ingredient> ingredients;
}
