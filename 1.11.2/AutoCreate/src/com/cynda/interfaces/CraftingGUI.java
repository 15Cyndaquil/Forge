package com.cynda.interfaces;

import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;

/**
 * Created by 15Cyndaquil on 3/2/2017.
 */
public class CraftingGUI {

    private static ComboBox topRight = new ComboBox();
    private static ComboBox topMiddle = new ComboBox();
    private static ComboBox topLeft = new ComboBox();

    private static ComboBox midRight = new ComboBox();
    private static ComboBox midMiddle = new ComboBox();
    private static ComboBox midLeft = new ComboBox();

    private static ComboBox bottomRight = new ComboBox();
    private static ComboBox bottomMiddle = new ComboBox();
    private static ComboBox bottomLeft = new ComboBox();

    private static String[] defaultItems;

    public static void createCraftingGUI(GridPane grid){

        grid.getChildren().clear();


    }



    private static void setCraftingGrid(GridPane grid, int cordColumn, int cordRow){

    }

    private static void setDefaultItems(){
        defaultItems = new String[] {
                "Air", "Stone", "Granite", "Polished Granite", "Diorite", "Polished Diorite"
                , "Andesite", "Polished Andesite", "Grass", "Dirt", "Coarse Dirt", "Podzol"
                , "Cobblestone", "Oak Wood Plank", "Spruce Wood Plank", "Birch Wood Plank"
                , "Jungle Wood Plank", "Acacia Wood Plank"};
    }
}
