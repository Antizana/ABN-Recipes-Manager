package com.recipes.manager.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "USERS",catalog = "recipes_management")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String first_name;
    private String last_name;
    private String father_name;
    private Integer age;
    private String username;
    private String password;
    private Boolean active;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Collection<Recipe> recipes;
}
