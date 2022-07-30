/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.io.Serializable;
import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Recipe implements Serializable {

    private Long id;
    private String recipe_name;
    private String description;
    private String preparation_time;
    private String cock_time;
    private Float price;
    private String vegetarian;
    private Integer serving;
    private String cocked_in;
    private User user;
    private Collection<Ingredient> ingredients;
}
