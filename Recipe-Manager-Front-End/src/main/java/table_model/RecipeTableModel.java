/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table_model;

import Entities.Recipe;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class RecipeTableModel extends AbstractTableModel {

    private final List<Recipe> recipes;
    private final String column[] = {"ID", "NAME", "SERVING FOR", "PRE-TIME", "COCK-TIME", "PRICE"};

    public RecipeTableModel() {
        recipes = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return recipes.size();
    }

    @Override
    public int getColumnCount() {
        return column.length;
    }

    @Override
    public String getColumnName(int column) {
        return this.column[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex > -1 && rowIndex <= recipes.size()) {
            Recipe r = recipes.get(rowIndex);
            switch (columnIndex) {
                case 0 -> {
                    return r.getId();
                }
                case 1 -> {
                    return r.getRecipe_name();
                }
                case 2 -> {
                    return r.getServing();
                }
                case 3 -> {
                    return r.getPreparation_time();
                }
                case 4 -> {
                    return r.getCock_time();
                }
                case 5 -> {
                    return r.getPrice();
                }
                default ->
                    throw new AssertionError();
            }
        }
        return null;
    }

//    @Override
//    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//        if (rowIndex > -1 && rowIndex <= recipes.size()) {
//            Recipe r = recipes.get(rowIndex);
//            switch (columnIndex) {
//                case 0 -> {
//                    
//                    r.getId();
//                }
//                case 1 -> {
//                    r.getRecipe_name();
//                }
//                case 2 -> {
//                    r.getServing();
//                }
//                case 3 -> {
//                    r.getPreparation_time();
//                }
//                case 4 -> {
//                    r.getCock_time();
//                }
//                case 5 -> {
//                    r.getPrice();
//                }
//                default ->
//                    throw new AssertionError();
//            }
//        }
//    }
    public void addRecipe(Recipe r) {
        recipes.add(r);
        fireTableDataChanged();
    }

    public Recipe getRecipe(int index) {
        return recipes.get(index);
    }

}
