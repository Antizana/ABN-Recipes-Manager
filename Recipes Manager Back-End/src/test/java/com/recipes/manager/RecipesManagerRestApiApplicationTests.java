package com.recipes.manager;

import com.recipes.manager.entities.Ingredient;
import com.recipes.manager.entities.Recipe;
import com.recipes.manager.entities.User;
import com.recipes.manager.repositories.UserRepository;
import com.recipes.manager.services.IngredientService;
import com.recipes.manager.services.RecipeService;
import com.recipes.manager.services.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class RecipesManagerRestApiApplicationTests {

    @InjectMocks
    private RecipeService recipeService;
    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepository userRepository;
    @Autowired
    private IngredientService ingredientService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findAllRecipes_ByUser() {
        System.out.println(userService==null?"YES":"NO");
        User user=userService.findById(1L);
        List<Recipe> list=new ArrayList<>();
        list.add(new Recipe(5L,"Rice","Boil Rice","3","6",3f,"Yes",3,"Boiling",user,new ArrayList<Ingredient>()));
        when(recipeService.getAllRecipe()).thenReturn(list);
        List<Recipe> recipes=recipeService.getAllRecipe();
        Assert.assertEquals(1, recipes.size());
        verify(recipeService, times(1)).getAllRecipe();
    }

}
