//package com.recipes.manager.controller.impl;
//
//import com.recipes.manager.controller.impl.CustomUtils;
//import com.recipes.manager.controller.impl.IngredientControllerImpl;
//import com.recipes.manager.dto.IngredientDTO;
//import com.recipes.manager.entities.Ingredient;
//import com.recipes.manager.mapper.IngredientMapper;
//import com.recipes.manager.mapper.ReferenceMapper;
//import com.recipes.manager.service.IngredientService;
//import org.hamcrest.Matchers;
//import org.hamcrest.core.Is;
//import org.mockito.ArgumentMatchers;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.Arrays;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//@RunWith(SpringRunner.class)
//public class IngredientControllerImplTest {
//    //TODO: create the data Test generator class IngredientBuilder
//    private static final String ENDPOINT_URL = "/ingredients";
//    @MockBean
//    private ReferenceMapper referenceMapper;
//    @InjectMocks
//    private IngredientControllerImpl ingredientController;
//    @MockBean
//    private IngredientService ingredientService;
//    @MockBean
//    private IngredientMapper ingredientMapper;
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Before
//    public void setup() {
//        this.mockMvc = MockMvcBuilders.standaloneSetup(this.ingredientController).build();
//    }
//
//    @Test
//    public void getAll() throws Exception {
//        Mockito.when(ingredientMapper.asDTOList(ArgumentMatchers.any())).thenReturn(IngredientBuilder.getListDTO());
//
//        Mockito.when(ingredientService.findAll()).thenReturn(IngredientBuilder.getListEntities());
//        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content()
//                        .contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));
//
//    }
//
//    @Test
//    public void getById() throws Exception {
//        Mockito.when(ingredientMapper.asDTO(ArgumentMatchers.any())).thenReturn(IngredientBuilder.getDTO());
//
//        Mockito.when(ingredientService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(IngredientBuilder.getEntity()));
//
//        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content()
//                        .contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
//        Mockito.verify(ingredientService, Mockito.times(1)).findById(1L);
//        Mockito.verifyNoMoreInteractions(ingredientService);
//    }
//
//    @Test
//    public void save() throws Exception {
//        Mockito.when(ingredientMapper.asEntity(ArgumentMatchers.any())).thenReturn(IngredientBuilder.getEntity());
//        Mockito.when(ingredientService.save(ArgumentMatchers.any(Ingredient.class))).thenReturn(IngredientBuilder.getEntity());
//
//        mockMvc.perform(
//                MockMvcRequestBuilders.post(ENDPOINT_URL)
//                        .contentType(MediaType.APPLICATION_JSON_UTF8)
//                        .content(CustomUtils.asJsonString(IngredientBuilder.getDTO())))
//                .andExpect(MockMvcResultMatchers.status().isCreated());
//        Mockito.verify(ingredientService, Mockito.times(1)).save(ArgumentMatchers.any(Ingredient.class));
//        Mockito.verifyNoMoreInteractions(ingredientService);
//    }
//
//    @Test
//    public void update() throws Exception {
//        Mockito.when(ingredientMapper.asEntity(ArgumentMatchers.any())).thenReturn(IngredientBuilder.getEntity());
//        Mockito.when(ingredientService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(IngredientBuilder.getEntity());
//
//        mockMvc.perform(
//                MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
//                        .contentType(MediaType.APPLICATION_JSON_UTF8)
//                        .content(CustomUtils.asJsonString(IngredientBuilder.getDTO())))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//        Mockito.verify(ingredientService, Mockito.times(1)).update(ArgumentMatchers.any(Ingredient.class), ArgumentMatchers.anyLong());
//        Mockito.verifyNoMoreInteractions(ingredientService);
//    }
//
//    @Test
//    public void delete() throws Exception {
//        Mockito.doNothing().when(ingredientService).deleteById(ArgumentMatchers.anyLong());
//        mockMvc.perform(
//                MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//        Mockito.verify(ingredientService, Mockito.times(1)).deleteById(Mockito.anyLong());
//        Mockito.verifyNoMoreInteractions(ingredientService);
//    }